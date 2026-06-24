package observer;

/**
 * Observer interface (Subscriber).
 *
 * Any class that wants to receive notifications
 * must implement this interface.
 */
public interface Observer {

    void update(NotificationEvent event);
}
