package com.otuzikibit.finance_portal.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Toggle2FAResponseDto {
    private boolean enabled;
    private String message;
}
