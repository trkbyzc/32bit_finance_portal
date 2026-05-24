package com.otuzikibit.finance_portal.domains.viop.service;

import com.otuzikibit.finance_portal.domains.viop.client.ViopScraperClient;
import com.otuzikibit.finance_portal.domains.viop.dto.ViopDto;
import com.otuzikibit.finance_portal.service.cache.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViopService {

    private final ViopScraperClient viopScraperClient;
    private final CacheService cacheService;

    public List<ViopDto> getViopData() {
        return cacheService.getOrFetch("cache:viop", viopScraperClient::scrapeViopData, 5);
    }

    @Scheduled(fixedRate = 300000)
    public void fetchViopData() {
        List<ViopDto> list = viopScraperClient.scrapeViopData();
        if (list != null && !list.isEmpty()) cacheService.save("cache:viop", list, 5);
    }
}