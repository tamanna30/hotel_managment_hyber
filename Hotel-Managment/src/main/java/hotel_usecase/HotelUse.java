package hotel_usecase;

import java.util.List;
import java.util.Scanner;

import hotel_Servimpli.HotelServImpli;
import hotel_exception.HotelException;
import hotel_model.Guest;
import hotel_model.Hotel;
import hotel_serv.*;

public class HotelUse {
	public static Scanner sc = new Scanner(System.in);
	public static HotelServ hs= new HotelServImpli();
	public static Hotel input()
	{  System.out.println("enter hotel id");
	int  hid= sc.nextInt();
		System.out.println("enter hotel name");
		String hname= sc.next();
		System.out.println("enter hotel city");
		String city= sc.next();
		System.out.println("enter total room ");
		int total= sc.nextInt();
		System.out.println("enter available room");
		int avail= sc.nextInt();
		
		Hotel h = new Hotel(hid,hname,city,total,avail);
		return h;
	}
	
	public static void  hotelOperation() {
		while (true) {  
		System.out.println("press 1 for add hotel");
		System.out.println("press 2 for get hotel by city name");
		System.out.println("press 3 for get all hotel ");
		System.out.println("press 4 for exit ");
       int choice= sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("oh you want to insert hotel");
			String ans=hs.addHotel(input());
			System.out.println(ans);
			break;
			
		case 2:
			cityByname();
			break;
		case 3:
			allHotel();
			break;
			
		case 4:
			return;
		}
	}}
	
	private static void cityByname() throws HotelException {
		
		System.out.println("enter city name");
		String cname=sc.next();
		List<Hotel> hot = hs.getHotelByCity(cname);
		System.out.println("+-------+--------------+-------------------+------------+------------+");
		System.out.println("| HID   | HNAME        |    HCITY          |  TROOM     |    AROOM   |");
		System.out.println("+-------+--------------+-------------------+------------+------------+");
		
		for(Hotel hotel:hot) {
			System.out.printf("| %-5d | %-12s | %-17s | %-10s | %-12s |\n",hotel.gethId(),
					hotel.gethName(),
					hotel.gethCity(),
					hotel.gettRoom(),
					hotel.getaRoom());
		}
		System.out.println("+-------+--------------+-------------------+------------+--------------+");
	}
	
	private static void allHotel() throws HotelException{
	List<Hotel> hot = hs.getAllHotel();
	
	System.out.println("+-------+--------------+-------------------+------------+------------+");
	System.out.println("| HID   | HNAME        |    HCITY          |  TROOM     |    AROOM   |");
	System.out.println("+-------+--------------+-------------------+------------+------------+");
	
	for(Hotel hotel:hot) {
		System.out.printf("| %-5d | %-12s | %-17s | %-10s | %-12s |\n",hotel.gethId(),
				hotel.gethName(),
				hotel.gethCity(),
				hotel.gettRoom(),
				hotel.getaRoom());
	}
	System.out.println("+-------+--------------+-------------------+------------+--------------+");
	}

}