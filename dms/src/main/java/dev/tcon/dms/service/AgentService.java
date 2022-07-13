package dev.tcon.dms.service;

import dev.tcon.dms.entities.Agent;
import dev.tcon.dms.repo.AgencyRepo;
import dev.tcon.dms.repo.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgentService {
    private final AgentRepo agentRepo;

    @Autowired
    public AgentService(AgentRepo agentRepo){
        this.agentRepo =agentRepo;
    }

    public Agent create(Agent agent){
        return agentRepo.save(agent);
    }


    public List<Agent> getAll(){
        return agentRepo.findAll();
    }

    public Agent getById(Long id){return agentRepo.getById(id);}
}
