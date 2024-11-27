package hotel_daoimpli;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import hotel_dao.HotelDao;
import hotel_exception.GuestException;
import hotel_exception.HotelException;
import hotel_model.Guest;
import hotel_model.Hotel;
import hotel_util.Utility;

public class HotelDaoImpli implements HotelDao {

	@Override
	public String addHotel(Hotel h) throws HotelException {
		// TODO Auto-generated method stub
		String msg=null;
		EntityManager em = Utility.provaidManager();
		em.getTransaction().begin();
		em.persist(h);
		msg="data inserted";
		em.getTransaction().commit();
		em.close();
		
		return msg;
	}

	@Override
	public List<Hotel> getHotelByCity(String city) throws HotelException {
		// TODO Auto-generated method stub
		EntityManager em = Utility.provaidManager();
		 TypedQuery<Hotel> query = em.createQuery("SELECT g FROM Hotel g WHERE g.hCity = :hCity", Hotel.class);
		 query.setParameter("hCity", city); 
		    
		    List<Hotel> citys = query.getResultList();
		return citys;
	}

	@Override
	public List<Hotel> getAllHotel() throws HotelException {
		// TODO Auto-generated method stub
           EntityManager em = Utility.provaidManager();
  	    
  		TypedQuery<Hotel> query = em.createQuery("SELECT h FROM Hotel h", Hotel.class);
  	    
  	    List<Hotel> hotelss = query.getResultList();
		
		return hotelss;
	}

}
