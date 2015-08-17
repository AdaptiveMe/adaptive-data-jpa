package me.adaptive.core.data.domain;

import me.adaptive.core.data.domain.types.NotificationChannel;
import me.adaptive.core.data.domain.types.NotificationEvent;
import me.adaptive.core.data.domain.types.NotificationStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by panthro on 17/08/15.
 * Entity to store all kinds of notifications
 */
@Entity
@Table(name = "notification")
public class NotificationEntity extends BaseEntity {

    /**
     * The channel of the notification
     * eg: Email, Sms, Push notification, etc
     */
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "channel")
    private NotificationChannel channel;

    /**
     * Even upon the notification has been created
     */
    @Column(name = "event")
    @Enumerated(EnumType.STRING)
    @NotNull
    private NotificationEvent event;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private NotificationStatus status;


    /**
     * The destination of the notification
     * eg: an Email address, a Device ID (push notification), A phone number (sms), etc
     */
    @NotNull
    @Column(name = "destination")
    private String destination;

    /**
     * The user that has been notified of that event
     * It may be null in cases like Administration notifications
     */
    @ManyToOne
    private UserEntity userNotified;

    /**
     * The Date and Time which the notification was actually sent, not when it was created
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Column(name = "sent", insertable = false, updatable = true)
    private Date sentDate;

    public NotificationChannel getChannel() {
        return channel;
    }

    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }

    public NotificationEvent getEvent() {
        return event;
    }

    public void setEvent(NotificationEvent event) {
        this.event = event;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public UserEntity getUserNotified() {
        return userNotified;
    }

    public void setUserNotified(UserEntity userNotified) {
        this.userNotified = userNotified;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        NotificationEntity that = (NotificationEntity) o;

        if (channel != that.channel) return false;
        if (event != that.event) return false;
        if (status != that.status) return false;
        if (destination != null ? !destination.equals(that.destination) : that.destination != null) return false;
        if (userNotified != null ? !userNotified.equals(that.userNotified) : that.userNotified != null) return false;
        return !(sentDate != null ? !sentDate.equals(that.sentDate) : that.sentDate != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (channel != null ? channel.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (userNotified != null ? userNotified.hashCode() : 0);
        result = 31 * result + (sentDate != null ? sentDate.hashCode() : 0);
        return result;
    }

}
