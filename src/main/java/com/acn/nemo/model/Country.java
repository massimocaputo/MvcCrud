package com.acn.nemo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "COUNTRIES")
public class Country implements Serializable {
    private static final long serialVersionUID = -1661850980753085102L;

    @Id
    @Column(name = "COUNTRY_ID", nullable = false, length = 2)
    private String countryId;

    @Column(name = "COUNTRY_NAME", length = 40)
    private String countryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @OneToMany(mappedBy = "country")
    private Set<Location> locations = new LinkedHashSet<>();

}