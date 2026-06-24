package com.otuzikibit.finance_portal.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequestDto {
    private String oldPassword;
    private String newPassword;
}
