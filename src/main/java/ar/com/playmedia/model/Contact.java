package ar.com.playmedia.model;

public class Contact {
	private Integer dni;
	private String name;
	private String surname;
	private String phone;
	private String email;

	public Contact() {}
	
	public Contact (
		Integer dni,
		String name,
		String surname,
		String phone,
		String email
	) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
	}


	public Integer getDni() {
		return dni;
	}

	
	public void setDni(Integer dni) {
		this.dni = dni;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
}
