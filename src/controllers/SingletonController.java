package controllers;

import java.io.IOException;

import model.DiscosDonPepe;
import persistencia.Persistencia;

public class SingletonController {

	DiscosDonPepe discos;

	private static SingletonController instancia = null;

	private SingletonController() {
		discos = new DiscosDonPepe();
	}

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

	// -------------------- SERIALIZACION XML Y TEXTO PLANO --------------------

	public DiscosDonPepe cargarCasaSubastasAnunciosBinario() throws IOException {
		DiscosDonPepe discos = Persistencia.cargarRecursoDiscosBinario();
		return discos;
	}

	public void guardarCasaSubastasBinario(DiscosDonPepe subastasQuindio) throws IOException {
		Persistencia.guardarRecursoDiscosBinario(subastasQuindio);
	}

}
