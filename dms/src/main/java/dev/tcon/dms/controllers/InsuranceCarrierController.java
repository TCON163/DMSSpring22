package dev.tcon.dms.controllers;

import dev.tcon.dms.entities.InsuranceCarrier;
import dev.tcon.dms.service.InsuranceCarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InsuranceCarrierController {
    private final InsuranceCarrierService insuranceCarrierService;

    @Autowired
    public InsuranceCarrierController(InsuranceCarrierService insuranceCarrierService){
        this.insuranceCarrierService = insuranceCarrierService;
    }

    @GetMapping("/insuranceCarrier")
    public ResponseEntity<List<InsuranceCarrier>> getAll(){return ResponseEntity.ok(insuranceCarrierService.getAll());}
    @GetMapping("/insuranceCarrier/{id}")
    public ResponseEntity<InsuranceCarrier> getById(@PathVariable Long id){
        return ResponseEntity.ok(insuranceCarrierService.getById(id));
    }

    @PostMapping("/insuranceCarrier")
    public ResponseEntity<InsuranceCarrier> getById(@RequestBody InsuranceCarrier insuranceCarrier){
        return ResponseEntity.ok(insuranceCarrierService.create(insuranceCarrier));
    }
}
