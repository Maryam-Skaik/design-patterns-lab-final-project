package model;

/**
 * Abstract base class representing a hotel room.
 *
 * This class defines the common properties shared by all room types.
 * Concrete room implementations provide their own default values.
 */
public abstract class Room {

    protected int roomNumber;
    protected double pricePerNight;
    protected int capacity;
    protected String features;

    public Room(int roomNumber, double pricePerNight, int capacity, String features) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.features = features;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getFeatures() {
        return features;
    }

    /**
     * Returns the room type.
     */
    public abstract String getRoomType();

    @Override
    public String toString() {
        return "Room Type: " + getRoomType() +
                "\nRoom Number: " + roomNumber +
                "\nPrice Per Night: $" + pricePerNight +
                "\nCapacity: " + capacity +
                "\nFeatures: " + features;
    }
}
