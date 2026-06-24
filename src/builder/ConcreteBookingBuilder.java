package builder;

import model.Booking;
import model.Room;

/**
 * Concrete implementation of BookingBuilder.
 *
 * This class defines how each booking attribute is set.
 * It allows chaining method calls for flexible object construction.
 */
public class ConcreteBookingBuilder extends BookingBuilder {

    @Override
    public ConcreteBookingBuilder setGuestName(String name) {
        booking.setGuestName(name);
        return this;
    }

    @Override
    public ConcreteBookingBuilder setRoom(Room room) {
        booking.setRoom(room);
        return this;
    }

    @Override
    public ConcreteBookingBuilder addBreakfast(boolean value) {
        booking.setBreakfastIncluded(value);
        return this;
    }

    @Override
    public ConcreteBookingBuilder addAirportPickup(boolean value) {
        booking.setAirportPickup(value);
        return this;
    }

    @Override
    public ConcreteBookingBuilder addRoomUpgrade(boolean value) {
        booking.setRoomUpgrade(value);
        return this;
    }
}
