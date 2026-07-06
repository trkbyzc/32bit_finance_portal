package com.otuzikibit.finance_portal.controller.market;

import com.otuzikibit.finance_portal.domains.bond.service.BondService;
import com.otuzikibit.finance_portal.domains.turkish_bond.service.TurkishBondService;
import com.otuzikibit.finance_portal.domains.eurobond.service.EurobondService;
import com.otuzikibit.finance_portal.domains.fund.service.FundService;
import com.otuzikibit.finance_portal.domains.future.service.FutureService;
import com.otuzikibit.finance_portal.domains.stock.service.StockService;
import com.otuzikibit.finance_portal.domains.viop.service.ViopService;
import com.otuzikibit.finance_portal.domains.currency.service.CurrencyService;
import com.otuzikibit.finance_portal.domains.crypto.service.CryptoService;
import com.otuzikibit.finance_portal.domains.commodity.service.CommodityService;
import com.otuzikibit.finance_portal.model.dto.market.MarketDataResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/market-data")
@RequiredArgsConstructor
@Tag(name = "Ana Pano (Dashboard)", description = "Tüm piyasa verilerini tek seferde toplayan aggregator")
public class MarketDataController {

    private final StockService stockService;
    private final BondService bondService;
    private final TurkishBondService turkishBondService;
    private final EurobondService eurobondService;
    private final FutureService futureService;
    private final ViopService viopService;
    private final FundService fundService;

    private final CurrencyService currencyService;
    private final CryptoService cryptoService;
    private final CommodityService commodityService;

    @GetMapping("/all")
    @Operation(summary = "Tüm Piyasa Verilerini Tek Seferde Getir")
    public ResponseEntity<MarketDataResponseDto> getAllMarketData() {
        return ResponseEntity.ok(MarketDataResponseDto.builder()
                .currencies(currencyService.getCurrencyRates())
                .cryptos(cryptoService.getCryptoRates())
                .commodities(commodityService.getCommodities())
                .turkishGold(commodityService.getTurkishGold())
                .stocks(stockService.getStocks())
                .indices(stockService.getIndices())
                .globalBonds(bondService.getGlobalBonds())
                .trBonds(turkishBondService.getTurkishBonds())
                .futures(futureService.getFutures())
                .viop(viopService.getViopData())
                .globalFunds(fundService.getGlobalFunds())
                .trFunds(fundService.getTrFunds())
                .eurobonds(eurobondService.getEurobondList())
                .build());
    }
}
