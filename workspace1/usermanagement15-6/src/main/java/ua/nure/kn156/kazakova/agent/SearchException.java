package ua.nure.kn156.kazakova.agent;

import ua.nure.kn156.kazakova.db.DatabaseException;

public class SearchException extends Exception {

	public SearchException(DatabaseException e) {
		super(e);
	}

}
