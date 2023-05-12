package model;

public class NodoCancion {
	Cancion cancion;
	NodoCancion izquierdo;
	NodoCancion derecho;

	NodoCancion(Cancion cancion) {
		this.cancion = cancion;
		this.izquierdo = null;
		this.derecho = null;
	}
}
