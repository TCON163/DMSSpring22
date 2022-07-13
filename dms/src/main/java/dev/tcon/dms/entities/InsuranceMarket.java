package dev.tcon.dms.entities;

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
public class InsuranceMarket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "ins_carrier_id",nullable = false)
    private InsuranceCarrier insuranceCarrier;






    @Column
    private Boolean admitted;
}
