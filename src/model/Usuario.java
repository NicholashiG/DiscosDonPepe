package model;

import java.io.Serializable;

public class Usuario implements Serializable {

	// Variables globales
	private String username;
	private String contrasena;
	private String email;
	private ListaCircular<Cancion> cancionesPropias;

	// Constructor vacío
	public Usuario() {
		super();
	}

	// Constructor con variables
	public Usuario(String username, String contrasena, String email, ListaCircular<Cancion> cancionesPropias) {
		super();
		this.username = username;
		this.contrasena = contrasena;
		this.email = email;
		this.cancionesPropias = cancionesPropias;
	}

	// Getters y setters
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ListaCircular<Cancion> getCancionesPropias() {
		return cancionesPropias;
	}

	public void setCancionesPropias(ListaCircular<Cancion> cancionesPropias) {
		this.cancionesPropias = cancionesPropias;
	}

}
