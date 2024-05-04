package com.acn.nemo.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "REGIONS")
public class Region implements Serializable {
    private static final long serialVersionUID = 3828621064221232020L;
    @Id
    @Column(name = "REGION_ID", nullable = false)
    private Long id;

    @Column(name = "REGION_NAME", length = 25)
    private String regionName;

    @OneToMany(mappedBy = "region")
    private Set<Country> countries = new LinkedHashSet<>();

}