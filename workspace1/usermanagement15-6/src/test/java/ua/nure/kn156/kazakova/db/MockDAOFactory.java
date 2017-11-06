package ua.nure.kn156.kazakova.db;

import com.mockobjects.dynamic.Mock;

public class MockDAOFactory extends DAOFactory {

	private Mock mockUserDAO;
	
	public MockDAOFactory() {
		mockUserDAO = new Mock(UserDAO.class);
	}
	
	public Mock getMockUserDAO() {
		return mockUserDAO;
	}
	
	@Override
	public UserDAO getUserDao() {
		return (UserDAO) mockUserDAO.proxy();
	}

}
