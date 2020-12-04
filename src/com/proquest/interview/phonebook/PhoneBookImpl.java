package com.proquest.interview.phonebook;

import com.proquest.interview.util.DatabaseUtil;

import java.sql.*;

public class PhoneBookImpl implements PhoneBook {

	@Override
	public void addPerson(Person newPerson, Connection cn){
		//TODO: write this method

		try (PreparedStatement insertPerson = cn.prepareStatement("INSERT INTO PHONEBOOK (NAME, PHONENUMBER, ADDRESS) VALUES(?,?,?)")) {
				insertPerson.setString(1, newPerson.getName());
				insertPerson.setString(2, newPerson.getPhoneNumber());
				insertPerson.setString(3, newPerson.getAddress());
				insertPerson.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}

		@Override
	public Person findPerson(String fName, String lName, Connection cn) {
		//TODO: write this method
			Person person =null;
			ResultSet rs;
			try (PreparedStatement searchPerson = cn.prepareStatement("SELECT * FROM PHONEBOOK WHERE NAME=?")) {
					searchPerson.setString(1, fName + " " + lName);
					rs = searchPerson.executeQuery();
				rs.next();
				person = new Person(rs.getString("NAME"), rs.getString("PHONENUMBER"), rs.getString("ADDRESS"));

			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
			return person;
		}

	private static void retrievePhoneBook(Connection cn) throws SQLException {
		ResultSet rs;
		try (Statement stmt = cn.createStatement()) {
			String query = "SELECT * FROM PHONEBOOK";
			rs = stmt.executeQuery(query);
		}

		while(rs.next()){
			System.out.println("Name:" + rs.getString("NAME")+"--- Phone:"+ rs.getString("PHONENUMBER") +"-----Address:" + rs.getString("ADDRESS"));
		}
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		DatabaseUtil.initDB();  //You should not remove this line, it creates the in-memory database
		Connection cn = DatabaseUtil.getConnection();
		/* TODO: create person objects and put them in the PhoneBook and database
		 * John Smith, (248) 123-4567, 1234 Sand Hill Dr, Royal Oak, MI
		 * Cynthia Smith, (824) 128-8758, 875 Main St, Ann Arbor, MI
		*/
		new PhoneBookImpl().addPerson(new Person("John Smith", "(248) 123-4567", "1234 Sand Hill Dr, Royal Oak, MI"), cn);
		new PhoneBookImpl().addPerson(new Person("Cynthia Smith", "(824) 128-8758", "875 Main St, Ann Arbor, MI"), cn);

		// TODO: print the phone book out to System.out
		retrievePhoneBook(cn);

		// TODO: find Cynthia Smith and print out just her entry
		Person person = new PhoneBookImpl().findPerson("Cynthia", "Smith",cn);
		System.out.println("Find Name:" + person.getName()+"--- Phone:"+ person.getPhoneNumber() +"-----Address:" + person.getAddress());

		// TODO: insert the new person objects into the database
//		new PhoneBookImpl().addPerson(new Person("Hardik Pandya", "(123) 546-7890", "875 Main St, Ann Arbor, MI"), cn);
	}
}
