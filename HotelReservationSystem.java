package hotelreservationsystem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//HotelReservationSystem class
public class HotelReservationSystem {
 private List<Room> rooms;
 private List<Customer> customers;
 private List<Reservation> reservations;

 public HotelReservationSystem() {
     rooms = new ArrayList<>();
     customers = new ArrayList<>();
     reservations = new ArrayList<>();
 }

 public void addRoom(Room room) {
     rooms.add(room);
 }

 public void addCustomer(Customer customer) {
     customers.add(customer);
 }

 public void bookRoom(Customer customer, Room room, int numberOfNights) throws Exception {
     customer.bookRoom(room);
     Reservation reservation = new Reservation(customer, room, numberOfNights);
     reservations.add(reservation);
     reservation.generateReceipt();
 }

 public void vacantRoom(Customer customer, Room room) throws Exception {
     customer.vacantRoom(room);
 }

 public void displayRooms() {
     for (Room room : rooms) {
         System.out.println(room);
     }
 }

 public void displayCustomers() {
     for (Customer customer : customers) {
         System.out.println(customer);
     }
 }

 public void displayReservations() {
     for (Reservation reservation : reservations) {
         System.out.println(reservation);
     }
 }

 // Main method
 public static void main(String[] args) {
     HotelReservationSystem system = new HotelReservationSystem();
     Scanner scanner = new Scanner(System.in);

     while (true) {
         System.out.println("1. Add Room");
         System.out.println("2. Add Customer");
         System.out.println("3. Book Room");
         System.out.println("4. Vacant Room");
         System.out.println("5. Display Rooms");
         System.out.println("6. Display Customers");
         System.out.println("7. Display Reservations");
         System.out.println("8. Exit");

         int choice = scanner.nextInt();
         switch (choice) {
             case 1:
                 System.out.println("Enter room type:");
                 String roomType = scanner.next();
                 System.out.println("Enter price per night:");
                 double pricePerNight = scanner.nextDouble();
                 Room room = new Room(system.rooms.size() + 1, roomType, pricePerNight);
                 system.addRoom(room);
                 break;
             case 2:
                 System.out.println("Enter customer name:");
                 String customerName = scanner.next();
                 System.out.println("Enter contact number:");
                 long contactNumber = scanner.nextLong();
                 Customer customer = new Customer(customerName, contactNumber);
                 system.addCustomer(customer);
                 break;
             case 3:
                 System.out.println("Enter customer ID:");
                 String customerId = scanner.next();
                 System.out.println("Enter room ID:");
                 int roomId = scanner.nextInt();
                 System.out.println("Enter number of nights:");
                 int numberOfNights = scanner.nextInt();

                 Customer foundCustomer = null;
                 Room foundRoom = null;

                 for (Customer c : system.customers) {
                     if (c.getCustomerId().equals(customerId)) {
                         foundCustomer = c;
                         break;
                     }
                 }
                 for (Room r : system.rooms) {
                     if (r.getRoomId() == roomId) {
                         foundRoom = r;
                         break;
                     }
                 }

                 if (foundCustomer != null && foundRoom != null) {
                     try {
                         system.bookRoom(foundCustomer, foundRoom, numberOfNights);
                     } catch (Exception e) {
                         System.out.println(e.getMessage());
                     }
                 } else {
                     System.out.println("Customer or room not found.");
                 }
                 break;
             case 4:
                 System.out.println("Enter customer ID:");
                 customerId = scanner.next();
                 System.out.println("Enter room ID:");
                 roomId = scanner.nextInt();

                 Customer vacantCustomer = null;
                 Room vacantRoom = null;

                 for (Customer c : system.customers) {
                     if (c.getCustomerId().equals(customerId)) {
                         vacantCustomer = c;
                         break;
                     }
                 }
                 for (Room r : system.rooms) {
                     if (r.getRoomId() == roomId) {
                         vacantRoom = r;
                         break;
                     }
                 }

                 if (vacantCustomer != null && vacantRoom != null) {
                     try {
                         system.vacantRoom(vacantCustomer, vacantRoom);
                     } catch (Exception e) {
                         System.out.println(e.getMessage());
                     }
                 } else {
                     System.out.println("Customer or room not found.");
                 }
                 break;
             case 5:
                 system.displayRooms();
                 break;
             case 6:
                 system.displayCustomers();
                 break;
             case 7:
                 system.displayReservations();
                 break;
             case 8:
                 scanner.close();
                 System.exit(0);
                 break;
             default:
                 System.out.println("Invalid option. Try again.");
                 break;
         }
     }
 }
}
