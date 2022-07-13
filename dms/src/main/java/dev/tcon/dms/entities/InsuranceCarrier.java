package dev.tcon.dms.entities;

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
public class InsuranceCarrier {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mail_address_id", referencedColumnName = "id")
    private Address mailAddress;

    @Column
    private Boolean sameMailingAndPhysicalAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physical_address_id", referencedColumnName = "id")
    private Address physicalAddress;

    @OneToMany
    private Set<InsuranceMarket> insuranceMarkets = new HashSet<>();

}
