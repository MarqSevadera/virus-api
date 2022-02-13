package com.mrq.virusapi.model;

import com.mrq.virusapi.web.model.ViralFamily;
import com.mrq.virusapi.web.model.Virus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.Collections;

@RunWith(SpringRunner.class)
public class VirusPOJOTest {

    @Test
    public void testShouldConstruct() {
        Virus virus = new Virus(BigInteger.ONE, "sampleName", "sampleGenome", "sampleLineage", Collections.emptyList(), new ViralFamily());
        Assert.assertNotNull(virus.getId());
        Assert.assertTrue(StringUtils.isNotBlank(virus.getName()));
        Assert.assertTrue((StringUtils.isNotBlank(virus.getGenomeType())));
        Assert.assertTrue(StringUtils.isNotBlank(virus.getLineage()));
        Assert.assertTrue(virus.getKnownHosts().isEmpty());
        Assert.assertNotNull(virus.getViralFamily());
    }
}
