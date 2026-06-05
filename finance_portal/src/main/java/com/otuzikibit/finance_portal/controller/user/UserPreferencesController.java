package com.otuzikibit.finance_portal.controller.user;

import com.otuzikibit.finance_portal.model.dto.preferences.UserPreferencesDto;
import com.otuzikibit.finance_portal.service.user.UserPreferencesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/me/preferences")
@RequiredArgsConstructor
@Tag(name = "Kullanıcı Tercihleri", description = "Market ticker bar'ında gösterilecek varlık listesi + scope (her sayfa / sadece ana sayfa).")
public class UserPreferencesController {

    private final UserPreferencesService preferencesService;

    @GetMapping
    @Operation(summary = "Tercihlerimi Getir")
    public ResponseEntity<UserPreferencesDto> getMyPreferences() {
        return ResponseEntity.ok(preferencesService.getMyPreferences());
    }

    @PutMapping
    @Operation(summary = "Tercihlerimi Güncelle (Bulk Replace)",
            description = "Mevcut ticker listesi tamamen body'deki listeyle değiştirilir; scope da güncellenir. Aynı transaction.")
    public ResponseEntity<UserPreferencesDto> updateMyPreferences(@RequestBody UserPreferencesDto request) {
        return ResponseEntity.ok(preferencesService.updateMyPreferences(request));
    }
}
