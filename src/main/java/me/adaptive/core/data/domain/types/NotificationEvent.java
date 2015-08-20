package me.adaptive.core.data.domain.types;

/**
 * Interface to hold the known Events that may be notified
 *
 * Created by panthro on 17/08/15.
 */
public interface NotificationEvent {


    /**
     * When the user is registered
     */
    String USER_REGISTERED = "USER_REGISTERED";

    /**
     * When the user Activates it's account
     */
    String USER_ACTIVATED = "USER_ACTIVATED";

    /**
     * When a user forgets it's password
     */
    String FORGOT_PASSWORD = "FORGOT_PASSWORD";
}
