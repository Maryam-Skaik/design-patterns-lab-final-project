package builder;

import model.Booking;
import model.Room;

/**
 * Builder Pattern (Abstract Builder)
 *
 * Defines the steps required to construct a Booking object.
 * Allows flexible and incremental object creation.
 */
public abstract class BookingBuilder {

    protected Booking booking;

    public BookingBuilder() {
        this.booking = new Booking();
    }

    public abstract BookingBuilder setGuestName(String name);

    public abstract BookingBuilder setRoom(Room room);

    public abstract BookingBuilder addBreakfast(boolean value);

    public abstract BookingBuilder addAirportPickup(boolean value);

    public abstract BookingBuilder addRoomUpgrade(boolean value);

    /**
     * Final step: returns the fully constructed Booking object.
     */
    public Booking build() {
        return booking;
    }
}
