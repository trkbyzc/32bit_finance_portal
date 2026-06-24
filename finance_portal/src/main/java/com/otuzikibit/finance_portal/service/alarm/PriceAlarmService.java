package com.otuzikibit.finance_portal.service.alarm;

import com.otuzikibit.finance_portal.exception.ResourceNotFoundException;
import com.otuzikibit.finance_portal.model.dto.alarm.CreatePriceAlarmRequest;
import com.otuzikibit.finance_portal.model.dto.alarm.PriceAlarmDto;
import com.otuzikibit.finance_portal.model.entity.PriceAlarm;
import com.otuzikibit.finance_portal.model.entity.User;
import com.otuzikibit.finance_portal.model.enums.AlarmFrequency;
import com.otuzikibit.finance_portal.repository.PriceAlarmRepository;
import com.otuzikibit.finance_portal.repository.UserRepository;
import com.otuzikibit.finance_portal.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Kullanıcı fiyat alarmları CRUD. Alarm değerlendirme ve mail gönderimi
 * PriceAlarmEvaluationService tarafında.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PriceAlarmService {

    private final PriceAlarmRepository alarmRepo;
    private final UserRepository userRepo;
    private final SecurityUtils securityUtils;

    @Transactional(readOnly = true)
    public List<PriceAlarmDto> listMyAlarms() {
        UUID userId = securityUtils.getCurrentUserId();
        return alarmRepo.findByUser_IdOrderByCreatedAtDesc(userId).stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional
    public PriceAlarmDto createAlarm(CreatePriceAlarmRequest req) {
        validate(req);
        UUID userId = securityUtils.getCurrentUserId();
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Kullanıcı bulunamadı"));

        PriceAlarm alarm = PriceAlarm.builder()
                .user(user)
                .symbol(req.getSymbol().trim().toUpperCase())
                .assetType(req.getAssetType())
                .condition(req.getCondition())
                .threshold(req.getThreshold())
                .frequency(req.getFrequency() != null ? req.getFrequency() : AlarmFrequency.ONCE)
                .note(req.getNote() != null ? req.getNote().trim() : null)
                .active(true)
                .createdAt(LocalDateTime.now())
                .triggerCount(0)
                .build();
        PriceAlarm saved = alarmRepo.save(alarm);
        log.info("[ALARM] {} kullanıcısı için alarm kuruldu: {} {} {}",
                user.getUsername(), saved.getSymbol(), saved.getCondition(), saved.getThreshold());
        return toDto(saved);
    }

    @Transactional
    public PriceAlarmDto setActive(UUID alarmId, boolean active) {
        PriceAlarm a = requireOwned(alarmId);
        a.setActive(active);
        return toDto(alarmRepo.save(a));
    }

    @Transactional
    public void deleteAlarm(UUID alarmId) {
        alarmRepo.delete(requireOwned(alarmId));
    }

    private void validate(CreatePriceAlarmRequest req) {
        if (req.getSymbol() == null || req.getSymbol().isBlank()) {
            throw new IllegalArgumentException("symbol boş olamaz");
        }
        if (req.getAssetType() == null) throw new IllegalArgumentException("assetType zorunlu");
        if (req.getCondition() == null) throw new IllegalArgumentException("condition zorunlu");
        if (req.getThreshold() == null || req.getThreshold().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("threshold > 0 olmalı");
        }
    }

    // Sahiplik hatası da ResourceNotFoundException fırlatır: başkasının alarm ID'sinin varlığını sızdırmamak için.
    private PriceAlarm requireOwned(UUID alarmId) {
        UUID userId = securityUtils.getCurrentUserId();
        PriceAlarm a = alarmRepo.findById(alarmId)
                .orElseThrow(() -> new ResourceNotFoundException("Alarm bulunamadı"));
        if (a.getUser() == null || !userId.equals(a.getUser().getId())) {
            throw new ResourceNotFoundException("Alarm bulunamadı");
        }
        return a;
    }

    private PriceAlarmDto toDto(PriceAlarm a) {
        return PriceAlarmDto.builder()
                .id(a.getId())
                .symbol(a.getSymbol())
                .assetType(a.getAssetType())
                .condition(a.getCondition())
                .threshold(a.getThreshold())
                .frequency(a.getFrequency())
                .note(a.getNote())
                .active(a.isActive())
                .createdAt(a.getCreatedAt())
                .lastTriggeredAt(a.getLastTriggeredAt())
                .triggerCount(a.getTriggerCount())
                .build();
    }
}
