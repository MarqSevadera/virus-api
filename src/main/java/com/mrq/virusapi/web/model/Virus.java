package com.mrq.virusapi.web.model;

import com.mrq.virusapi.web.model.validation.groups.UpdateOnlyValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Virus {
    @NotBlank(groups = {UpdateOnlyValidation.class})
    private BigInteger id;

    @NotBlank
    private String name;

    @NotBlank
    private String genomeType;

    @NotBlank
    private String lineage;

    private List<Host> knownHosts;

    @NotNull
    private ViralFamily viralFamily;
}
