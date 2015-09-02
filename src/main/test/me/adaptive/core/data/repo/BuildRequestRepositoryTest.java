package me.adaptive.core.data.repo;

import me.adaptive.core.data.config.JpaConfiguration;
import me.adaptive.core.data.domain.BuildRequestEntity;
import me.adaptive.core.data.domain.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Build Request Repository tests
 * <p/>
 * Created by ferranvila on 01/09/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JpaConfiguration.class)
public class BuildRequestRepositoryTest {

    @Autowired
    BuildRequestRepository buildRequestRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void testGetBuildsByPlatform() throws Exception {

        String platform = "android";
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date date1 = cal.getTime();
        Date date2 = Calendar.getInstance().getTime();

        Set<BuildRequestEntity> results = buildRequestRepository.findByPlatformAndStartTimeBetween(platform, date1, date2);

        assertTrue(results.size() > 0); // MARK: we can't assure that
        for (BuildRequestEntity buildRequestEntity : results) {
            assertEquals(buildRequestEntity.getPlatform(), platform);
        }
    }

    @Test
    public void testGetBuildsByRequester() throws Exception {

        UserEntity userEntity = userRepository.findOne((long) 1);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date date1 = cal.getTime();
        Date date2 = Calendar.getInstance().getTime();

        Set<BuildRequestEntity> results = buildRequestRepository.findByRequesterAndStartTimeBetween(userEntity, date1, date2);

        assertTrue(results.size() > 0); // MARK: we can't assure that
        for (BuildRequestEntity buildRequestEntity : results) {
            assertEquals(buildRequestEntity.getRequester(), userEntity);
        }
    }

    @Test
    public void testGetBuildsByRequesterAndPlatform() throws Exception {

        UserEntity userEntity = userRepository.findOne((long) 1);

        String platform = "android";

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date date1 = cal.getTime();
        Date date2 = Calendar.getInstance().getTime();

        Set<BuildRequestEntity> results = buildRequestRepository.findByPlatformAndRequesterAndStartTimeBetween(platform, userEntity, date1, date2);

        assertTrue(results.size() > 0); // MARK: we can't assure that
        for (BuildRequestEntity buildRequestEntity : results) {
            assertEquals(buildRequestEntity.getRequester(), userEntity);
            assertEquals(buildRequestEntity.getPlatform(), platform);
        }
    }
}