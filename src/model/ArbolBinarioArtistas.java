package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ArbolBinarioArtistas implements Serializable {

	private static final long serialVersionUID = -9168874069359112695L;
	
	
	private NodoArtista raiz; // Referencia a la raíz del árbol

	// Constructor del árbol
	public ArbolBinarioArtistas() {
		raiz = null;
	}

	// Verifica si el árbol está vacío
	public boolean estaVacio() {
		return (raiz == null);
	}

	// Inserta un nuevo artista en el árbol
	public void insertar(Artista artista) {
		raiz = insertar(raiz, artista);
	}

	// Inserta un nuevo artista en el árbol a partir de un nodo dado
	private NodoArtista insertar(NodoArtista nodo, Artista artista) {
		if (nodo == null) {
			// Si el nodo es nulo, se crea un nuevo nodo con el artista
			nodo = new NodoArtista(artista);
		} else if (artista.getNombre().compareTo(nodo.artista.getNombre()) < 0) {
			// Si el nombre del artista es menor que el nombre del artista del nodo, se
			// inserta en el subárbol izquierdo
			nodo.izquierdo = insertar(nodo.izquierdo, artista);
		} else if (artista.getNombre().compareTo(nodo.artista.getNombre()) > 0) {
			// Si el nombre del artista es mayor que el nombre del artista del nodo, se
			// inserta en el subárbol derecho
			nodo.derecho = insertar(nodo.derecho, artista);
		}
		return nodo;
	}

	// Busca un artista en el árbol a partir del nombre y devuelve el artista si se
	// encuentra, null si no
	public NodoArtista buscar(String nombre) {
		return buscar(raiz, nombre);
	}

	// Busca un artista en el árbol a partir de un nodo dado y del nombre, y
	// devuelve el artista si se encuentra, null si no
	private NodoArtista buscar(NodoArtista nodo, String nombre) {
		if (nodo == null) {
			// Si el nodo es nulo, el artista no está en el árbol
			return null;
		} else if (nombre.compareTo(nodo.artista.getNombre()) < 0) {
			// Si el nombre del artista es menor que el nombre del artista del nodo, se
			// busca en el subárbol izquierdo
			return buscar(nodo.izquierdo, nombre);
		} else if (nombre.compareTo(nodo.artista.getNombre()) > 0) {
			// Si el nombre del artista es mayor que el nombre del artista del nodo, se
			// busca en el subárbol derecho
			return buscar(nodo.derecho, nombre);
		} else {
			// Si el nombre del artista es igual al nombre del artista del nodo, se encontró
			// el artista en el árbol
			return nodo;
		}
	}

	// Busca un artista en el árbol a partir de un nodo dado y del nombre, y
	// devuelve la lista de canciones, null si no
	private ListaDoblementeEnlazada<Cancion> buscarArtistaCanciones(NodoArtista nodo, String nombre) {
		Artista artistaBuscado = buscar(nodo, nombre).getArtista();
		if (artistaBuscado == null) {
			// Si es nulo, el artista no está en el árbol
			return null;
		} else {
			// Si el artista existe, debe devolver la lista doblemente enlazada
			// de canciones
			return artistaBuscado.getCanciones();
		}
	}

	// Elimina un artista del árbol a partir del nombre
	public void eliminar(String nombre) {
		raiz = eliminar(raiz, nombre);
	}

	// Elimina un artista del árbol a partir de un nodo dado y del nombre
	private NodoArtista eliminar(NodoArtista nodo, String nombre) {
		if (nodo == null) {
			// Si el nodo es nulo, no se encontró el artista en el árbol
			return null;
		} else if (nombre.compareTo(nodo.artista.getNombre()) < 0) {
			// Si el nombre del artista es menor que el nombre del artista del nodo, se
			// busca en el subárbol izquierdo
			nodo.izquierdo = eliminar(nodo.izquierdo, nombre);
		} else if (nombre.compareTo(nodo.artista.getNombre()) > 0) {
			// Si el nombre del artista es mayor que el nombre del artista del nodo, se
			// busca en el subárbol derecho
			nodo.derecho = eliminar(nodo.derecho, nombre);
		} else {
			// Si el nombre del artista es igual al nombre del artista del nodo, se encontró
			// el nodo que contiene el artista
			if (nodo.izquierdo == null) {
				// Si el nodo no tiene subárbol izquierdo, se devuelve el subárbol derecho
				return nodo.derecho;
			} else if (nodo.derecho == null) {
				// Si el nodo no tiene subárbol derecho, se devuelve el subárbol izquierdo
				return nodo.izquierdo;
			} else {
				// Si el nodo tiene ambos subárboles, se busca el sucesor en orden del nodo y se
				// reemplaza el artista
				NodoArtista sucesor = encontrarMinimo(nodo.derecho);
				nodo.artista = sucesor.artista;
				nodo.derecho = eliminar(nodo.derecho, sucesor.artista.getNombre());
			}
		}
		return nodo;
	}

	// Encuentra el nodo con el valor mínimo en un subárbol a partir de un nodo dado
	private NodoArtista encontrarMinimo(NodoArtista nodo) {
		while (nodo.izquierdo != null) {
			nodo = nodo.izquierdo;
		}
		return nodo;
	}
	
	public void replaceArtista(Artista actual, Artista nuevo) {
		buscar(actual.getNombre()).setArtista(nuevo);
	}

	// Imprime los artistas del árbol en orden
	public void imprimirEnOrden() {
		imprimirEnOrden(raiz);
		System.out.println();
	}

	// Imprime los artistas del árbol en orden a partir de un nodo dado
	private void imprimirEnOrden(NodoArtista nodo) {
		if (nodo != null) {
			imprimirEnOrden(nodo.izquierdo);
			System.out.println(nodo.artista);
			imprimirEnOrden(nodo.derecho);
		}
	}
	
	public ArrayList<Artista> toArray() {
		return toArray(new ArrayList<Artista>(), raiz);
	}
	
	public ArrayList<Artista> toArray( ArrayList<Artista> array, NodoArtista nodo) {
		if (nodo == null) return array;
		else {
			System.out.println(nodo.artista);
			array.add(nodo.getArtista());
			array = toArray(array,nodo.izquierdo);

			array = toArray(array, nodo.derecho);
		}
		return array;
	}
	
}