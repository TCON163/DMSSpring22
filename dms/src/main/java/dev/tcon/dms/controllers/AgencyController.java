package dev.tcon.dms.controllers;

import dev.tcon.dms.entities.Agency;
import dev.tcon.dms.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AgencyController {
    private final AgencyService agencyService;

    @Autowired
    public AgencyController(AgencyService agencyService){
        this.agencyService = agencyService;
    }

    @GetMapping("/agency")
    public ResponseEntity<List<Agency>> getAll(){return ResponseEntity.ok(agencyService.getAll());}
    @GetMapping("/agency/{id}")
    public ResponseEntity<Agency> getById(@PathVariable Long id){
        return ResponseEntity.ok(agencyService.getById(id));
    }

    @PostMapping("/agency/address/{id}")
    public ResponseEntity<Agency> getById(@RequestBody Agency agency, @PathVariable Long id){
        return ResponseEntity.ok(agencyService.create(agency,id));
    }
}
