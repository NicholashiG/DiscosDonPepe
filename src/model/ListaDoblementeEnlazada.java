package model;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class ListaDoblementeEnlazada<T> implements Serializable{
	
	private Nodo<T> cabeza;  // Referencia al primer nodo de la lista
    private Nodo<T> cola;    // Referencia al último nodo de la lista
    private int tamaño;      // Tamaño actual de la lista

    // Constructor de la lista
    public ListaDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    // Verifica si la lista está vacía
    public boolean estaVacia() {
        return (tamaño == 0);
    }

    // Devuelve el tamaño de la lista
    public int tamaño() {
        return tamaño;
    }

    // Agrega un nuevo nodo al principio de la lista
    public void agregarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            // Si la lista está vacía, el nuevo nodo se convierte en la cabeza y la cola
            cola = nuevoNodo;
        } else {
            // Si la lista no está vacía, el nuevo nodo se convierte en la nueva cabeza y la referencia
            // anterior del nodo siguiente a la cabeza se establece en el nuevo nodo
            cabeza.anterior = nuevoNodo;
        }
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        tamaño++;
    }

    // Agrega un nuevo nodo al final de la lista
    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            // Si la lista está vacía, el nuevo nodo se convierte en la cabeza y la cola
            cabeza = nuevoNodo;
        } else {
            // Si la lista no está vacía, el nuevo nodo se convierte en la nueva cola y la referencia
            // siguiente del nodo anterior a la cola se establece en el nuevo nodo
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
        }
        cola = nuevoNodo;
        tamaño++;
    }

    // Elimina el primer nodo de la lista y devuelve su dato
    public T eliminarAlInicio() {
        if (estaVacia()) {
            // Si la lista está vacía, se lanza una excepción
            throw new NoSuchElementException();
        }
        T dato = cabeza.dato;
        cabeza = cabeza.siguiente;
        tamaño--;
        if (estaVacia()) {
            // Si la lista quedó vacía después de eliminar el primer nodo, la cola también se establece en nulo
            cola = null;
        } else {
            cabeza.anterior = null;
        }
        return dato;
    }

    // Elimina el último nodo de la lista y devuelve su dato
    public T eliminarAlFinal() {
        if (estaVacia()) {
            // Si la lista está vacía, se lanza una excepción
            throw new NoSuchElementException();
        }
        T dato = cola.dato;
        cola = cola.anterior;
        tamaño--;
        if (estaVacia()) {
            // Si la lista quedó vacía después de eliminar el último nodo, la cabeza también se establece en nulo
            cabeza = null;
        } else {
            cola.siguiente = null;
        }
        return dato;
    }

    // Devuelve el dato del primer nodo de la lista sin eliminarlo
    public T verAlInicio() {
        if (estaVacia()) {
            // Si la lista está vacía, se lanza una excepción
            throw new NoSuchElementException();
        }
        return cabeza.dato;
    }

    // Devuelve el dato del último nodo de la lista sin eliminarlo
    public T verAlFinal() {
        if (estaVacia()) {
            // Si la lista está vacía, se lanza una excepción
            throw new NoSuchElementException();
        }
        return cola.dato;
    }

    // Verifica si un dato dado está contenido en la lista
    public boolean contiene(T dato) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Elimina todos los nodos de la lista
    public void limpiar() {
        cabeza = null;
        cola = null;
        tamaño = 0;
    }

    // Imprime todos los datos de la lista
    public void imprimirLista() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }


}
