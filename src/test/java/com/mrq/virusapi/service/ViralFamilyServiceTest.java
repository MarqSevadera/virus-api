package com.mrq.virusapi.service;

import com.mrq.virusapi.repositories.dao.ViralFamilyJpaRepository;
import com.mrq.virusapi.repositories.models.ViralFamilyEntity;
import com.mrq.virusapi.services.ViralFamilyService;
import com.mrq.virusapi.web.exceptions.EntityNotFoundException;
import com.mrq.virusapi.web.model.ViralFamily;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
public class ViralFamilyServiceTest {
    @Mock
    private ViralFamilyJpaRepository viralFamilyJpaRepository;

    private ViralFamilyService viralFamilyService;

    private ViralFamilyEntity fam1;
    private ViralFamilyEntity fam2;

    @Before
    public void init() {
        fam1 = new ViralFamilyEntity(BigInteger.ONE, "famName1", "description1", Collections.emptyList());
        fam2 = new ViralFamilyEntity(BigInteger.TEN, "famName2", "description2", Collections.emptyList());
        viralFamilyService = new ViralFamilyService(viralFamilyJpaRepository);
    }


    @Test
    public void getViralFamilyById_shouldReturnViralFamilyInfo() {
        Mockito.when(viralFamilyJpaRepository.findById(BigInteger.ONE))
                .thenReturn(Optional.of(fam1));

        ViralFamily viralFamily = viralFamilyService.findById(BigInteger.ONE);
        assertThat(viralFamily.getName(), Matchers.equalToIgnoringCase(fam1.getName()));
        assertThat(viralFamily.getDescription(), Matchers.equalTo(fam1.getDescription()));
        Assert.assertTrue(viralFamily.getViruses().isEmpty());
    }

    @Test(expected = EntityNotFoundException.class)
    public void getNonExistentViralFamily_shouldThrowEntityNotFoundException() {
        Mockito.when(viralFamilyJpaRepository.findById(BigInteger.ONE))
                .thenReturn(Optional.empty());
        viralFamilyJpaRepository.findById(BigInteger.ONE);
    }

    @Test
    public void list_shouldReturnListOfViralFamily() {

        Mockito.when(viralFamilyJpaRepository.findAll())
                .thenReturn(Arrays.asList(fam1, fam2));

        Page<ViralFamily> page = viralFamilyService.list(0, 30);

        Assert.assertEquals(0, page.getTotalElements());
        Assert.assertEquals(0, page.getNumber());
        Assert.assertEquals(30, page.getSize());
    }
}
