package hotelreservationsystem1;

import java.util.Calendar;
import java.util.Date;

//Reservation class
class Reservation {
 private String reservationId;
 private static long idCounter = 100;
 private Date checkInDate;
 private Date checkOutDate;
 private Customer customer;
 private Room room;
 private int numberOfNights;

 public Reservation(Customer customer, Room room, int numberOfNights) {
     this.reservationId = "RES" + idCounter++;
     this.customer = customer;
     this.room = room;
     this.numberOfNights = numberOfNights;
     this.checkInDate = new Date(); // Current date and time

     // Set check-out time after `numberOfNights` days
     Calendar calendar = Calendar.getInstance();
     calendar.setTime(checkInDate);
     calendar.add(Calendar.DATE, numberOfNights);
     this.checkOutDate = calendar.getTime();
 }

 public String getReservationId() {
     return reservationId;
 }

 public Date getCheckInDate() {
     return checkInDate;
 }

 public Date getCheckOutDate() {
     return checkOutDate;
 }

 public void generateReceipt() {
     double totalCost = room.getPricePerNight() * numberOfNights;
     System.out.println("Reservation ID: " + reservationId);
     System.out.println("Customer Name: " + customer.getCustomerName());
     System.out.println("Room Type: " + room.getRoomType());
     System.out.println("Check-in Date: " + checkInDate);
     System.out.println("Check-out Date: " + checkOutDate);
     System.out.println("Number of Nights: " + numberOfNights);
     System.out.println("Total Cost: $" + totalCost);
 }

 @Override
 public String toString() {
     return "Reservation [reservationId=" + reservationId + ", checkInDate=" + checkInDate
             + ", checkOutDate=" + checkOutDate + ", customer=" + customer.toString()
             + ", room=" + room.toString() + "]";
 }
}
