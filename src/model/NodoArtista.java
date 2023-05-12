package model;

import java.io.Serializable;

public class NodoArtista implements Serializable {
	Artista artista;
	NodoArtista izquierdo;
	NodoArtista derecho;

	NodoArtista(Artista artista) {
		this.artista = artista;
		this.izquierdo = null;
		this.derecho = null;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public NodoArtista getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(NodoArtista izquierdo) {
		this.izquierdo = izquierdo;
	}

	public NodoArtista getDerecho() {
		return derecho;
	}

	public void setDerecho(NodoArtista derecho) {
		this.derecho = derecho;
	}

}
