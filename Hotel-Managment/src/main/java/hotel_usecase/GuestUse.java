package hotel_usecase;

import java.util.List;
import java.util.Scanner;
import hotel_serv.*;

import hotel_Servimpli.*;
import hotel_exception.GuestException;
import hotel_model.Guest;


public class GuestUse {
	public static Scanner sc = new Scanner(System.in);
	public static GuestServ gs= new GuestServimpli();
	
	public static Guest input()
	{
		System.out.println("enter name");
		String name= sc.next();
		System.out.println("enter phone number");
		String pname= sc.next();
		System.out.println("enter email");
		String ename= sc.next();
		System.out.println("enter address");
		String aname= sc.next();
		
		Guest e= new Guest(name,pname,ename,aname);
		return e;
	}
	
	public static void  GuestOperation() {
		while (true) {  
		System.out.println("welcome to guest ");
		System.out.println("press 1 for add guest");
		System.out.println("press 3 for get guest by guestId");
		System.out.println("press 4 for get all guest");
		System.out.println("press 5 for delet by guest id");
		System.out.println("press 6 for exit");
		int choice= sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("oh you want to insert data");
			String ans=gs.addGuest(input());
			System.out.println(ans);
			break;
			
		case 2:
			
			break;
			
		case 3:
			GuestGet();
			break;
			
		case 4:
			displayAllGuests();
			break;
			
          case 5 :
        	  DeleteGuest();
			break;
			
          case 6:
				return;
		}}}
		private static void GuestGet() throws GuestException {
			System.out.println("Enter Guest ID to fetch:");
			int guId = sc.nextInt();
			Guest guest=gs.getGuestId(guId);
			System.out.println("+-------+--------------+-------------------+------------+------------+");
			System.out.println("| GID   | GName        | GEmail            | GPhone     | GAddress   |");
			System.out.println("+-------+--------------+-------------------+------------+------------+");

			int gId = guest.getgId();
			String gName = guest.getgName() ;
			String gEmail = guest.getgPhone();
			String gPhone = guest.getgEmail();
			String gAddress = guest.getgAdd();
			System.out.printf("| %-5d | %-12s | %-17s | %-10s | %-10s |\n", gId, gName, gEmail, gPhone, gAddress);
			System.out.println("+-------+--------------+-------------------+------------+------------+");
			}
		
		private static void displayAllGuests() throws GuestException {
			List<Guest> guests=gs.getAllGuest();
			System.out.println("+-------+--------------+-------------------+------------+--------------+");
			System.out.println("| GID   | GName        | GEmail            | GPhone     | GAddress     |");
			System.out.println("+-------+--------------+-------------------+------------+--------------+");
			
			for (Guest guest : guests) {
				System.out.printf("| %-5d | %-12s | %-17s | %-10s | %-12s |\n",guest.getgId(),
				guest.getgName() ,
				 guest.getgPhone(),
				guest.getgEmail(),
				guest.getgAdd()  );
			}

			System.out.println("+-------+--------------+-------------------+------------+--------------+");
		}
		
		
		private static void DeleteGuest() throws GuestException {

			System.out.println("Enter Guest ID to Delete Guest:");
			int guestId = sc.nextInt();
			gs.deletebyid(guestId);

			System.out.println("Guest with ID " + guestId + " has been deleted.");
		}
}
