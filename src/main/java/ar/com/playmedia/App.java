package ar.com.playmedia;


// import ar.com.playmedia.model.Contact;

import ar.com.playmedia.view.Contact;

public class App {
    public static void main(String[] args) {
		// INICIALIZACION DE LA CONEXION
		// Connection dbConnection = null;
		// String url = "jdbc:postgresql://127.0.0.1:5432/ejemplo";
		// String username = "dba";
		// String password = "12345678";
		
		// try {
		// 	Class.forName("org.postgresql.Driver");
		// 	dbConnection = DriverManager.getConnection(url, username, password);
		// } catch(Exception e) {
		// 	System.out.println("ERROR: " + e);
		// }
		

		// // INSERCION DE DATOS
		// String queryString = "INSERT INTO persona VALUES(25969243, 'Juan Perez')";
		// Statement query = null;
		
		// try {
		// 	query = dbConnection.createStatement();
		// 	query.execute(queryString);
		// 	query.close();
		// } catch (Exception e) {
		// 	System.out.println("ERROR: " + e);
		// }
		
		
		// // CONSULTA DE DATOS
		// queryString = "SELECT * FROM persona";
		// ResultSet result = null;
		
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
		

		// // CIERRE DE LA CONEXION A LA BBDD
		// try {
		// 	dbConnection.close();
		// } catch(Exception e) {
		// 	System.out.println(e);
		// }

		// ar.com.playmedia.model.Contact contact = new Contact (
		// 	25969243, 
		// 	"German", 
		// 	"Basisty", 
		// 	"1523924347", 
		// 	"german@gmail.com"
		// );
		
		// ar.com.playmedia.controller.Contact handler = new ar.com.playmedia.controller.Contact();

		Contact contactInterface = new Contact();
		contactInterface.mainMenu();
	}
}

