package model;

/**
 * Represents a hotel booking.
 *
 * A booking stores guest information,
 * selected room, and optional services.
 *
 * This class will later be constructed
 * through the Builder Pattern.
 */
public class Booking {

    private String guestName;
    private Room room;

    private boolean breakfastIncluded;
    private boolean airportPickup;
    private boolean roomUpgrade;

    public Booking() {
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public boolean isAirportPickup() {
        return airportPickup;
    }

    public void setAirportPickup(boolean airportPickup) {
        this.airportPickup = airportPickup;
    }

    public boolean isRoomUpgrade() {
        return roomUpgrade;
    }

    public void setRoomUpgrade(boolean roomUpgrade) {
        this.roomUpgrade = roomUpgrade;
    }

    @Override
    public String toString() {

        return """
                -----------------------------
                BOOKING DETAILS
                -----------------------------
                Guest: %s
                Room: %s
                Breakfast Included: %s
                Airport Pickup: %s
                Room Upgrade: %s
                -----------------------------
                """
                .formatted(
                        guestName,
                        room.getRoomType(),
                        breakfastIncluded,
                        airportPickup,
                        roomUpgrade
                );
    }
}
