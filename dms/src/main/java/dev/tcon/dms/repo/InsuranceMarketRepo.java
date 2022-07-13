package dev.tcon.dms.repo;

import dev.tcon.dms.entities.InsuranceMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceMarketRepo extends JpaRepository<InsuranceMarket, Long> {
}
