package com.mrq.virusapi.model;

import com.mrq.virusapi.web.model.Host;
import org.junit.Assert;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.Collections;

@RunWith(SpringRunner.class)
public class HostPOJOTest {
    @Test
    public void testShouldConstruct() {
        Host host = new Host(BigInteger.ONE, "sampleName", "samleLineage", Collections.emptyList());
        Assert.assertTrue(StringUtils.isNotBlank(host.getName()));
        Assert.assertTrue(StringUtils.isNotBlank(host.getLineage()));
        Assert.assertTrue(host.getKnownViruses().isEmpty());

    }
}
