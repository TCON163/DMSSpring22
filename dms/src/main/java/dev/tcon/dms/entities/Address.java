package dev.tcon.dms.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String streetAddressOne;

    @Column
    private String streetAddressTwo;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private int zipCode;


}
