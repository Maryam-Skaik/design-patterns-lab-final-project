package model;

/**
 * Represents a luxury suite room.
 *
 * Suites provide premium services and larger capacity.
 */
public class SuiteRoom extends Room {

    public SuiteRoom(int roomNumber) {
        super(roomNumber, 300.0, 5, "WiFi, TV, Mini Bar, Balcony, Living Area, Jacuzzi");
    }

    @Override
    public String getRoomType() {
        return "Suite Room";
    }
}
