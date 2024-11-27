package hotel_usecase;

import java.util.List;
import java.util.Scanner;

import hotel_Servimpli.HotelServImpli;
import hotel_Servimpli.RoomServImpli;
import hotel_exception.GuestException;
import hotel_exception.RoomException;
import hotel_model.Guest;
import hotel_model.Hotel;
import hotel_model.Room;
import hotel_serv.HotelServ;
import hotel_serv.RoomServ;

public class Ruse {
    public static Scanner sc = new Scanner(System.in);
    public static RoomServ rs = new RoomServImpli();
    public static HotelServImpli hs = new HotelServImpli();

    public static void roomOperation() {
        while (true) {
            System.out.println("Press 1 for add room");
            System.out.println("Press 2 for get room by id");
            System.out.println("Press 3 for get all room");
            System.out.println("press 4 for exit ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Oh, you want to insert room");
                    Room room = input();
                    if (room != null) {
                        String ans = rs.addRoom(room);
                        System.out.println(ans);
                    } else {
                        System.out.println("Failed to add room due to invalid input.");
                    }
                    break;

                case 2:
                    try {
                        RoomGet();
                    } catch (RoomException e) {
                        System.out.println("Error fetching room: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Logic for getting all rooms
                	displayAllRoom();
                    break;
                    
                case 4:
        			return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }}
        }
    

    private static void RoomGet() throws RoomException {
        System.out.println("Enter room ID to fetch:");
        int rId = sc.nextInt();
        Room ro = rs.getRoomById(rId);
        if (ro != null) {
            System.out.println("+-------+--------------+-------------------+------------+------------+");
            System.out.println("| rId   | rTYPE        | rPRIZE            | rSTATUS    |     hID   |");
            System.out.println("+-------+--------------+-------------------+------------+------------+");
             
            System.out.printf("| %-5d | %-12s | %-17s | %-10s | %-12s |\n", ro.getrId(),
                    ro.getrType(),
                    ro.getrPrize(),
                    ro.getrStatus(),
                    ro.gethId());
            System.out.println("+-------+--------------+-------------------+------------+------------+");
        } else {
            System.out.println("No room found with ID " + rId);
        }
    }

    public static Room input() {
        Room r1 = new Room();

        System.out.println("Enter Room id: ");
        r1.setrId(sc.nextInt());

        System.out.println("Enter Room Type (AC or Non-AC): ");
        r1.setrType(sc.next());

        System.out.println("Enter Room Price: ");
        r1.setrPrize(sc.nextInt());

        System.out.println("Enter Hotel ID: ");
        int hotelId = sc.nextInt();

        Hotel hotel = hs.getHotelById(hotelId);
        if (hotel != null) {
            r1.sethId(hotel);
            return r1; // Return the populated room object
        } else {
            System.out.println("Hotel with ID " + hotelId + " not found.");
            return null; // Return null if hotel is not found
        }
    }
    
    private static void displayAllRoom() throws RoomException{
    	List<Room> rooms=rs.getAllRoom();
    	System.out.println("+-------+--------------+-------------------+------------+------------+");
        System.out.println("| rId   | rTYPE        | rPRIZE            | rSTATUS    |     hID   |");
        System.out.println("+-------+--------------+-------------------+------------+------------+");
    	for (Room ro1 : rooms) {
    		 System.out.printf("| %-5d | %-12s | %-17s | %-10s | %-12s |\n", ro1.getrId(),
                     ro1.getrType(),
                     ro1.getrPrize(),
                     ro1.getrStatus(),
                     ro1.gethId());
    	}
    	System.out.println("+-------+--------------+-------------------+------------+--------------+");
    }
}
