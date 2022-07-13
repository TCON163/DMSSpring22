package dev.tcon.dms.controllers;

import dev.tcon.dms.entities.InsuranceMarket;
import dev.tcon.dms.service.InsuranceMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InsuranceMarketController {
    private final InsuranceMarketService insuranceMarketService;

    @Autowired
    public InsuranceMarketController(InsuranceMarketService insuranceMarketService){
        this.insuranceMarketService = insuranceMarketService;
    }

    @GetMapping("/insuranceMarket")
    public ResponseEntity<List<InsuranceMarket>> getAll(){return ResponseEntity.ok(insuranceMarketService.getAll());}
    @GetMapping("/insuranceMarket/{id}")
    public ResponseEntity<InsuranceMarket> getById(@PathVariable Long id){
        return ResponseEntity.ok(insuranceMarketService.getById(id));
    }

    @PostMapping("/insuranceMarket")
    public ResponseEntity<InsuranceMarket> getById(@RequestBody InsuranceMarket insuranceMarket){
        return ResponseEntity.ok(insuranceMarketService.create(insuranceMarket));
    }
}
