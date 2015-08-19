package me.adaptive.core.data.repo;

import me.adaptive.core.data.domain.NotificationEntity;
import me.adaptive.core.data.domain.types.NotificationChannel;
import me.adaptive.core.data.domain.types.NotificationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by panthro on 17/08/15.
 */
@SuppressWarnings("unused")
@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

    Page<NotificationEntity> findByStatus(NotificationStatus status, Pageable pageable);

    Page<NotificationEntity> findByChannel(NotificationChannel channel, Pageable page);

    Page<NotificationEntity> findByEvent(String event, Pageable page);

    Page<NotificationEntity> findByChannelAndStatus(NotificationChannel channel, NotificationStatus status, Pageable pageable);

}
