package com.otuzikibit.finance_portal.repository;

import com.otuzikibit.finance_portal.model.entity.Portfolio;
import com.otuzikibit.finance_portal.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PortfolioRepository extends BaseRepository<Portfolio, UUID> {

    List<Portfolio> findByUser_IdOrderByCreatedAtAsc(UUID userId);

    long countByUser_Id(UUID userId);
}
