package ar.com.playmedia.view;

import java.util.Scanner;
import java.util.ArrayList;

public class Contact {
	private Scanner keyboard;
	private ar.com.playmedia.controller.Contact handler;

	public Contact() {
		keyboard = new Scanner(System.in);
		handler = new ar.com.playmedia.controller.Contact();
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void mainMenu() {
		Integer option = -1;

		while(option != 0) {
			clearScreen();

			System.out.println("Contactos:");
			System.out.println("==========");
			System.out.println("	1) Agregar contacto");
			System.out.println("	2) Eliminar contacto");
			System.out.println("	3) Listar contactos");
			System.out.println();
			System.out.println("	0) Salir");
			System.out.println();
			System.out.print("Opcion: ");

			option = Integer.parseInt(keyboard.nextLine());

			switch(option) {
				case 1:
					addContact();
					break;

				case 2:
					deleteContact();
					break;

				case 3:
					searchContacts();
					break;

				case 0:
					break;

				default:
					System.out.print("Opcion incorrecta! Presione ENTER para continuar");
					keyboard.nextLine();
			}
		}
	}

	public void addContact() {
		ar.com.playmedia.model.Contact contact = new ar.com.playmedia.model.Contact();

		Integer other = -1;

		while(other != 0) {
			clearScreen();
			System.out.println("Alta de Contacto:");
			System.out.println("==== == =========");
			System.out.println();
			System.out.print("	Ingrese DNI: ");
			contact.setDni(Integer.parseInt(keyboard.nextLine()));

			System.out.print("	Ingrese Nombre: ");
			contact.setName(keyboard.nextLine());

			System.out.print("	Ingrese Apellido: ");
			contact.setSurname(keyboard.nextLine());

			System.out.print("	Ingrese Telefono: ");
			contact.setPhone(keyboard.nextLine());

			System.out.print("	Ingrese Correo Electronico: ");
			contact.setEmail(keyboard.nextLine());

			handler.connect();
			handler.insert(contact);
			handler.disconnect();

			System.out.println();
			System.out.print("Agregar otro contacto? (0 no / 1 si): ");
			other = Integer.parseInt(keyboard.nextLine());
		}
	}


	public void deleteContact() {
		Integer other = -1;

		while(other != 0) {
			clearScreen();
			System.out.println("Baja de Contacto:");
			System.out.println("==== == =========");
			System.out.println();
			System.out.print("	Ingrese DNI: ");
			Integer dni = Integer.parseInt(keyboard.nextLine());

			handler.connect();
			handler.delete(dni);
			handler.disconnect();

			System.out.println();
			System.out.print("Eliminar otro contacto? (0 no / 1 si): ");
			other = Integer.parseInt(keyboard.nextLine());
		}
	}


	public void searchContacts() {
		clearScreen();
		System.out.println("Listado de Contactos:");
		System.out.println("======= == ==========");
		System.out.println();
		System.out.print("	Ingrese parte del apellido del contacto: ");
		String filter = keyboard.nextLine();

		ArrayList<ar.com.playmedia.model.Contact> contactList;
		handler.connect();

		if(filter.isEmpty())
			contactList = handler.search();
		else
			contactList = handler.search(filter);
		
		handler.disconnect();

		clearScreen();
		System.out.println("Listado de Contactos:");
		System.out.println("======= == ==========");
		System.out.println();

		for(ar.com.playmedia.model.Contact contact : contactList) {
			System.out.println(String.format("DNI: %s", contact.getDni()));
			System.out.println(String.format("Nombre: %s", contact.getName()));
			System.out.println(String.format("Apellido: %s", contact.getSurname()));
			System.out.println(String.format("Telefono: %s", contact.getPhone()));
			System.out.println(String.format("Correo Electronico: %s", contact.getEmail()));
			System.out.println();
		}

		System.out.println();
		System.out.print("Presione ENTER para continuar...");
		keyboard.nextLine();
	}
}