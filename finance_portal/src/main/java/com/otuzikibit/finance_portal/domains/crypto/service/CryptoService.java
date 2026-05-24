package com.otuzikibit.finance_portal.domains.crypto.service;

import com.otuzikibit.finance_portal.domains.crypto.client.CoinGeckoClient;
import com.otuzikibit.finance_portal.domains.crypto.dto.CryptoDto;
import com.otuzikibit.finance_portal.service.cache.CacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CryptoService {

    private final CoinGeckoClient coinGeckoClient;
    private final CacheService cacheService;

    public List<CryptoDto> getCryptoRates() {
        return cacheService.getOrFetch("cache:crypto", coinGeckoClient::fetchCryptoRates, 5);
    }
}