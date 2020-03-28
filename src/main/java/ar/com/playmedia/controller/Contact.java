package ar.com.playmedia.controller;

import java.util.ArrayList;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Contact {
	private Connection dbConnection;
	private Statement query;
	private ResultSet result;
	private String url;
	private String username;
	private String password;

	public Contact() {
		url = "jdbc:postgresql://127.0.0.1:5432/address_book";
		username = "dba";
		password = "Fsgbue13.";
	}

	public void connect() {	
		try {
			Class.forName("org.postgresql.Driver");
			dbConnection = DriverManager.getConnection(url, username, password);
		} catch(Exception e) {
			System.out.println("ERROR: " + e);
		}
	}


	public void disconnect() {
		try {
			dbConnection.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}


	public void insert(ar.com.playmedia.model.Contact contact) {
		String queryString = String.format (
			"INSERT INTO contact(dni, name, surname, phone, email) VALUES(%s, '%s', '%s', '%s', '%s')",
			contact.getDni(),
			contact.getName(),
			contact.getSurname(),
			contact.getPhone(),
			contact.getEmail()
		);

		try {
			query = dbConnection.createStatement();
			query.execute(queryString);
			query.close();
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
	}


	public void delete(Integer dni) {
		String queryString = String.format (
			"SELECT  contact_destroy(%s);",
			dni
		);

		try {
			query = dbConnection.createStatement();
			query.execute(queryString);
			query.close();
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
	}
	

	public ArrayList<ar.com.playmedia.model.Contact> search() {
		ArrayList<ar.com.playmedia.model.Contact> contactList = 
			new ArrayList<ar.com.playmedia.model.Contact>();
		
		String queryString = "SELECT * from contact_search()";

		try {
			query = dbConnection.createStatement();
			result = query.executeQuery(queryString);

			while(result.next()) {
				ar.com.playmedia.model.Contact contact = new ar.com.playmedia.model.Contact (
					 Integer.parseInt(result.getString(1)),
					 result.getString(2),
					 result.getString(3),
					 result.getString(4),
					 result.getString(5)
				);

				contactList.add(contact);
			}

			query.close();
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}

		return contactList;
	}


	public ArrayList<ar.com.playmedia.model.Contact> search(String filter) {
		ArrayList<ar.com.playmedia.model.Contact> contactList = 
			new ArrayList<ar.com.playmedia.model.Contact>();
		
		String queryString = String.format("SELECT * from contact_search('%s')", filter);

		try {
			query = dbConnection.createStatement();
			result = query.executeQuery(queryString);

			while(result.next()) {
				ar.com.playmedia.model.Contact contact = new ar.com.playmedia.model.Contact (
					 Integer.parseInt(result.getString(1)),
					 result.getString(2),
					 result.getString(3),
					 result.getString(4),
					 result.getString(5)
				);

				contactList.add(contact);
			}

			query.close();
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}

		return contactList;
	}
		
		

		
		
		// // CONSULTA DE DATOS
		// queryString = "SELECT * FROM persona";
		
		
		// try {
		// 	query = dbConnection.createStatement();
		// 	result = query.executeQuery(queryString);
			
		// 	while(result.next()) {
		// 		System.out.println(result.getString(1) + " | " + result.getString(2));
		// 	}
			
		// 	query.close();
		// } catch (Exception e) {
		// 	System.out.println("ERROR: " + e);
		// }
}