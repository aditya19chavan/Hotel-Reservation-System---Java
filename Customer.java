package hotelreservationsystem1;

import java.util.ArrayList;
import java.util.List;

//Customer class
class Customer {
 private String customerId;
 private static long idCounter = 1;
 private String customerName;
 private long contactNumber;
 private List<Room> bookedRooms;

 public Customer(String customerName, long contactNumber) {
     this.customerId = String.format("CUSTOMER%03d", idCounter++);
     this.customerName = customerName;
     this.contactNumber = contactNumber;
     this.bookedRooms = new ArrayList<>();
 }

 public String getCustomerName() {
     return customerName;
 }

 public void setCustomerName(String customerName) {
     this.customerName = customerName;
 }

 public long getContactNumber() {
     return contactNumber;
 }

 public void setContactNumber(long contactNumber) {
     this.contactNumber = contactNumber;
 }

 public String getCustomerId() {
     return customerId;
 }

 public List<Room> getBookedRooms() {
     return bookedRooms;
 }

 // Booking a room
 public void bookRoom(Room room) throws Exception {
     if (room.isAvailable()) {
         bookedRooms.add(room);
         room.setAvailability(false); // Mark room as booked
         System.out.println(customerName + " booked a room " + room.getRoomType());
     } else {
         throw new Exception("Room is not available.");
     }
 }

 // Vacating a room
 public void vacantRoom(Room room) throws Exception {
     if (bookedRooms.contains(room)) {
         bookedRooms.remove(room);
         room.setAvailability(true); // Mark room as available
         System.out.println(customerName + " vacated room " + room.getRoomType());
     } else {
         throw new Exception("Room is not booked by you.");
     }
 }

 @Override
 public String toString() {
     return "Customer [customerId=" + customerId + ", customerName=" + customerName
             + ", contactNumber=" + contactNumber + "]";
 }
}

