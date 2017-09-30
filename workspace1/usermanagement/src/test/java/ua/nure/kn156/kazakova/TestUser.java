package ua.nure.kn156.kazakova;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

public class TestUser extends TestCase {
	private static final int AGE = 19;
	private User user;
	private Date date;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		user = new User();
		Calendar calendar = Calendar.getInstance();
		calendar.set(1998, Calendar.MARCH, 16);
		date = calendar.getTime();
		
	}
	
	public void testGetFullName() {
		user.setFirstName("Anna");
		user.setLastName("Kazakova");
		assertEquals("Kazakova, Anna", user.getFullName());
	}
	public void testGetAge() {
		user.setDate(date);
		assertEquals(AGE, user.getAge());
	}
}
