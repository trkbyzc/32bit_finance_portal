package com.otuzikibit.finance_portal.repository;

import com.otuzikibit.finance_portal.model.entity.SavedChart;
import com.otuzikibit.finance_portal.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SavedChartRepository extends BaseRepository<SavedChart, UUID> {

    List<SavedChart> findByUser_IdOrderByCreatedAtDesc(UUID userId);
}
