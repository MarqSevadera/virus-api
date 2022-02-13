package com.mrq.virusapi.model;

import com.mrq.virusapi.web.model.ViralFamily;
import org.junit.Assert;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.Collections;

@RunWith(SpringRunner.class)
public class ViralFamilyPOJOTest {

    @Test
    public void testShouldConstruct() {
        ViralFamily viralFamily = new ViralFamily(BigInteger.ONE, "sampleName", "sampleDescription", Collections.emptyList());
        Assert.assertNotNull(viralFamily.getId());
        Assert.assertTrue(StringUtils.isNotBlank(viralFamily.getName()));
        Assert.assertTrue((StringUtils.isNotBlank(viralFamily.getDescription())));
        Assert.assertTrue(viralFamily.getViruses().isEmpty());
    }
}
