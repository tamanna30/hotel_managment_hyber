package hotel_daoimpli;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import hotel_dao.BookDao;
import hotel_exception.BookException;
import hotel_exception.GuestException;
import hotel_exception.HotelException;
import hotel_model.Book;
import hotel_model.Room;
import hotel_util.Utility;

public class BookDaoimpli implements BookDao {

	@Override
	public void bookRoom(Book b) throws BookException {
		// TODO Auto-generated method stub
		EntityManager em = Utility.provaidManager();
		try {
		em.getTransaction().begin();
		em.persist(b);
		 em.flush();
		 
//		  Update room status to "Booked" 
	        Query URS = em.createNativeQuery("UPDATE Room SET rStatus = ? WHERE rId = ?");
	        URS.setParameter(1, "Booked");
	        URS.setParameter(2, b.getRoomId().getrId());
	        URS.executeUpdate();
	        
	        // Decrement available rooms 
	        Query UAR = em.createNativeQuery("UPDATE Hotel SET aRoom = aRoom - 1 WHERE hId = ?");
	        UAR.setParameter(1, b.gethId().gethId());
	        UAR.executeUpdate();

	        em.getTransaction().commit();
	    } catch (Exception e) {
	  
	        System.out.println("Error: " + e.getMessage()); 
	        throw new BookException("Error while adding the booking: " + e.getMessage());
	    } 
	}

	@Override
	public Book getBookingByGuestId(int guestId) throws BookException {
		// TODO Auto-generated method stub
		EntityManager em = Utility.provaidManager();
//		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b  WHERE b.gId  = :gId", Book.class);
//	    query.setParameter("gId", guestId); 
//
//	    List<Book> books = query.getResultList();
//	    
//		return books;
		
		Book b = em.find(Book.class,guestId);
		if(b==null) {
			throw new GuestException("we dont find guest with thid id");
		}
		em.close();
		return  b;
	}

	@Override
	public void cancelBooking(int roomId, int hotelId) throws BookException {
		// TODO Auto-generated method stub
		EntityManager em = Utility.provaidManager();
		 try {
		        em.getTransaction().begin();
		        
//		         Step 1: Delete the booking
		        String del = "DELETE FROM book WHERE rId = :rId";
		        Query delBooking = em.createNativeQuery(del);
		        delBooking.setParameter("rId", roomId);
		        int r = delBooking.executeUpdate();

		        if (r > 0) {
		            System.out.println("Booking with ID " + roomId + " canceled successfully.");
		        } else {
		            System.out.println("No booking found with ID " + roomId + ". Cancel failed.");
		            em.getTransaction().rollback();
		            return;
		        }
		
		        
		     // Step 2: Update the room status to 'Available' after deletion
		        String up = "UPDATE room SET rStatus = :status WHERE rId = :rId";
		        Query upRoomQ = em.createNativeQuery(up);
		        upRoomQ.setParameter("status", "Available");
		        upRoomQ.setParameter("rId", roomId);
		        int res = upRoomQ.executeUpdate();

		        if (res <= 0) {
		            em.getTransaction().rollback();
		            throw new BookException("Failed to update room status.");
		        } else {
		            System.out.println("Room with ID " + roomId + " status updated to 'Available'.");
		        }

		        
		     // Step 3: Update the available rooms count in the hotel
		        String update = "UPDATE hotel SET aRoom = aRoom + 1 WHERE hId = :hId";
		        Query UAQ = em.createNativeQuery(update);
		        UAQ.setParameter("hId", hotelId);
		        int result = UAQ.executeUpdate();

		        if (result <= 0) {
		            em.getTransaction().rollback();
		            throw new HotelException("Failed to update available room count.");
		        }

		        em.getTransaction().commit();
		 }catch (Exception e) {
		        throw new BookException("Error canceling booking: " + e.getMessage());
		    } 
		 
	}

}
