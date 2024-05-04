package com.acn.nemo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "LOCATIONS")
public class Location implements Serializable {
    private static final long serialVersionUID = -4152136715050320918L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCATIONS_SEQ")
    @SequenceGenerator(name = "LOCATIONS_SEQ", sequenceName = "LOCATIONS_SEQ", allocationSize = 100)
    @Column(name = "LOCATION_ID", nullable = false)
    private Short id;

    @Column(name = "STREET_ADDRESS", length = 40)
    private String streetAddress;

    @Column(name = "POSTAL_CODE", length = 12)
    private String postalCode;

    @Column(name = "CITY", nullable = false, length = 30)
    private String city;

    @Column(name = "STATE_PROVINCE", length = 25)
    private String stateProvince;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

}