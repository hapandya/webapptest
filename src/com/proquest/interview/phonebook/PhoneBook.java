package com.proquest.interview.phonebook;

import java.sql.Connection;
import java.sql.SQLException;

public interface PhoneBook {
	Person findPerson(String fName, String lName, Connection cn);
	void addPerson(Person newPerson, Connection cn) throws SQLException, ClassNotFoundException;
}
