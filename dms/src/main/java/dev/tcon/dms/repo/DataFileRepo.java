package dev.tcon.dms.repo;

import dev.tcon.dms.entities.DataFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataFileRepo extends JpaRepository<DataFile, Long> {
}
