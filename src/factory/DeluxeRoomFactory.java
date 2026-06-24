package factory;

import model.Room;
import model.DeluxeRoom;

/**
 * Concrete Factory for creating Deluxe Rooms.
 */
public class DeluxeRoomFactory extends RoomFactory {

    @Override
    public Room createRoom(int roomNumber) {
        return new DeluxeRoom(roomNumber);
    }
}
