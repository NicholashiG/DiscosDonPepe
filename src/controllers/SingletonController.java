package controllers;

import java.io.IOException;

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
	
	
	// Agrega una cancion a la clase principal
	public void addCancion (Cancion c) {
		discos.getListaCanciones().add(c);
		System.out.println("Cancion Guardada.");
	}
	
	

	public void removeCancion(Cancion c) {
		discos.getListaCanciones().remove(c);
	}
	
	
	// Reemplaza la cancion con la id "codigo", con la cancion c.
	public void replaceCancion(String codigo, Cancion c) {
		discos.replaceCancion(codigo, c);
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
			//  (No se está usando)
	
	public void cargarDiscosDonPepeXML() throws IOException {
		this.discos = Persistencia.cargarRecursodiscosXML();
	}
	
	public void guardarDiscosDonPepeXML() throws IOException {
		Persistencia.guardarRecursodiscosXML(discos);
	}


}
