package com.otuzikibit.finance_portal.model.dto.preferences;

import com.otuzikibit.finance_portal.model.enums.TickerScope;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Frontend ile preferences endpoint'i arasında taşınan kapsayıcı DTO.
 * GET: mevcut state. PUT: aynı şekilde tam değiştirir (bulk replace).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPreferencesDto {
    private List<TickerSymbolDto> tickers;
    private TickerScope tickerScope;
}
