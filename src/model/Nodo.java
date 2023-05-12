package model;

public class Nodo<T> {
    T dato;
    Nodo<T> anterior;
    Nodo<T> siguiente;

    Nodo(T dato) {
        this.dato = dato;
    }

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public Nodo<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo<T> anterior) {
		this.anterior = anterior;
	}

	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}
    
    
}
