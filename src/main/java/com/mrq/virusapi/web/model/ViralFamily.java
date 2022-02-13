package com.mrq.virusapi.web.model;

import com.mrq.virusapi.web.model.Virus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViralFamily {
    private BigInteger id;
    private String name;
    private String description;
    private List<Virus> viruses;
}
