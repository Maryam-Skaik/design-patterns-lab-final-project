package observer;

/**
 * Represents an event that triggers notifications.
 *
 * Contains:
 * - event type
 * - message
 */
public class NotificationEvent {

    private final EventType type;
    private final String message;

    public NotificationEvent(EventType type, String message) {
        this.type = type;
        this.message = message;
    }

    public EventType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
