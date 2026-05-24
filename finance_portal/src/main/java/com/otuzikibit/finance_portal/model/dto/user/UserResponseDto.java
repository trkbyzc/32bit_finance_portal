package com.otuzikibit.finance_portal.model.dto.user;

import com.otuzikibit.finance_portal.model.enums.RiskProfile; // 🚀 IMPORT ŞART
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserResponseDto {
    private UUID id;
    private String name;
    private String email;
    private com.otuzikibit.finance_portal.model.enums.RiskProfile riskProfile; // 🚀 BU EKSİKTİ
    private java.time.LocalDateTime createdAt;
}