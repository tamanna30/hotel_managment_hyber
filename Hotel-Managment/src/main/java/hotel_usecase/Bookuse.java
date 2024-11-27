package hotel_usecase;

import java.util.List;
import java.util.Scanner;

import hotel_Servimpli.BookServImpli;
import hotel_Servimpli.GuestServimpli;
import hotel_Servimpli.HotelServImpli;
import hotel_Servimpli.RoomServImpli;
import hotel_exception.BookException;
import hotel_exception.GuestException;
import hotel_exception.RoomException;
import hotel_model.Book;
import hotel_model.Guest;
import hotel_model.Hotel;
import hotel_model.Room;
import hotel_serv.*;

public class Bookuse {
	public static Scanner sc = new Scanner(System.in);
	public static BookServ bs= new BookServImpli();
	 public static HotelServImpli hs = new HotelServImpli();
	 public static GuestServ gs= new GuestServimpli();
	 public static RoomServ rs = new RoomServImpli();
	 
	 public static void BookOperation() {
	        while (true) {
	            System.out.println("Press 1 for booking");
	            System.out.println("Press 2 for get booking by book id");
	            System.out.println("Press 3 for cancle booking");
	            System.out.println("Press 4 for exit");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.println("Oh, you want to insert room");
	                    Book book = input();
	                    if (book != null) {
	                        bs.bookRoom(book);
	                        System.out.println("booking succesfull");
	                    } else {
	                        System.out.println("Failed.");
	                    }
	                    break;

	                case 2:
	                	GetBooking();
	                	break;

	                case 3:
	                    // Logic for getting all rooms
	                	Deletebook();
	                    break;
	                    
	                case 4:
	    				return;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	public static Book input() {
	Book b = new Book();
	
	System.out.println("Enter booking id: ");
    b.setbId(sc.nextInt());
    
    System.out.println("Enter booking date: ");
    b.setBookDate(sc.next());
    
    System.out.println("Enter check in date: ");
    b.setCheckIn(sc.next());
    
    System.out.println("Enter check out date: ");
    b.setCheckOut(sc.next());
    
    System.out.println("Enter guest ID: ");
    int gId = sc.nextInt();
    
     Guest gus = gs.getGuestId(gId);
//    if (gus != null) {
//        b.setGuestId(gus);
//        return b; // Return the populated room object
//    } else {
//        System.out.println("Hotel with ID " + gId + " not found.");
//        return null; // Return null if hotel is not found
//    }
    
    System.out.println("Enter room ID: ");
    int rId = sc.nextInt();

    Room roo = rs.getRoomById(rId);
    
    System.out.println("Enter Hotel ID: ");
    int hotelId = sc.nextInt();

    Hotel hotel = hs.getHotelById(hotelId);

    if (roo != null&gus != null&hotel != null) {
        b.setRoomId(roo);
        b.setGuestId(gus);
        b.sethId(hotel);
        return b; // Return the populated room object
    } else {
        System.out.println("guest with ID " + gId + " not found.");
        System.out.println("room with ID " + rId + " not found.");
        System.out.println("Hotel with ID " + hotelId + " not found.");
        return null; // Return null if hotel is not found
    }	
	}
	
	 private static void GetBooking() {
		 System.out.println("Enter booking id ID to fetch:");
	        int gId = sc.nextInt();
	        
	        Book b = bs.getBookingByGuestId(gId);
	        
	        System.out.println("+-------+--------------+--------------+-------------+----------------+---------------+------------+");
			System.out.println("| BID   | GuestId      |    room Id   | booking date| checkin time   | checkout time |  hId       |");
			System.out.println("+-------+--------------+--------------+-------------+----------------+---------------+------------+");
			
			
				System.out.printf("| %-5d | %-12s | %-17s | %-10s | %-12s | %-10s | %-12s |\n",b.getbId(),
						b.getGuestId().getgId(),
				
						b.getRoomId().getrId(),
						b.getBookDate(),
						b.getCheckIn(),
						b.getCheckOut(),
				b.gethId().gethId());
				
				System.out.println("+-------+--------------+-------------------+-------------+-------------------+------------------+------------+");
//			System.out.println("+-------+--------------+-------------------+------------+--------------+");
	 }
	 
	 private static void Deletebook() throws BookException {

			System.out.println("Enter room ID to Delete booking:");
			int rId = sc.nextInt();
			System.out.println("Enter hotel ID to Delete booking:");
			int hId = sc.nextInt();
//			gs.deletebyid(guestId);
			bs.cancelBooking(rId,hId);

			System.out.println("booking with ID " + rId + " has been deleted.");
		}
}
