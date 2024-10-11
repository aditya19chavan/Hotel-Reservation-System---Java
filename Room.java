package hotelreservationsystem1;

import java.util.*;

// Room class
class Room {
    private int roomId;
    private String roomType;
    private double pricePerNight;
    private boolean availability;

    public Room(int roomId, String roomType, double pricePerNight) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.availability = true; // Initially available
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public String toString() {
        return "Room [roomId=" + roomId + ", roomType=" + roomType + ", pricePerNight=" + pricePerNight
                + ", availability=" + availability + "]";
    }
}



