package observer;

/**
 * Concrete Observer: Guest
 *
 * Receives notifications related to bookings,
 * check-in, payment, and check-out events.
 */
public class GuestObserver implements Observer {

    private String guestName;

    public GuestObserver(String guestName) {
        this.guestName = guestName;
    }

    @Override
    public void update(NotificationEvent event) {
        System.out.println("[GUEST: " + guestName + "] " + event.getType()
                + " -> " + event.getMessage());
    }
}
