package dev.tcon.dms.service;

import dev.tcon.dms.entities.Agent;
import dev.tcon.dms.repo.AgencyRepo;
import dev.tcon.dms.repo.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class AgentService {
    private final AgentRepo agentRepo;

    @Autowired
    public AgentService(AgentRepo agentRepo){
        this.agentRepo =agentRepo;
    }

    public Agent create(Agent agent){
        return agentRepo.save(agent);
    }
}
