package observer;

/**
 * Subject interface (Publisher).
 *
 * Defines contract for registering, removing,
 * and notifying observers.
 */
public interface Subject {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(NotificationEvent event);
}
