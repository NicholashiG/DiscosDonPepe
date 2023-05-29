package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ListaCircular<T> implements Serializable {

	private Nodo<T> cabeza; // Referencia al primer nodo de la lista
	private int tamano; // Tamaño actual de la lista


	public Nodo<T> getCabeza() {
		return cabeza;
	}

	public void setCabeza(Nodo<T> cabeza) {
		this.cabeza = cabeza;
	}

	// Constructor de la lista
	public ListaCircular() {
		cabeza = null;
		tamano = 0;
	}

	// Verifica si la lista está vacía
	public boolean estaVacia() {
		return (tamano == 0);
	}

	// Devuelve el tamaño actual de la lista
	public int tamano() {
		return tamano;
	}

	// Agrega un nuevo nodo al final de la lista
	public void agregar(T dato) {
		Nodo<T> nuevoNodo = new Nodo<>(dato);
		if (estaVacia()) {
			// Si la lista está vacía, el nuevo nodo se convierte en la cabeza y su
			// siguiente es él mismo
			cabeza = nuevoNodo;
			cabeza.siguiente = cabeza;
		} else {
			// Si la lista no está vacía, el nuevo nodo se agrega después de la cabeza y su
			// siguiente se establece
			// en el nodo siguiente a la cabeza
			nuevoNodo.siguiente = cabeza.siguiente;
			cabeza.siguiente = nuevoNodo;
		}
		tamano++;
	}

	// Elimina el primer nodo de la lista y devuelve su dato
	public T eliminar() {
		if (estaVacia()) {
			// Si la lista está vacía, se lanza una excepción
			throw new NoSuchElementException();
		}
		T dato = cabeza.dato;
		if (tamano == 1) {
			// Si la lista tiene un solo nodo, se elimina la cabeza y la lista queda vacía
			cabeza = null;
		} else {
			// Si la lista tiene más de un nodo, se elimina el nodo siguiente a la cabeza y
			// la cabeza se actualiza
			cabeza.siguiente = cabeza.siguiente.siguiente;
		}
		tamano--;
		return dato;
	}

	// Devuelve el dato del primer nodo de la lista sin eliminarlo
	public T ver() {
		if (estaVacia()) {
			// Si la lista está vacía, se lanza una excepción
			throw new NoSuchElementException();
		}
		return cabeza.dato;
	}

	// Imprime todos los datos de la lista
	public void imprimirLista() {
		if (estaVacia()) {
			// Si la lista está vacía, se imprime un mensaje
			System.out.println("La lista está vacía.");
		} else {
			Nodo<T> actual = cabeza;
			do {
				System.out.print(actual.dato + " ");
				actual = actual.siguiente;
			} while (actual != cabeza);
			System.out.println();
		}
	}
	
	public T[] toArray() {
        if (tamano == 0) {
            return null;
        }

        //Crear un arreglo del tipo genérico T con el tamaño de la lista
        T[] array = (T[]) new Object[tamano];

        //Recorrer la lista y agregar los elementos al arreglo
        Nodo<T> nodoActual = cabeza;
        for (int i = 0; i < tamano; i++) {
            array[i] = nodoActual.getDato();
            nodoActual = nodoActual.getSiguiente();
        }

        return array;
    }

	public ArrayList<T> listaCircularToArray(ListaCircular<T> lista) {
		ArrayList<T> array = new ArrayList<>();
		Nodo<T> actual = lista.getCabeza();

		if (actual != null) {
			Nodo<T> siguiente = actual.getSiguiente();

			do {
				array.add(actual.getDato());
				actual = siguiente;
				siguiente = siguiente.getSiguiente();
			} while (actual != lista.getCabeza());
		}
		return array;
	}
	
	public ListaCircular<T> toListaCircular( ArrayList<T> array) {
		ListaCircular<T> lista = new ListaCircular<T>();
		for (T objeto : array) lista.agregar(objeto);
		return lista;
	}








}
