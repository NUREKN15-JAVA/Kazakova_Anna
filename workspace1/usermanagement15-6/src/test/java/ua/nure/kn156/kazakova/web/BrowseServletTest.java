package ua.nure.kn156.kazakova.web;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ua.nure.kn156.kazakova.User;

public class BrowseServletTest extends MockServletTestCase {

	protected void setUp() throws Exception {
		super.setUp();
		createServlet(BrowseServlet.class);
	}
	
	public void testEdit() {
        User user = new User(new Long(1000), "John", "Doe", new Date());
        getMockUserDao().expectAndReturn("find", new Long(1000), user);
        addRequestParameter("editButton", "Edit");
        addRequestParameter("id", "1000");
        doPost();
        User userInSession = (User) getWebMockObjectFactory().getMockSession().getAttribute("user");
        assertNotNull("Could not find user in session", user);
        assertSame(user, userInSession);
    }
	public void testBrowse() {
		User user = new User(new Long(1000), "John", "Doe", new Date());
		List list = Collections.singletonList(user);
		getMockUserDao().expectAndReturn("findAll", list);
		doGet();
		Collection collection = (Collection) getWebMockObjectFactory().getMockSession().getAttribute("users");
		assertNotNull(collection);
		assertSame(list, collection);	
	}
	
	public void testEditWithoutId() {
        User user = new User(new Long(1000), "John", "Doe", new Date());
        addRequestParameter("editButton", "Edit");
       doPost();
        assertNotNull("Could not find error message", getWebMockObjectFactory().getMockRequest().getAttribute("error"));
    }
	
}
