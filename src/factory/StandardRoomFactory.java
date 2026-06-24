package factory;

import model.Room;
import model.StandardRoom;

/**
 * Concrete Factory for creating Standard Rooms.
 */
public class StandardRoomFactory extends RoomFactory {

    @Override
    public Room createRoom(int roomNumber) {
        return new StandardRoom(roomNumber);
    }
}
