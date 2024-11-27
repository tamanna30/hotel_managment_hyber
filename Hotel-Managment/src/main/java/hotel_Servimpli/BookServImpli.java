package hotel_Servimpli;

import java.util.List;

import hotel_dao.BookDao;
import hotel_daoimpli.BookDaoimpli;
import hotel_exception.BookException;
import hotel_model.Book;
import hotel_serv.BookServ;
import hotel_dao.*;

public class BookServImpli implements BookServ {
          BookDao dao= new BookDaoimpli();
	@Override
	public void bookRoom(Book b) throws BookException {
		// TODO Auto-generated method stub
		dao.bookRoom(b);
	}

	@Override
	public Book getBookingByGuestId(int guestId) throws BookException {
		// TODO Auto-generated method stub
		return dao.getBookingByGuestId(guestId);
	}

	@Override
	public void cancelBooking(int roomId, int hotelId) throws BookException {
		// TODO Auto-generated method stub
		dao.cancelBooking(roomId, hotelId);
	}

}
