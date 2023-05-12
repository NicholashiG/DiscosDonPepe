package model;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class ListaCircular <T>implements Serializable{
	
	    private Nodo<T> cabeza;  // Referencia al primer nodo de la lista
	    private int tamaño;      // Tamaño actual de la lista

	    // Clase interna que representa un nodo de la lista
	    private static class Nodo<T> {
	        T dato;
	        Nodo<T> siguiente;

	        Nodo(T dato) {
	            this.dato = dato;
	        }
	    }

	    // Constructor de la lista
	    public ListaCircular() {
	        cabeza = null;
	        tamaño = 0;
	    }

	    // Verifica si la lista está vacía
	    public boolean estaVacia() {
	        return (tamaño == 0);
	    }

	    // Devuelve el tamaño actual de la lista
	    public int tamaño() {
	        return tamaño;
	    }

	    // Agrega un nuevo nodo al final de la lista
	    public void agregar(T dato) {
	        Nodo<T> nuevoNodo = new Nodo<>(dato);
	        if (estaVacia()) {
	            // Si la lista está vacía, el nuevo nodo se convierte en la cabeza y su siguiente es él mismo
	            cabeza = nuevoNodo;
	            cabeza.siguiente = cabeza;
	        } else {
	            // Si la lista no está vacía, el nuevo nodo se agrega después de la cabeza y su siguiente se establece
	            // en el nodo siguiente a la cabeza
	            nuevoNodo.siguiente = cabeza.siguiente;
	            cabeza.siguiente = nuevoNodo;
	        }
	        tamaño++;
	    }

	    // Elimina el primer nodo de la lista y devuelve su dato
	    public T eliminar() {
	        if (estaVacia()) {
	            // Si la lista está vacía, se lanza una excepción
	            throw new NoSuchElementException();
	        }
	        T dato = cabeza.dato;
	        if (tamaño == 1) {
	            // Si la lista tiene un solo nodo, se elimina la cabeza y la lista queda vacía
	            cabeza = null;
	        } else {
	            // Si la lista tiene más de un nodo, se elimina el nodo siguiente a la cabeza y la cabeza se actualiza
	            cabeza.siguiente = cabeza.siguiente.siguiente;
	        }
	        tamaño--;
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
}
