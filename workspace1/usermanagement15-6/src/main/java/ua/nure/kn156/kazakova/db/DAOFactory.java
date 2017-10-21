package ua.nure.kn156.kazakova.db;

import java.io.IOException;
import java.util.Properties;

public class DAOFactory {
	private static final String USER_DAO = "dao.ua.nure.kn156.kazakova.db.UserDao";
	private final Properties properties;
	private final static DAOFactory INSTANCE = new DAOFactory();
	 
	public static DAOFactory getInstance() {
	    return INSTANCE;
	}
	    
	public DAOFactory() {
		properties = new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	


	private ConnectionFactory getConnectionFactory() {
		
		String driver = properties.getProperty("connection.driver");
		String url = properties.getProperty("connection.url");
		String user = properties.getProperty("connection.user");
		String password = properties.getProperty("connection.password");
		
		ConnectionFactoryImpl connectionFactoryImpl = new ConnectionFactoryImpl(driver, url, user, password);
		return connectionFactoryImpl;
	}
	public UserDAO getUserDao() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		UserDAO result = null;
		Class clazz = Class.forName(properties.getProperty(USER_DAO));
		result = (UserDAO) clazz.newInstance();
		result.setConnectionFactory(getConnectionFactory());
		
		return result;
	}
	
	
}
