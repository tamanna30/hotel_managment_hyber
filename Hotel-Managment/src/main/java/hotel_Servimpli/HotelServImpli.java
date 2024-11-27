package hotel_Servimpli;

import java.util.List;

import javax.persistence.EntityManager;

import hotel_daoimpli.HotelDaoImpli;
import hotel_exception.HotelException;
import hotel_model.Hotel;
import hotel_serv.HotelServ;
import hotel_util.Utility;

public class HotelServImpli implements HotelServ {
       HotelDaoImpli Dao= new HotelDaoImpli();
	@Override
	public String addHotel(Hotel h) throws HotelException {
		// TODO Auto-generated method stub
		return Dao.addHotel(h);
	}

	@Override
	public List<Hotel> getHotelByCity(String city) throws HotelException {
		// TODO Auto-generated method stub
		return Dao.getHotelByCity(city);
	}
	public static Hotel getHotelById(int id) throws HotelException {
	    EntityManager em = Utility.provaidManager();
	    Hotel hotel = em.find(Hotel.class, id);
	    em.close();
	    return hotel;
	}

	@Override
	public List<Hotel> getAllHotel() throws HotelException {
		// TODO Auto-generated method stub
		return Dao.getAllHotel();
	}

}
