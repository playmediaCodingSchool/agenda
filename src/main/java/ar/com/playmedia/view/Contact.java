package ar.com.playmedia.view;

import java.util.Scanner;

public class Contact {
	private Scanner keyboard;
	
	public Contact() {
		keyboard = new Scanner(System.in);
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
			System.out.println();
			System.out.println("	0) Salir");
			System.out.println();
			System.out.print("Opcion: ");

			option = Integer.parseInt(keyboard.nextLine());

			switch(option) {
				case 1:
					addContact();
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
		ar.com.playmedia.controller.Contact handler = new ar.com.playmedia.controller.Contact();

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
}