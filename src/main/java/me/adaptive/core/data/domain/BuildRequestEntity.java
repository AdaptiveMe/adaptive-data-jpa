package me.adaptive.core.data.domain;

import me.adaptive.core.data.domain.types.BuildRequestStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;

/**
 * Created by panthro on 19/08/15.
 */
@Entity
@Table(name = "build_request")
public class BuildRequestEntity extends BaseEntity {

    @ManyToOne
    @NotNull
    private UserEntity requester;

    @ManyToOne
    @NotNull
    private WorkspaceEntity workspace;

    @Column(name = "project_name")
    @NotNull
    private String projectName;

    @NotNull
    @Column(name = "platform")
    private String platform;


    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "status")
    private BuildRequestStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Column(name = "start_time")
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Column(name = "end_time")
    private Date endTime;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    @CollectionTable(name = "build_request_attributes", joinColumns = @JoinColumn(name = "build_request_id"))
    private Map<String, String> attributes;


    public UserEntity getRequester() {
        return requester;
    }

    public void setRequester(UserEntity requester) {
        this.requester = requester;
    }

    public WorkspaceEntity getWorkspace() {
        return workspace;
    }

    public void setWorkspace(WorkspaceEntity workspace) {
        this.workspace = workspace;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public BuildRequestStatus getStatus() {
        return status;
    }

    public void setStatus(BuildRequestStatus status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuildRequestEntity)) return false;
        if (!super.equals(o)) return false;

        BuildRequestEntity that = (BuildRequestEntity) o;

        if (requester != null ? !requester.equals(that.requester) : that.requester != null) return false;
        if (workspace != null ? !workspace.equals(that.workspace) : that.workspace != null) return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;
        if (platform != null ? !platform.equals(that.platform) : that.platform != null) return false;
        if (status != that.status) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        return !(attributes != null ? !attributes.equals(that.attributes) : that.attributes != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (requester != null ? requester.hashCode() : 0);
        result = 31 * result + (workspace != null ? workspace.hashCode() : 0);
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BuildRequestEntity{" +
                "requester=" + requester +
                ", workspace=" + workspace +
                ", projectName='" + projectName + '\'' +
                ", platform='" + platform + '\'' +
                ", status=" + status +
                '}';
    }
}
