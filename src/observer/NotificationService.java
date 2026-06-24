package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject (Publisher).
 *
 * Responsible for managing observers and broadcasting events.
 * Completely decoupled from business logic.
 */
public class NotificationService implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(NotificationEvent event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}
