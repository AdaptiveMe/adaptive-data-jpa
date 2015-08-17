package me.adaptive.core.data.repo;

import me.adaptive.core.data.config.JpaConfiguration;
import me.adaptive.core.data.domain.NotificationEntity;
import me.adaptive.core.data.domain.UserEntity;
import me.adaptive.core.data.domain.types.NotificationChannel;
import me.adaptive.core.data.domain.types.NotificationEvent;
import me.adaptive.core.data.domain.types.NotificationStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by panthro on 17/08/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JpaConfiguration.class)
public class NotificationRepositoryTest {

    public static final String USER_ID = "test-uid";

    @Autowired
    UserRepository userRepository;

    @Autowired
    NotificationRepository notificationRepository;

    @Before
    public void setUp() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(USER_ID);
        userEntity.setPasswordHash("new-not-null-hash");
        userEntity = userRepository.save(userEntity);
        assertTrue(userEntity.getId() != null);
    }

    @After
    public void tearDown() throws Exception {
        Optional<UserEntity> userEntity = userRepository.findByUserId(USER_ID);
        assertTrue(userEntity.isPresent());
        userRepository.delete(userEntity.get());
        assertFalse(userRepository.findByUserId(USER_ID).isPresent());

    }

    @Test
    public void createNotificationTest() {
        String destination = "testing";
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setChannel(NotificationChannel.EMAIL);
        notificationEntity.setDestination(destination);
        notificationEntity.setEvent(NotificationEvent.USER_REGISTERED);
        notificationEntity.setStatus(NotificationStatus.CREATED);
        Optional<UserEntity> userEntity = userRepository.findByUserId(USER_ID);
        assertTrue(userEntity.isPresent());
        notificationEntity.setUserNotified(userEntity.get());
        notificationEntity = notificationRepository.save(notificationEntity);
        assertTrue(notificationEntity.getId() != null);
        notificationRepository.delete(notificationEntity);
        assertTrue(notificationRepository.findOne(notificationEntity.getId()) == null);
    }


}