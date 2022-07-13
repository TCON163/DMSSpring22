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
public class Agency {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String agencyName;

    private Long phoneNumber;


    @ManyToMany
    private Set<Customer> customers = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mail_address_id", referencedColumnName = "id")
    private Address mailAddress;

    @Column
    private Boolean sameMailingAndPhysicalAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physical_address_id", referencedColumnName = "id")
    private Address physicalAddress;

    @OneToMany(mappedBy = "agency")
    private Set<Agent> agents = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_agent_id", referencedColumnName = "id")
    private Agent headAgent;

    @OneToMany(mappedBy = "agency")
    private Set<Submission> submissions = new HashSet<>();
}
