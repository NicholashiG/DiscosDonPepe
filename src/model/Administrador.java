package model;

import java.io.Serializable;

public class Administrador implements Serializable{

	//Variables globales
	private String username;
	private String contrasena;
	
	//Constructor vacío
	public Administrador() {
		super();
	}
	
	//Constructor con variables
	public Administrador(String username, String contrasena) {
		super();
		this.username = username;
		this.contrasena = contrasena;
	}

	//Getters y setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
}
