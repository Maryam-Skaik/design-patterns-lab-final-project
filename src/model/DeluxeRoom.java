package model;

/**
 * Represents a deluxe hotel room.
 *
 * Deluxe rooms provide additional comfort and amenities.
 */
public class DeluxeRoom extends Room {

    public DeluxeRoom(int roomNumber) {
        super(roomNumber, 180.0, 3, "WiFi, TV, Mini Bar, Balcony");
    }

    @Override
    public String getRoomType() {
        return "Deluxe Room";
    }
}
