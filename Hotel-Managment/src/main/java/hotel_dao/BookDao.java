package hotel_dao;

import java.util.List;

import hotel_exception.BookException;
import hotel_model.Book;

public interface BookDao {
	void bookRoom(Book b) throws BookException;
    Book getBookingByGuestId(int guestId) throws BookException;
    void cancelBooking(int roomId,int hotelId) throws BookException;
}
