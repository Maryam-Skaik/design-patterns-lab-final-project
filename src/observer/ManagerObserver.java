package observer;

/**
 * Concrete Observer: Manager
 *
 * Receives all system-level events.
 */
public class ManagerObserver implements Observer {

    @Override
    public void update(NotificationEvent event) {
        System.out.println("[MANAGER] " + event.getType()
                + " -> " + event.getMessage());
    }
}
