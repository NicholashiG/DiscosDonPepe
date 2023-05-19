package model;

import java.io.Serializable;
import java.util.UUID;

public class Cancion implements Serializable {

	// Variables globales
	private String codigo;
	private String nombreCancion;
	private String nombreAlbum;
	private String URLAlbum;
	private int anio;
	private double duracion;
	private Generos genero;
	private String URLYT;

	// Constructor vacío
	public Cancion() {
		super();
	}

	// Constructor con variables globales
	public Cancion(String nombreCancion, String nombreAlbum, String uRLAlbum, int anio,
			double duracion, Generos genero, String uRLYT) {
		super();
		this.codigo = generateCodigo();
		this.nombreCancion = nombreCancion;
		this.nombreAlbum = nombreAlbum;
		URLAlbum = uRLAlbum;
		this.anio = anio;
		this.duracion = duracion;
		this.genero = genero;
		URLYT = uRLYT;
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

	public String getNombreCancion() {
		return nombreCancion;
	}

	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}

	public String getNombreAlbum() {
		return nombreAlbum;
	}

	public void setNombreAlbum(String nombreAlbum) {
		this.nombreAlbum = nombreAlbum;
	}


	public String getURLAlbum() {
		return URLAlbum;
	}

	public void setURLAlbum(String uRLAlbum) {
		URLAlbum = uRLAlbum;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public Generos getGenero() {
		return genero;
	}

	public void setGenero(Generos genero) {
		this.genero = genero;
	}

	public String getURLYT() {
		return URLYT;
	}

	public void setURLYT(String uRLYT) {
		URLYT = uRLYT;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombreCancion + " - " + nombreAlbum  + "		" + duracion;
	}
	
}
