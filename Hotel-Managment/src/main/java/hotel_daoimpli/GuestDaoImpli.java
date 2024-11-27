package hotel_daoimpli;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import hotel_dao.GuestDao;
import hotel_exception.GuestException;
import hotel_model.Guest;
import hotel_util.Utility;


public class GuestDaoImpli implements GuestDao {

	@Override
	public String addGuest(Guest g) throws GuestException {
		// TODO Auto-generated method stub
	String msg=null;
		
		EntityManager em = Utility.provaidManager();
		em.getTransaction().begin();
		em.persist(g);
		msg="data inserted";
		em.getTransaction().commit();
		em.close();
		
	    return msg;
		
	}

	@Override
	public String updateGuest(Guest g) throws GuestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guest getGuestId(int id) throws GuestException {
		// TODO Auto-generated method stub
		EntityManager em = Utility.provaidManager();
		Guest g = em.find(Guest.class,id);
		if(g==null) {
			throw new GuestException("we dont find guest with thid id");
		}
		em.close();
		return g;
	}

	@Override
	public void deletebyid(int id) throws GuestException {
		// TODO Auto-generated method stub
		EntityManager em = Utility.provaidManager();
		 em.getTransaction().begin();
	        Query query = em.createQuery("DELETE FROM Guest g WHERE g.gId = :gId"); 
 query.setParameter("gId", id); 
	        
	        int deletedCount = query.executeUpdate(); 

	        if (deletedCount == 0) {
	            throw new GuestException("No guest found with ID: " + id); 
	        }

	        em.getTransaction().commit();
	}

	@Override
	public List<Guest> getAllGuest() throws GuestException {
		// TODO Auto-generated method stub
          EntityManager em = Utility.provaidManager();
  	    
  		TypedQuery<Guest> query = em.createQuery("SELECT g FROM Guest g", Guest.class);
  	    
  	    List<Guest> guests = query.getResultList();
		
		return guests;
	}

}
