package hotel_Main;

import java.sql.SQLException;
import java.util.Scanner;

import hotel_daoimpli.UserDaoImpli;
import hotel_model.User;
import hotel_usecase.Bookuse;
import hotel_usecase.GuestUse;
import hotel_usecase.HotelUse;
import hotel_usecase.Ruse;
import hotel_dao.*;


public class MainMenu {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpli(); 
		while (true) {  
            System.out.println("1. singup");
            System.out.println("2. login");
            System.out.println("3. logout");
            int choice = sc.nextInt();
            sc.nextLine();
          switch(choice) {
			
			case 1:
				User newuser = new User();
				   
                System.out.print("Enter Username: ");
                newuser.setUsername(sc.next());
                System.out.print("Enter Password: ");
                newuser.setPassword(sc.next()); 
                System.out.print("Enter Email: ");
                newuser.setEmail(sc.next());  
                try {
                    userDao.signup(newuser);  
                    System.out.println("Signup Successful!");
                } catch (SQLException e) {
                    System.out.println("Error during signup: " + e.getMessage());
                }
                break;
                
			case 2:
				System.out.print("Enter Username: ");
                String loginUsername = sc.next();
                System.out.print("Enter Password: ");
                String loginPassword = sc.next();
                boolean loggedIn = false;
                try {
                    loggedIn = userDao.login(loginUsername, loginPassword);
                } catch (SQLException e) {
                    System.out.println("Error during login: " + e.getMessage());
                }
                
                if (loggedIn) {
                    System.out.println("Login Successful!");
                    Allmain();  // call all menu 
                } else {
                    System.out.println("Invalid Credentials. Please try again.");
                }
				break;
			case 3:
				System.out.println("Logout Succssfully...");
				sc.close();
				return;
				default:
					System.out.println("Invalid choice Try Again....");
				
			}
            
		}
	}
         public static void Allmain() {
		
		while(true) {
			System.out.println("1. All Cases for the Guest...!");
			System.out.println("2. All Cases for the Hotel...!");
			System.out.println("3. All Cases for the Room....!");
			System.out.println("4. All Cases for the Booking....!");
			System.out.println("5. Logout");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				GuestUse.GuestOperation();
				break;
			case 2:
				HotelUse.hotelOperation();
				break;
			case 3:
				Ruse.roomOperation();
				break;
			case 4:
				Bookuse.BookOperation();
				break;
			case 5:
				System.out.println("Exiting.....");
				sc.close();
				break;

			default:
				break;
			}
		}
		
	}
}
