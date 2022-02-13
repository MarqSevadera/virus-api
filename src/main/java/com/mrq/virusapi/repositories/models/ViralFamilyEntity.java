package com.mrq.virusapi.repositories.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "VIRAL_FAMILY")
public class ViralFamilyEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private BigInteger id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "viralFamily", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VirusEntity> viruses;
}
