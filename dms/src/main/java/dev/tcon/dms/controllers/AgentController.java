package dev.tcon.dms.controllers;

import dev.tcon.dms.entities.Agent;
import dev.tcon.dms.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AgentController {
    private final AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService){
        this.agentService = agentService;
    }

    @GetMapping("/agent")
    public ResponseEntity<List<Agent>> getAll(){return ResponseEntity.ok(agentService.getAll());}
    @GetMapping("/agent/{id}")
    public ResponseEntity<Agent> getById(@PathVariable Long id){
        return ResponseEntity.ok(agentService.getById(id));
    }

    @PostMapping("/agent")
    public ResponseEntity<Agent> getById(@RequestBody Agent agent){
        return ResponseEntity.ok(agentService.create(agent));
    }
}
