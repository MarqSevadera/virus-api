package com.mrq.virusapi.web.model;

import com.mrq.virusapi.web.model.validation.groups.UpdateOnlyValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Host {

    @NotBlank(groups = {UpdateOnlyValidation.class})
    private BigInteger id;

    @NotBlank
    private String name;

    @NotBlank
    private String lineage;

    private List<Virus> knownViruses;
}
