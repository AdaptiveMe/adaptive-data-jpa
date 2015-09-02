package me.adaptive.core.data.repo;

import me.adaptive.core.data.domain.BuildRequestEntity;
import me.adaptive.core.data.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

/**
 * Server information metrics repository
 * <p/>
 * Created by ferranvila on 01/09/15.
 */
@Repository
public interface BuildRequestRepository extends JpaRepository<BuildRequestEntity, Long> {

    Set<BuildRequestEntity> findByStartTimeBetween(Date startTime1, Date startTime2);

    Set<BuildRequestEntity> findByPlatformAndStartTimeBetween(String platform, Date startTime1, Date startTime2);

    Set<BuildRequestEntity> findByRequesterAndStartTimeBetween(UserEntity requester, Date startTime1, Date startTime2);

    Set<BuildRequestEntity> findByPlatformAndRequesterAndStartTimeBetween(String platform, UserEntity requester, Date startTime1, Date startTime2);
}
