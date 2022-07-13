package dev.tcon.dms.entities;

import dev.tcon.dms.enums.LineOfBusiness;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Policy {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "submission_id", referencedColumnName = "id")
    private Submission submission;


    @ManyToOne
    @JoinColumn(name = "ins_market_id", nullable = false)
    private InsuranceMarket insuranceMarket;

    @Column
    private String policyNumber;

    @Enumerated(EnumType.STRING)
    private LineOfBusiness lineOfBusiness;

    @Column
    private Double premium;

    @Column
    private Double fees;

    @Column
    private Double taxes;

    @Column
    private Date effectiveDate;

    @Column
    private Date expirationDate;






}
