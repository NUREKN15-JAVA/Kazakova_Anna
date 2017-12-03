package ua.nure.kn156.kazakova.db;

import java.util.Collection;

import ua.nure.kn156.kazakova.User;

/**
 * Interface for User class with implement DAO pattern with all CRUD opps
 * @author user
 *
 */
public interface UserDAO {
	/**
	 * Add user into DB users table and get new user's id form DB
	 * @param user all fields of user must be non-null except of id field
	 * @return copy of user from DB with auto-created id 
	 * @throws DatabaseException in case of any error with DB
	 */
	User create(User user) throws DatabaseException;
	
	User find(Long id) throws DatabaseException;
	
	void update(User user) throws DatabaseException;
	
	void delete(User user) throws DatabaseException;
	
	Collection<User> findAll() throws DatabaseException;
	
	Collection<User> find(String firstName, String lastName) throws DatabaseException;
	
	void setConnectionFactory(ConnectionFactory connectionFactory);
}