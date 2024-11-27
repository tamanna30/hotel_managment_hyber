package hotel_serv;

import java.util.List;

import hotel_exception.RoomException;
import hotel_model.Room;

public interface RoomServ {
	public String addRoom(Room r) throws RoomException ;
	public Room getRoomById(int id) throws RoomException ;
	public List<Room> getAllRoom() throws RoomException;
}
