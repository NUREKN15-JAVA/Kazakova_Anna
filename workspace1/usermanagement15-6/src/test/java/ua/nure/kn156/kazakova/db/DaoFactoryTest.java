package ua.nure.kn156.kazakova.db;

import junit.framework.TestCase;

public class DaoFactoryTest extends TestCase {
	
	public void testGetUserDao(){
		DAOFactory daoFactory = DAOFactory.getInstance();
		assertNotNull("DaoFactory instance is null", daoFactory);
		try {
			UserDAO userDao = daoFactory.getUserDao();
		} catch (Exception e) {
			e.printStackTrace();
            fail(e.toString());
		}
		
	}
}
