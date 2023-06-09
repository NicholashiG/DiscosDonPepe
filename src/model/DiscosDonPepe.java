package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiscosDonPepe implements Serializable {

	private static final long serialVersionUID = -6664315431035343066L;

	HashMap<String, String> hashMapUsuarios = new HashMap<>();
	ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
	ArbolBinarioArtistas arbolArtistas = new ArbolBinarioArtistas();
	Usuario usuarioLogeado;


	public DiscosDonPepe() {
	}

	public HashMap<String, String> getHashMapUsuarios() {
		return hashMapUsuarios;
	}

	public void setHashMapUsuarios(HashMap<String, String> hashMapUsuarios) {
		this.hashMapUsuarios = hashMapUsuarios;
	}

	public ArbolBinarioArtistas getArbolArtistas() {
		return arbolArtistas;
	}

	public void setArbolArtistas(ArbolBinarioArtistas arbolArtistas) {
		this.arbolArtistas = arbolArtistas;
	}

	public ArrayList<Cancion> getListaCanciones() {
		return listaCanciones;
	}

	public void setListaCanciones(ArrayList<Cancion> listaCanciones) {
		this.listaCanciones = listaCanciones;
	}

	public Usuario getUsuarioLogeado() {
		 return usuarioLogeado;
	}

	public void setUsuarioLogeado(Usuario usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}


    // Inicio búsqueda O

	// Método estático que realiza la búsqueda de canciones por los nombres de la canción o del álbum. Esta versión del método es para la versión de o
	// es decir, que puede coincidir uno de los dos o los dos
    public ArrayList<Cancion> buscarCancionesPorNombresVersionO(String nombre, String album) throws InterruptedException {
        // Seteamos toda la lista de canciones de todos los artistas creados

    	ArrayList<Cancion> canciones = listaCanciones;
        // Calculamos el índice de la mitad de la lista de canciones
        int mitad = canciones.size() / 2;
        // Creamos una lista para almacenar las canciones que coincidan con los atributos buscados
        ArrayList<Cancion> resultado = new ArrayList<>();

        // Creamos dos objetos Thread para realizar la búsqueda en paralelo
        Thread hiloIzquierda = new Thread(() -> buscarEnMitadNombresVersionO(canciones.subList(0, mitad), nombre, album, resultado));
        Thread hiloDerecha = new Thread(() -> buscarEnMitadNombresVersionO(canciones.subList(mitad, canciones.size()), nombre, album, resultado));
        
        /*
         * Nota para entender la forma de creación de los hilos de acá arriba: estos hilos se crean con una expresión lambda, 
         * lo que hace que la tarea del hilo sea lo que se mande luego de "->", en este caso, que cada hilo ejecute el método
         * de buscarEnMitad y uno lo haga desde el principio a la mitad y el otro lo haga desde la mitad hasta el final.
         * Para más entendimiento, en vez de poner esa expresión lambda, se puede hacer de la siguiente
         *  manera usando una clase interna, lo cual es innecesario y un poco tedioso:
         * 
         
         class BuscarEnMitadIzquierda implements Runnable {
    		@Override
    		public void run() {
        		buscarEnMitad(canciones.subList(0, mitad), nombre, artista, resultado);
    		}
		 }			
		 Thread hiloIzquierda = new Thread(new BuscarEnMitadIzquierda());
		 
		 * De esta forma se hubiese hecho. Queda este comentario con la idea de entender de dónde salieron esos hilos
         */

        // Iniciamos los hilos
        hiloIzquierda.start();
        hiloDerecha.start();

        // Esperamos a que terminen los hilos
        hiloIzquierda.join();
        hiloDerecha.join();
        // Devolvemos la lista de canciones que coinciden con al menos uno de los atributos buscados
        return resultado;
    }

    // Método privado que realiza la búsqueda de canciones en una mitad de la lista, esta forma busca el nombre de la cancion O nombre del album
    // los cuales coincidan con el criterio de búsqueda
    private void buscarEnMitadNombresVersionO(List<Cancion> canciones, String nombreCancion, String nombreAlbum, ArrayList<Cancion> resultado) {
    	// Recorremos la mitad de la lista de canciones
        for (Cancion cancion : canciones) {
            // Si el nombre de la canción o el nombre del artista coinciden con los atributos buscados, añadimos la canción al resultado
            if (cancion.getNombreCancion().equals(nombreCancion) || cancion.getNombreAlbum().equals(nombreAlbum)) {
                synchronized (resultado) {

                    resultado.add(cancion);
                }
            }
        }
    }



    // Fin de búsqueda O

    // -------------------

    // Inicio búsqueda Y

	// Método estático que realiza la búsqueda de canciones por los el año del álbum
	// y el género. Esta versión del método es para la versión de Y
	// es decir, que deben coincidir los dos atributos
	public ArrayList<Cancion> buscarCancionesPorAnioGeneroVersionY(String anio, String genero) throws InterruptedException {
		// Seteamos toda la lista de canciones de todos los artistas creados
    	ArrayList<Cancion> canciones = listaCanciones;
        // Calculamos el índice de la mitad de la lista de canciones
        int mitad = canciones.size() / 2;
		// Creamos una lista para almacenar las canciones que coincidan con los
		// atributos buscados
		ArrayList<Cancion> resultado = new ArrayList<>();

		// Creamos dos objetos Thread para realizar la búsqueda en paralelo
		Thread hiloIzquierda = new Thread(
				() -> buscarEnMitadNombresVersionY(canciones.subList(0, mitad), anio, genero, resultado));
		Thread hiloDerecha = new Thread(() -> buscarEnMitadNombresVersionY(canciones.subList(mitad, canciones.size()),
				anio, genero, resultado));
         
         /*
          * Nota para entender la forma de creación de los hilos de acá arriba: estos hilos se crean con una expresión lambda, 
          * lo que hace que la tarea del hilo sea lo que se mande luego de "->", en este caso, que cada hilo ejecute el método
          * de buscarEnMitad y uno lo haga desde el principio a la mitad y el otro lo haga desde la mitad hasta el final.
          * Para más entendimiento, en vez de poner esa expresión lambda, se puede hacer de la siguiente
          *  manera usando una clase interna, lo cual es innecesario y un poco tedioso:
          * 
          
          class BuscarEnMitadIzquierda implements Runnable {
     		@Override
     		public void run() {
         		buscarEnMitad(canciones.subList(0, mitad), nombre, artista, resultado);
     		}
 		 }			
 		 Thread hiloIzquierda = new Thread(new BuscarEnMitadIzquierda());
 		 
 		 * De esta forma se hubiese hecho. Queda este comentario con la idea de entender de dónde salieron esos hilos
          */

			// Iniciamos los hilos
			hiloIzquierda.start();
			hiloDerecha.start();

			// Esperamos a que terminen los hilos
			hiloIzquierda.join();
			hiloDerecha.join();

			// Devolvemos la lista de canciones que coinciden con al menos uno de los
			// atributos buscados
			return resultado;
		}

		// Método privado que realiza la búsqueda de canciones en una mitad de la lista,
		// esta forma busca el año Y género de la canción los cuales coincidan con el criterio de búsqueda
		private void buscarEnMitadNombresVersionY(List<Cancion> canciones, String anio, String genero, ArrayList<Cancion> resultado) {
			// Recorremos la mitad de la lista de canciones
			for (Cancion cancion : canciones) {
				// Si el nombre de la canción o el nombre del artista coinciden con los
				// atributos buscados, añadimos la canción al resultado
				if (cancion.getAnio() == (Integer.parseInt(anio)) && cancion.getGenero().toString().equals(genero)) {
					synchronized (resultado) {
						resultado.add(cancion);
					}
				}
			}
		}

	// Fin de búsqueda Y
	// -------------------




	public void replaceCancion(String codigo, Cancion c) {

		for(Cancion cancion: listaCanciones) {
			if (cancion.getCodigo().equals(codigo)) listaCanciones.set(listaCanciones.indexOf(cancion), c);
		}


	}

	public ArrayList<Cancion> buscarCancionesVersionO(String nombre, String album, String anio, String genero) throws InterruptedException {
		// Seteamos toda la lista de canciones de todos los artistas creados

		ArrayList<Cancion> canciones = usuarioLogeado.getCancionesPropias().listaCircularToArray(usuarioLogeado.getCancionesPropias());
		// Calculamos el índice de la mitad de la lista de canciones
		int mitad = canciones.size() / 2;
		// Creamos una lista para almacenar las canciones que coincidan con los atributos buscados
		ArrayList<Cancion> resultado = new ArrayList<>();

		// Creamos dos objetos Thread para realizar la búsqueda en paralelo
		Thread hiloIzquierda = new Thread(() -> buscarEnMitadCancionesVersionO(canciones.subList(0, mitad), nombre, album, anio ,genero, resultado));
		Thread hiloDerecha = new Thread(() -> buscarEnMitadCancionesVersionO(canciones.subList(mitad, canciones.size()), nombre, album, anio ,genero, resultado));

        /*
         * Nota para entender la forma de creación de los hilos de acá arriba: estos hilos se crean con una expresión lambda,
         * lo que hace que la tarea del hilo sea lo que se mande luego de "->", en este caso, que cada hilo ejecute el método
         * de buscarEnMitad y uno lo haga desde el principio a la mitad y el otro lo haga desde la mitad hasta el final.
         * Para más entendimiento, en vez de poner esa expresión lambda, se puede hacer de la siguiente
         *  manera usando una clase interna, lo cual es innecesario y un poco tedioso:
         *

         class BuscarEnMitadIzquierda implements Runnable {
    		@Override
    		public void run() {
        		buscarEnMitad(canciones.subList(0, mitad), nombre, artista, resultado);
    		}
		 }
		 Thread hiloIzquierda = new Thread(new BuscarEnMitadIzquierda());

		 * De esta forma se hubiese hecho. Queda este comentario con la idea de entender de dónde salieron esos hilos
         */

		// Iniciamos los hilos
		hiloIzquierda.start();
		hiloDerecha.start();

		// Esperamos a que terminen los hilos
		hiloIzquierda.join();
		hiloDerecha.join();
		// Devolvemos la lista de canciones que coinciden con al menos uno de los atributos buscados
		return resultado;
	}

	private void buscarEnMitadCancionesVersionO(List<Cancion> canciones, String nombre, String album, String anio, String genero, ArrayList<Cancion> resultado) {
		// Recorremos la mitad de la lista de canciones
		for (Cancion cancion : canciones) {
			// Si el nombre de la canción o el nombre del artista coinciden con los atributos buscados, añadimos la canción al resultado
			if (cancion.getNombreCancion().equals(nombre) || cancion.getNombreAlbum().equals(album) || cancion.getAnio()==(Integer.parseInt(anio)) || cancion.getGenero().toString().equals(genero)) {
				synchronized (resultado) {

					resultado.add(cancion);
				}
			}
		}
	}
		
	}
