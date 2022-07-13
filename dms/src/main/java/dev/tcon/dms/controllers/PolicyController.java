package dev.tcon.dms.controllers;

import dev.tcon.dms.entities.Policy;
import dev.tcon.dms.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PolicyController {
    private final PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService){
        this.policyService = policyService;
    }

    @GetMapping("/policy")
    public ResponseEntity<List<Policy>> getAll(){return ResponseEntity.ok(policyService.getAll());}
    @GetMapping("/policy/{id}")
    public ResponseEntity<Policy> getById(@PathVariable Long id){
        return ResponseEntity.ok(policyService.getById(id));
    }

    @PostMapping("/policy")
    public ResponseEntity<Policy> getById(@RequestBody Policy policy){
        return ResponseEntity.ok(policyService.create(policy));
    }
}
