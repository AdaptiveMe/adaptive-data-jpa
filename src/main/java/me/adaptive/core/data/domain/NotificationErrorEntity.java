package me.adaptive.core.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by panthro on 17/08/15.
 */
@Entity
@Table(name = "notification_error")
@SuppressWarnings("unused")
public class NotificationErrorEntity extends BaseEntity {

    @ManyToOne
    @NotNull
    private NotificationEntity notification;

    @NotNull
    @Column(name = "error")
    private String error;


    public NotificationErrorEntity() {
    }

    public NotificationErrorEntity(NotificationEntity notification, String error) {
        this.notification = notification;
        this.error = error;
    }

    public NotificationEntity getNotification() {
        return notification;
    }

    public void setNotification(NotificationEntity notification) {
        this.notification = notification;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        NotificationErrorEntity that = (NotificationErrorEntity) o;

        if (notification != null ? !notification.equals(that.notification) : that.notification != null) return false;
        return !(error != null ? !error.equals(that.error) : that.error != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (notification != null ? notification.hashCode() : 0);
        result = 31 * result + (error != null ? error.hashCode() : 0);
        return result;
    }


}
