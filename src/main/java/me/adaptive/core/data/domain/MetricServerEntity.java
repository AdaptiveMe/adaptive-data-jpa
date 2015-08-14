package me.adaptive.core.data.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

/**
 * Server information metrics
 * <p/>
 * Created by ferranvila on 10/08/15.
 */
@Entity
@Table(
        name = "metrics_server",
        indexes = {
                @Index(name = "idx_hostname", columnList = "hostname", unique = false)
        })
public class MetricServerEntity extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 100, message = "Workspace id can't have more than 100 characters and less than 3")
    @Column(name = "hostname")
    private String hostname;

    /**
     * Possible attributes values:
     * cpu_load, memory_load, disk_usage
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    @CollectionTable(name = "metrics_server_attributes", joinColumns = @JoinColumn(name = "id_event"))
    private Map<String, String> attributes;

    @SuppressWarnings("unused")
    public MetricServerEntity() {
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    @SuppressWarnings("unused")
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getHostname() {
        return hostname;
    }

    @SuppressWarnings("unused")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MetricServerEntity that = (MetricServerEntity) o;

        return !(getHostname() != null ? !getHostname().equals(that.getHostname()) : that.getHostname() != null) && !(getAttributes() != null ? !getAttributes().equals(that.getAttributes()) : that.getAttributes() != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getHostname() != null ? getHostname().hashCode() : 0);
        result = 31 * result + (getAttributes() != null ? getAttributes().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MetricServerEntity{" +
                "hostname='" + hostname + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
