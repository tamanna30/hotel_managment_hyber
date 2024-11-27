package hotel_daoimpli;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import hotel_dao.UserDao;
import hotel_model.User;
import hotel_util.Utility;

public class UserDaoImpli implements UserDao {

	@Override
	public boolean signup(User user) throws SQLException {
		// TODO Auto-generated method stub
		EntityManager em = Utility.provaidManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		return false;
	}

	@Override
	public boolean login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		EntityManager em = Utility.provaidManager();
		Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password");

        query.setParameter("username", username);
        query.setParameter("password", password);

        query.getSingleResult();
		return true;
	}

}
