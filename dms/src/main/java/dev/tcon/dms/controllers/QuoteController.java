package dev.tcon.dms.controllers;

import dev.tcon.dms.entities.Quote;
import dev.tcon.dms.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class QuoteController {
    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
    }

    @GetMapping("/quote")
    public ResponseEntity<List<Quote>> getAll(){return ResponseEntity.ok(quoteService.getAll());}
    @GetMapping("/quote/{id}")
    public ResponseEntity<Quote> getById(@PathVariable Long id){
        return ResponseEntity.ok(quoteService.getById(id));
    }

    @PostMapping("/quote")
    public ResponseEntity<Quote> getById(@RequestBody Quote quote){
        return ResponseEntity.ok(quoteService.create(quote));
    }
}
