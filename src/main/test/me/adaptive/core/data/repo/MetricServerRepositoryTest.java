package me.adaptive.core.data.repo;

import me.adaptive.core.data.config.JpaConfiguration;
import me.adaptive.core.data.domain.MetricServerEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by panthro on 17/08/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JpaConfiguration.class)
public class MetricServerRepositoryTest {

    @Autowired
    MetricServerRepository metricServerRepository;

    @Test
    public void testGetMetricsHostnameAndMetrics() throws Exception {
        String hostname = "my.adaptive.me";
        String metric = "disk_used";
        Pageable pageable = new PageRequest(0, 10);
        Page<MetricServerEntity> page = metricServerRepository.findByHostnameAndAttributeKey(hostname, metric, pageable);
        assertTrue(page.hasContent());
        for (MetricServerEntity metricServerEntity : page) {
            assertEquals(metricServerEntity.getHostname(), hostname);
            assertTrue(metricServerEntity.getAttributes().containsKey(metric));
        }
    }
}