package model;

import java.io.Serializable;

public class Artista implements Serializable {

	// Variables globales
	private int codigo;
	private String nombre;
	private String nacionalidad;
	private boolean isGrupo;

	// Constructor vacío
	public Artista() {
		super();
	}

	// Constructor con variables
	public Artista(int codigo, String nombre, String nacionalidad, boolean isGrupo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.isGrupo = isGrupo;
	}

	// Getters y setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public boolean isGrupo() {
		return isGrupo;
	}

	public void setGrupo(boolean isGrupo) {
		this.isGrupo = isGrupo;
	}

}
