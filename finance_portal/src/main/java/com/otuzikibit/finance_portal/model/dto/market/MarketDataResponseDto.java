package com.otuzikibit.finance_portal.model.dto.market;

import com.otuzikibit.finance_portal.domains.commodity.dto.CommodityDto;
import com.otuzikibit.finance_portal.domains.crypto.dto.CryptoDto;
import com.otuzikibit.finance_portal.domains.currency.dto.CurrencyDto;
import com.otuzikibit.finance_portal.domains.eurobond.dto.EurobondDto;
import com.otuzikibit.finance_portal.domains.fund.dto.FundDto;
import com.otuzikibit.finance_portal.domains.future.dto.FutureDto;
import com.otuzikibit.finance_portal.domains.stock.dto.StockDto;
import com.otuzikibit.finance_portal.domains.viop.dto.ViopDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketDataResponseDto {
    private List<CurrencyDto> currencies;
    private List<CryptoDto> cryptos;
    private List<CommodityDto> commodities;
    private List<CommodityDto> turkishGold;
    private List<StockDto> stocks;
    private List<StockDto> indices;
    private List<MarketAssetDto> globalBonds;
    private List<Map<String, Object>> trBonds;
    private List<FutureDto> futures;
    private List<ViopDto> viop;
    private List<FundDto> globalFunds;
    private List<FundDto> trFunds;
    private List<EurobondDto> eurobonds;
}
