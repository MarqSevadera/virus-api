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
@Entity(name = "VIRUS")
public class VirusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    private BigInteger id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LINEAGE")
    private String lineage;

    @Column(name = "GENOME_TYPE")
    private String genomeType;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "VIRUS_HOST",
            joinColumns = @JoinColumn(name = "VIRUS_ID"),
            inverseJoinColumns = @JoinColumn(name = "HOST_ID"))
    private List<HostEntity> knownHosts;

    @JoinColumn(name = "VIRAL_FAMILY_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ViralFamilyEntity viralFamily;


}
