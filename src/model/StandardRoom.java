package model;

/**
 * Represents a standard hotel room.
 *
 * Standard rooms provide basic accommodation features.
 */
public class StandardRoom extends Room {

    public StandardRoom(int roomNumber) {
        super(roomNumber, 100.0, 2, "WiFi, TV");
    }

    @Override
    public String getRoomType() {
        return "Standard Room";
    }
}
