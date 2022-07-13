package dev.tcon.dms.repo;

import dev.tcon.dms.entities.InsuranceCarrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceCarrierRepo extends JpaRepository<InsuranceCarrier,Long> {
}
