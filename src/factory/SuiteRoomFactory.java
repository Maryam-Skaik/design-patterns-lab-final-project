package factory;

import model.Room;
import model.SuiteRoom;

/**
 * Concrete Factory for creating Suite Rooms.
 */
public class SuiteRoomFactory extends RoomFactory {

    @Override
    public Room createRoom(int roomNumber) {
        return new SuiteRoom(roomNumber);
    }
}
