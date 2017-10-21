package ua.nure.kn156.kazakova;

import java.util.Calendar;
import java.util.Date;

public class User {
	private Long id;
	private String firstName;
	private String lastName;
	private Date date;
	
	public User(User user) {
		id = user.getId();
		firstName = user.getFirstName();
		lastName = user.getLastName();
		date = user.getDate();
	}
	public User() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFullName() {
		if (getLastName() == null || getFirstName() == null) throw new IllegalArgumentException("FirstName or LastName is null");
		return new StringBuilder(getLastName()).append(", ").append(getFirstName()).toString();
	}
	public long getAge() {
		Calendar calendar = Calendar.getInstance();
		long currentYear = calendar.get(Calendar.YEAR);
		long currentDayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(getDate());
		long yearOfBirth = calendar.get(Calendar.YEAR);
		long birthDayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		long age = currentYear - yearOfBirth;
		if (currentDayOfYear < birthDayOfYear) {
				age--;
			}
		return age;
	}
	
}
