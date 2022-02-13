package com.mrq.virusapi.repositories.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity(name = "HOST")
public class HostEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private BigInteger id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LINEAGE")
    private String lineage;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "VIRUS_HOST",
            joinColumns = @JoinColumn(name = "HOST_ID"),
            inverseJoinColumns = @JoinColumn(name = "VIRUS_ID")
    )
    private List<VirusEntity> knownViruses;
}
