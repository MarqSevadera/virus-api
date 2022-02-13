package com.mrq.virusapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrq.virusapi.services.ViralFamilyService;
import com.mrq.virusapi.web.controller.ViralFamilyController;
import com.mrq.virusapi.web.exceptions.EntityNotFoundException;
import com.mrq.virusapi.web.model.ViralFamily;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ViralFamilyController.class)
@RunWith(SpringRunner.class)
public class ViralFamilyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ViralFamilyService viralFamilyService;

    private ViralFamily fam1;
    private ViralFamily fam2;

    @Before
    public void init() {
        fam1 = new ViralFamily(BigInteger.ONE, "famName1", "description1", Collections.emptyList());
        fam2 = new ViralFamily(BigInteger.TEN, "famName2", "description2", Collections.emptyList());
    }

    @Test
    public void getViralFamily_shouldReturnViralFamily() throws Exception {
        Mockito.when(viralFamilyService.findById(BigInteger.ONE))
                .thenReturn(fam1);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/viral-families/1").contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("data").isNotEmpty())
                .andExpect(jsonPath("$.['data'].['id']").value(BigInteger.ONE))
                .andExpect(jsonPath("$.['data'].['name']").value(fam1.getName()))
                .andExpect(jsonPath("$.['data'].['description']").value(fam1.getDescription()))
                .andExpect(jsonPath("$.['data'].['viruses']").isEmpty());
    }

    @Test
    public void getListOfViralFamilies_shouldReturnListOfViralFamily() throws Exception {
        Pageable pageRequest = PageRequest.of(0, 10, Sort.by("name").ascending());
        PageImpl<ViralFamily> pageImpl = new PageImpl<>(Arrays.asList(fam1, fam2), pageRequest, 2);

        Mockito.when(viralFamilyService.list(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(pageImpl);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/viral-families"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("data").isArray())
                .andExpect(jsonPath("pageNum").value(0))
                .andExpect(jsonPath("pageSize").value(10))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("numberOfElements").value(2))
                .andExpect(jsonPath("totalPages").value(1));
    }


    @Test
    public void getNonExistentViralFamily_shouldThrowEntityNotFoundException() throws Exception {
        Mockito.when(viralFamilyService.findById(BigInteger.ONE))
                .thenThrow(new EntityNotFoundException("ViralFamily not found!"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/viral-families/1"))
                .andExpect(status().isNotFound());
    }

}
