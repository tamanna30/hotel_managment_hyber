package hotel_serv;

import java.util.List;

import hotel_exception.GuestException;
import hotel_model.Guest;

public interface GuestServ {
	public String addGuest(Guest g) throws GuestException ;
	public String updateGuest(Guest g) throws GuestException ;
	public Guest getGuestId(int id) throws GuestException ;
	public void deletebyid(int id)  throws GuestException ;
	public List<Guest> getAllGuest() throws GuestException;
}
