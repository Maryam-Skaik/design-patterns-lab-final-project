package factory;

import model.Room;

/**
 * Abstract Factory (Factory Method Pattern).
 *
 * Defines the contract for creating Room objects.
 * Each concrete factory will decide which room type to create.
 */
public abstract class RoomFactory {

    /**
     * Factory Method:
     * Subclasses must implement this to create specific room types.
     */
    public abstract Room createRoom(int roomNumber);
}
