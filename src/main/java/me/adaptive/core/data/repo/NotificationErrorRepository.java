package me.adaptive.core.data.repo;

import me.adaptive.core.data.domain.NotificationErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by panthro on 17/08/15.
 */
@Repository
public interface NotificationErrorRepository extends JpaRepository<NotificationErrorEntity, Long> {
}
