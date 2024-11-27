package hotel_Servimpli;

import java.util.List;

import hotel_daoimpli.RoomDaoImpli;
import hotel_exception.RoomException;
import hotel_model.Room;
import hotel_serv.RoomServ;
import hotel_dao.*;

public class RoomServImpli implements RoomServ{
      RoomDao Dao= new RoomDaoImpli();
	@Override
	public String addRoom(Room r) throws RoomException {
		// TODO Auto-generated method stub
		return Dao.addRoom(r) ;
	}

	@Override
	public Room getRoomById(int id) throws RoomException {
		// TODO Auto-generated method stub
		return Dao.getRoomById(id);
	}

	@Override
	public List<Room> getAllRoom() throws RoomException {
		// TODO Auto-generated method stub
		return Dao.getAllRoom();
	}

}
