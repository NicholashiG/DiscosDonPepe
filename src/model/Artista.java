package model;

import java.io.Serializable;
import java.util.UUID;

public class Artista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5306084413826207578L;
	// Variables globales
	private String codigo;
	private String nombre;
	private String nacionalidad;
	private boolean isGrupo;
	private ListaDoblementeEnlazada<Cancion> canciones;

	// Constructor vacío
	public Artista() {
		super();
	}

	// Constructor con variables
	public Artista(String nombre, String nacionalidad, boolean isGrupo, ListaDoblementeEnlazada<Cancion> canciones) {
		super();
		this.codigo = generateCodigo();
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.isGrupo = isGrupo;
		this.canciones = canciones;
	}

	// Generador de Codigos Unicos.
	private String generateCodigo() {
		return UUID.randomUUID().toString();
	}
	
	// Getters y setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
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

	public ListaDoblementeEnlazada<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(ListaDoblementeEnlazada<Cancion> canciones) {
		this.canciones = canciones;
	}

	
	@Override
	public String toString() {
		return this.nombre;
	}
}
