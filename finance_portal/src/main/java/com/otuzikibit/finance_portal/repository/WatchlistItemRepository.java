package com.otuzikibit.finance_portal.repository;

import com.otuzikibit.finance_portal.model.entity.WatchlistItem;
import com.otuzikibit.finance_portal.model.enums.AssetType;
import com.otuzikibit.finance_portal.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WatchlistItemRepository extends BaseRepository<WatchlistItem, UUID> {

    List<WatchlistItem> findByUser_IdOrderByAddedAtDesc(UUID userId);

    Optional<WatchlistItem> findByUser_IdAndSymbolAndAssetType(UUID userId, String symbol, AssetType assetType);

    Optional<WatchlistItem> findByIdAndUser_Id(UUID id, UUID userId);
}
