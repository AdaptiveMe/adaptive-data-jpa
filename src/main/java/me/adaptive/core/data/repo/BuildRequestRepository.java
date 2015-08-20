package me.adaptive.core.data.repo;

import me.adaptive.core.data.domain.BuildRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by panthro on 20/08/15.
 */
@Repository
public interface BuildRequestRepository extends JpaRepository<BuildRequestEntity, Long> {

}
