package dev.tcon.dms.repo;

import dev.tcon.dms.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepo extends JpaRepository<Agent,Long> {
}
