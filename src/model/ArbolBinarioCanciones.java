package model;

public class ArbolBinarioCanciones {

    // Clase interna que representa un NodoCancion del árbol
    
    private NodoCancion raiz;  // Referencia a la raíz del árbol

    // Constructor del árbol
    public ArbolBinarioCanciones() {
        raiz = null;
    }

    // Verifica si el árbol está vacío
    public boolean estaVacio() {
        return (raiz == null);
    }

    // Inserta una nueva canción en el árbol
    public void insertar(Cancion cancion) {
        raiz = insertar(raiz, cancion);
    }

    // Inserta una nueva canción en el árbol a partir de un NodoCancion dado
    private NodoCancion insertar(NodoCancion NodoCancion, Cancion cancion) {
        if (NodoCancion == null) {
            // Si el NodoCancion es nulo, se crea un nuevo NodoCancion con la canción
            NodoCancion = new NodoCancion(cancion);
        } else if (cancion.getNombreCancion().compareTo(NodoCancion.cancion.getNombreCancion()) < 0) {
            // Si el título de la canción es menor que el título de la canción del NodoCancion, se inserta en el subárbol izquierdo
            NodoCancion.izquierdo = insertar(NodoCancion.izquierdo, cancion);
        } else if (cancion.getNombreCancion().compareTo(NodoCancion.cancion.getNombreCancion()) > 0) {
            // Si el título de la canción es mayor que el título de la canción del NodoCancion, se inserta en el subárbol derecho
            NodoCancion.derecho = insertar(NodoCancion.derecho, cancion);
        }
        return NodoCancion;
    }

    // Busca una canción en el árbol a partir del título y del artista y devuelve la canción si se encuentra, null si no
    public Cancion buscar(String titulo, String artista) {
        return buscar(raiz, titulo, artista);
    }

    // Busca una canción en el árbol a partir de un NodoCancion dado y del título y del artista, y devuelve la canción si se encuentra, null si no
    private Cancion buscar(NodoCancion NodoCancion, String titulo, String artista) {
        if (NodoCancion == null) {
            // Si el NodoCancion es nulo, la canción no está en el árbol
            return null;
        } else if (titulo.compareTo(NodoCancion.cancion.getNombreCancion()) < 0) {
            // Si el título de la canción es menor que el título de la canción del NodoCancion, se busca en el subárbol izquierdo
            return buscar(NodoCancion.izquierdo, titulo, artista);
        } else if (titulo.compareTo(NodoCancion.cancion.getNombreCancion()) > 0) {
            // Si el título de la canción es mayor que el título de la canción del NodoCancion, se busca en el subárbol derecho
            return buscar(NodoCancion.derecho, titulo, artista);
        } else if (artista.compareTo(NodoCancion.cancion.getArtista().getNombre()) == 0) {
            // Si el título y el artista de la canción son iguales a los del NodoCancion, se encontró la canción en el árbol
            return NodoCancion.cancion;
        } else {
            // Si el título de la canción es igual al título del NodoCancion pero el artista no es igual, se busca en el subárbol derecho
            return buscar(NodoCancion.derecho, titulo, artista);
        }
    }

    // Elimina una canción del árbol a partir del título y del artista
    public void eliminar(String titulo, String artista) {
        raiz = eliminar(raiz, titulo, artista);
    }

    // Elimina una canción del árbol a partir de un NodoCancion dado y del título y del artista
    private NodoCancion eliminar(NodoCancion NodoCancion, String titulo, String artista) {
        if (NodoCancion == null) {
            // Si el NodoCancion es nulo, no se encontró la canción en el árbol
            return null;
        } else if (titulo.compareTo(NodoCancion.cancion.getNombreCancion()) < 0) {
            // Si el título de la canción es menor que el título de la canción del NodoCancion, se busca en el subárbol izquierdo
            NodoCancion.izquierdo = eliminar(NodoCancion.izquierdo, titulo, artista);
        } else if (titulo.compareTo(NodoCancion.cancion.getNombreCancion()) > 0) {
            // Si el título de la canción es mayor que el título de la canción del NodoCancion, se busca en el subárbol derecho
            NodoCancion.derecho = eliminar(NodoCancion.derecho, titulo, artista);
        } else if (artista.compareTo(NodoCancion.cancion.getArtista().getNombre()) == 0) {
            // Si el título y el artista de la canción son iguales a los del NodoCancion, se encontró el NodoCancion que contiene la canción
            if (NodoCancion.izquierdo == null) {
                // Si el NodoCancion no tiene subárbol izquierdo, se devuelve el subárbol derecho
                return NodoCancion.derecho;
            } else if (NodoCancion.derecho == null) {
                // Si el NodoCancion no tiene subárbol derecho, se devuelve el subárbol izquierdo
                return NodoCancion.izquierdo;
            } else {
                // Si el NodoCancion tiene ambos subárboles, se busca el sucesor en orden del NodoCancion y se reemplaza la canción
                NodoCancion sucesor = encontrarMinimo(NodoCancion.derecho);
                NodoCancion.cancion = sucesor.cancion;
                NodoCancion.derecho = eliminar(NodoCancion.derecho, sucesor.cancion.getNombreCancion(), sucesor.cancion.getArtista().getNombre());
            }
        } else {
            // Si el título de la canción es igual al título del NodoCancion pero el artista no es igual, se busca en el subárbol derecho
            NodoCancion.derecho = eliminar(NodoCancion.derecho, titulo, artista);
        }
        return NodoCancion;
    }

    // Encuentra el NodoCancion con el valor mínimo en un subárbol a partir de un NodoCancion dado
    private NodoCancion encontrarMinimo(NodoCancion NodoCancion) {
        while (NodoCancion.izquierdo != null) {
            NodoCancion = NodoCancion.izquierdo;
        }
        return NodoCancion;
    }

    // Imprime las canciones del árbol en orden
    public void imprimirEnOrden() {
        imprimirEnOrden(raiz);
        System.out.println();
    }

    // Imprime las canciones del árbol en orden a partir de un NodoCancion dado
    private void imprimirEnOrden(NodoCancion NodoCancion) {
        if (NodoCancion != null) {
            imprimirEnOrden(NodoCancion.izquierdo);
            System.out.println(NodoCancion.cancion);
            imprimirEnOrden(NodoCancion.derecho);
        }
    }
}