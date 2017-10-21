package ua.nure.kn156.kazakova.db;

import java.util.Collection;
import java.util.Date;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import ua.nure.kn156.kazakova.User;


public class HsqldbUserDaoTest extends DatabaseTestCase {
	private HsqldbUserDao dao;
	private ConnectionFactory connectionFactory;
	private User testUser;

	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		dao = new HsqldbUserDao(connectionFactory);
		testUser= new User();
		testUser.setFirstName("John");
		testUser.setLastName("Doe");
		testUser.setDate(new Date());
		testUser = dao.create(testUser);
	}
	
	public void testCreate(){
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setDate(new Date());
		assertNull(user.getId());
		User createdUser;
		try {
			createdUser = dao.create(user);
			assertNotNull(createdUser);
			assertNotNull(createdUser.getId());
			assertEquals(user.getFullName(), createdUser.getFullName());
			assertEquals(user.getAge(), createdUser.getAge());
		} catch(DatabaseException e) {
			fail(e.toString());
		}
	}
	
	public void testFindAll() {
		try{
			Collection collection = dao.findAll();
			 assertNotNull("Collection is null", collection);
	         assertEquals("Collection size.", 3, collection.size());
		} catch(DatabaseException e) {
			fail(e.toString());
		}
	}
	
	public void testFind() {
		try{
			User foundUser = dao.find(testUser.getId());
	        assertEquals(testUser.getId(), foundUser.getId());
		} catch(DatabaseException e) {
			fail(e.toString());
		}
	}
	
	public void testUpdate() {
		try{
			Long id = testUser.getId();
			testUser.setFirstName("Mark");
			dao.update(testUser);
			User foundUser = dao.find(id);
			assertEquals("Mark", foundUser.getFirstName());
		} catch(DatabaseException e) {
			fail(e.toString());
		}
	}
	
	public void testDelete() {
		try{
			dao.delete(testUser);
			try{
				dao.find(testUser.getId());
				fail("Expected DatabaseException");
			} catch (DatabaseException e) {
				assertEquals("No user in DB with such id", e.getMessage());
			}
	        
		} catch(DatabaseException e) {
			fail(e.toString());
		}
	}
	
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		connectionFactory = new ConnectionFactoryImpl(
				"org.hsqldb.jdbcDriver",
				"jdbc:hsqldb:file:db/usermanagement",
				"sa",
				"");
		return new DatabaseConnection(connectionFactory.createConnection()); 
	}
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new XmlDataSet(getClass()
				.getClassLoader()
				.getResourceAsStream("usersDataSet.xml"));
		return dataSet; 
	}
}
