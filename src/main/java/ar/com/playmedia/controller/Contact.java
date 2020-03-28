package ar.com.playmedia.controller;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

// import ar.com.playmedia.model.Contact;

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
		password = "12345678";
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


	public void insert (ar.com.playmedia.model.Contact contact) {
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