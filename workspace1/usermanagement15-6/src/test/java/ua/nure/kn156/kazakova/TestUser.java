package ua.nure.kn156.kazakova;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
/**
 * {@value #AGE} is age of user in years and actual for 2017
 */
public class TestUser extends TestCase {
	private static final int YEAR_OF_BIRTH = 1998;
	private static final int DAY_OF_BIRTH = 16;
	private static final int AGE = 19;
	private User user;
	private Date date;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		user = new User();
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, Calendar.MARCH, DAY_OF_BIRTH);
		date = calendar.getTime();
		
	}
	
	public void testGetFullName() {
		user.setFirstName("Anna");
		user.setLastName("Kazakova");
		assertEquals("Kazakova, Anna", user.getFullName());
		user.setFirstName(null);
		try {
			user.getFullName();
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        	assertEquals(e.getMessage(), "FirstName or LastName is null");
        }
	}

	public void testGetAge() {
		user.setDate(date);
		assertEquals(AGE, user.getAge());
	}
}
