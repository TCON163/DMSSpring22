package dev.tcon.dms.repo;

import dev.tcon.dms.entities.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepo extends JpaRepository<Quote,Long> {
}
