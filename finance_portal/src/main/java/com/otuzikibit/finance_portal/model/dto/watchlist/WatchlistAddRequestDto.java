package com.otuzikibit.finance_portal.model.dto.watchlist;

import com.otuzikibit.finance_portal.model.enums.AssetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WatchlistAddRequestDto {

    private String symbol;
    private AssetType assetType;
}
