/*
 * Copyright 2014-2015. Adaptive.me.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.adaptive.core.data.repo;

import me.adaptive.core.data.domain.MetricServerEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Server information metrics repository
 * <p/>
 * Created by ferranvila on 10/08/15.
 */
@Repository
public interface MetricServerRepository extends JpaRepository<MetricServerEntity, Long>, JpaSpecificationExecutor<MetricServerEntity> {

    /**
     select ms.created_at, msa.value from metrics_server ms
     join metrics_server_attributes msa on ms.id=msa.id_event
     where ms.hostname = 'my.adaptive.me'
     and msa.name = 'disk_used'
     order by ms.created_at desc
     limit 20;
     */

    // @Query("select ms, msa from MetricServerEntity ms inner join ms.attributes msa where ms.hostname = :hostname and msa.name = :metric")
    // @Query("select ms from MetricServerEntity ms where ms.hostname = ?1 and ms.id = (select msa from ms.attributes msa where msa.name = ?2)")
    @Query("select ms from MetricServerEntity ms join ms.attributes msa")
    Set<MetricServerEntity> getMetricsHostnameAndMetrics(String hostname, String metric, PageRequest pageRequest);

}
