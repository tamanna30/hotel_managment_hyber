package hotel_Servimpli;

import java.util.List;

import hotel_daoimpli.GuestDaoImpli;
import hotel_exception.GuestException;
import hotel_model.Guest;
import hotel_serv.GuestServ;

public class GuestServimpli implements GuestServ {
	GuestDaoImpli Dao= new GuestDaoImpli();

	@Override
	public String addGuest(Guest g) throws GuestException {
		// TODO Auto-generated method stub
		String ans=Dao.addGuest(g);
		return ans;
	}

	@Override
	public String updateGuest(Guest g) throws GuestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guest getGuestId(int id) throws GuestException {
		// TODO Auto-generated method stub
		return Dao.getGuestId(id);
	}

	@Override
	public void deletebyid(int id) throws GuestException {
		// TODO Auto-generated method stub
		Dao.deletebyid(id);
	}

	@Override
	public List<Guest> getAllGuest() throws GuestException {
		// TODO Auto-generated method stub
		return Dao.getAllGuest();
	}

}
