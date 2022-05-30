package dev.tcon.dms.repo;

import dev.tcon.dms.entities.SubmissionFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionFolderRepo extends JpaRepository<SubmissionFolder, Long> {
}
