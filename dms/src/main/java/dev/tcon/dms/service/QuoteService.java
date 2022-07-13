package dev.tcon.dms.service;

import dev.tcon.dms.entities.Quote;
import dev.tcon.dms.repo.QuoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {


    private final QuoteRepo quoteRepo;
    @Autowired
    public QuoteService(QuoteRepo quoteRepo){
        this.quoteRepo =quoteRepo;
    }

    public Quote create(Quote quote){
        return quoteRepo.save(quote);
    }
}
