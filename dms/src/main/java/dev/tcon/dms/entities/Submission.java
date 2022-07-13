package dev.tcon.dms.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.tcon.dms.enums.LineOfBusiness;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Submission {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Customer customer;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Agency agency;


    @Enumerated(EnumType.STRING)
    private LineOfBusiness lineOfBusiness;

    @OneToOne(mappedBy = "submission")
    private Policy policy;

    @OneToMany
    private Set<Quote> quotes = new HashSet<>();

    @OneToMany
    private Set<File> files = new HashSet<>();
}
