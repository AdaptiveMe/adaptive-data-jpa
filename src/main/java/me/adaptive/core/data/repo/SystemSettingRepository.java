package me.adaptive.core.data.repo;

import me.adaptive.core.data.domain.SystemSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by panthro on 27/08/15.
 */
@SuppressWarnings("unused")
@Repository
public interface SystemSettingRepository extends JpaRepository<SystemSetting, Long> {

    List<SystemSetting> findByKeyStartingWith(String keyStart);

    Optional<SystemSetting> findByKey(String key);
}
