package me.adaptive.core.data.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

/**
 * Build information metrics
 * <p/>
 * Created by ferranvila on 10/08/15.
 */
@Entity
@Table(name = "metrics_build")
public class MetricBuildEntity extends BaseEntity {

    @NotNull
    @Column(name = "task_id")
    private Long taskId;

    @NotNull
    @Size(min = 3, max = 100, message = "Workspace id can't have more than 100 characters and less than 3")
    @Column(name = "workspace_id")
    private String workspaceId;

    @NotNull
    @Size(min = 3, max = 100, message = "Project name can't have more than 100 characters and less than 3")
    @Column(name = "project_name")
    private String projectName;

    /**
     * Possible attributes values:
     * hostname, start_time, end_time, platform, status
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "name", unique = false)
    @Column(name = "value")
    @CollectionTable(name = "metrics_build_attributes", joinColumns = @JoinColumn(name = "id_event"))
    private Map<String, String> attributes;

    @SuppressWarnings("unused")
    public MetricBuildEntity() {
    }

    public Long getTaskId() {
        return taskId;
    }

    @SuppressWarnings("unused")
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getWorkspaceId() {
        return workspaceId;
    }

    @SuppressWarnings("unused")
    public void setWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
    }

    public String getProjectName() {
        return projectName;
    }

    @SuppressWarnings("unused")
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    @SuppressWarnings("unused")
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MetricBuildEntity that = (MetricBuildEntity) o;

        return !(getTaskId() != null ? !getTaskId().equals(that.getTaskId()) : that.getTaskId() != null) && !(getWorkspaceId() != null ? !getWorkspaceId().equals(that.getWorkspaceId()) : that.getWorkspaceId() != null) && !(getProjectName() != null ? !getProjectName().equals(that.getProjectName()) : that.getProjectName() != null) && !(getAttributes() != null ? !getAttributes().equals(that.getAttributes()) : that.getAttributes() != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getTaskId() != null ? getTaskId().hashCode() : 0);
        result = 31 * result + (getWorkspaceId() != null ? getWorkspaceId().hashCode() : 0);
        result = 31 * result + (getProjectName() != null ? getProjectName().hashCode() : 0);
        result = 31 * result + (getAttributes() != null ? getAttributes().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MetricBuildEntity{" +
                "taskId=" + taskId +
                ", workspaceId='" + workspaceId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
