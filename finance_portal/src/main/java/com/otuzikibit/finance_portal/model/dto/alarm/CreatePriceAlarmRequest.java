package com.otuzikibit.finance_portal.model.dto.alarm;

import com.otuzikibit.finance_portal.model.enums.AlarmCondition;
import com.otuzikibit.finance_portal.model.enums.AlarmFrequency;
import com.otuzikibit.finance_portal.model.enums.AssetType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreatePriceAlarmRequest {
    private String symbol;
    private AssetType assetType;
    private AlarmCondition condition;
    private BigDecimal threshold;
    private AlarmFrequency frequency;
    private String note;
}
