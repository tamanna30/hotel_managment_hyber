package hotel_dao;

import java.sql.SQLException;

import hotel_model.User;

public interface UserDao {
       public boolean signup(User user) throws SQLException;
	 
	 public boolean login(String username, String password) throws SQLException;
}
