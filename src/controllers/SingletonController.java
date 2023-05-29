package controllers;

import java.io.IOException;
import java.util.ArrayList;

import model.Artista;
import model.Cancion;
import model.DiscosDonPepe;
import persistencia.Persistencia;

public class SingletonController {

	DiscosDonPepe discos;

	private static SingletonController instancia = null;

	private SingletonController() {
		discos = new DiscosDonPepe();
	}

	// ------------- FUNCIONES DEL SINGLETON --------------------
	
	public static SingletonController getInstance() {
		// Asegura una unica instancia
		if (instancia == null) {
			instancia = new SingletonController();
		}
		return instancia;
	}
	

	public DiscosDonPepe getDiscos() {
		return discos;
	}

	public void setDiscos(DiscosDonPepe discos) {
		this.discos = discos;
	}

	public static SingletonController getInstancia() {
		return instancia;
	}

	public static void setInstancia(SingletonController instancia) {
		SingletonController.instancia = instancia;
	}

	
	
	
	
	
	
	// -------------------- FUNCIONALIDADES PROPIAS --------------------
	
	// Canciones
	
	// Agrega una cancion a la clase principal
	public void addCancion (Cancion c) {
		discos.getListaCanciones().add(c);
	}
	

	public void removeCancion(Cancion c) {
		discos.getListaCanciones().remove(c);
	}
	
	
	// Reemplaza la cancion con la id "codigo", con la cancion c.
	public void replaceCancion(String codigo, Cancion c) {
		discos.replaceCancion(codigo, c);
	}
	
	
	// Artistas
	
	public void addArtista(Artista a) {
		discos.getArbolArtistas().insertar(a);
	}
	
	
	public void removeArtista(Artista a) {
		discos.getArbolArtistas().eliminar(a.getNombre());
	}
	
	public void replaceArtista(Artista actual, Artista nuevo) {
		discos.getArbolArtistas().replaceArtista(actual, nuevo);
	}
	
	
	
	// -------------------- BUSQUEDAS ----------------------------
	
	// Busqueda O
	
	public ArrayList<Cancion> busquedaO(String nombre, String album) throws InterruptedException {
		
		return discos.buscarCancionesPorNombresVersionO(nombre, album);
		
	}


	
	// Busqueda Y
	
	public ArrayList<Cancion> busquedaY(String anio, String genero) throws InterruptedException {
		
		return discos.buscarCancionesPorAnioGeneroVersionY(anio, genero);
		
	}

	
	// -------------------- SERIALIZACION XML Y TEXTO PLANO --------------------

	
// ------------------ BINARIO -------------------------------
	
	public DiscosDonPepe cargarDIscosDonPepeBinario() throws IOException {
		this.discos = Persistencia.cargarRecursoDiscosBinario();
		return discos;
	}

	public void guardarDiscosDonPepeBinario(DiscosDonPepe discos) throws IOException {
		Persistencia.guardarRecursoDiscosBinario(discos);
	}
	
	
// ------------------ XML -------------------------------
			//  (No se est� usando)
	
	public void cargarDiscosDonPepeXML() throws IOException {
		this.discos = Persistencia.cargarRecursodiscosXML();
	}
	
	public void guardarDiscosDonPepeXML() throws IOException {
		Persistencia.guardarRecursodiscosXML(discos);
	}



}
