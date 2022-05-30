package dev.tcon.dms.repo;

import dev.tcon.dms.entities.File;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FileRepo extends JpaRepository<File, Long> {


}
