package hotel_daoimpli;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import hotel_dao.RoomDao;
import hotel_exception.GuestException;
import hotel_exception.RoomException;
import hotel_model.Guest;
import hotel_model.Room;
import hotel_util.Utility;

public class RoomDaoImpli implements RoomDao {

	@Override
	public String addRoom(Room r) throws RoomException {
		// TODO Auto-generated method stub
String msg=null;
		
		EntityManager em = Utility.provaidManager();
		em.getTransaction().begin();
		em.persist(r);
		msg="data inserted";
		em.getTransaction().commit();
		em.close();
		return msg;
	}

	@Override
	public Room getRoomById(int id) throws RoomException {
		// TODO Auto-generated method stub
		EntityManager em = Utility.provaidManager();
		Room r = em.find(Room.class,id);
		if(r==null) {
			throw new GuestException("we dont find guest with thid id");
		}
		em.close();
		return r;
	}

	@Override
	public List<Room> getAllRoom() throws RoomException {
		// TODO Auto-generated method stub
		 EntityManager em = Utility.provaidManager();
	  	    
	  		TypedQuery<Room> query = em.createQuery("SELECT r FROM Room r", Room.class);
	  	    
	  	    List<Room> rooms = query.getResultList();
		return rooms;
	}

}
