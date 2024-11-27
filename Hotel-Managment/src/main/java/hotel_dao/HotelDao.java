package hotel_dao;

import java.util.List;

import hotel_exception.HotelException;
import hotel_model.Hotel;

public interface HotelDao {
	public String addHotel(Hotel h) throws HotelException ;
	public List<Hotel> getHotelByCity(String city) throws HotelException ;
	public List<Hotel> getAllHotel() throws HotelException;
}
