package me.adaptive.core.data.repo;

import me.adaptive.core.data.config.JpaConfiguration;
import me.adaptive.core.data.domain.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

/**
 * Created by panthro on 17/08/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JpaConfiguration.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindByAliases() throws Exception {
        String alias = "panthro";
        Optional<UserEntity> user = userRepository.findByAliases(alias);
        assertTrue(user.isPresent());
        assertTrue(user.get().getAliases().contains(alias));
    }

    @Test
    public void testFindByUserId() throws Exception {
        Page<UserEntity> page = userRepository.findAll(new PageRequest(0, 5));
        assertTrue(page.hasContent());
        for (UserEntity user : page) {
            assertTrue(userRepository.findByUserId(user.getUserId()).isPresent());
        }
    }
}