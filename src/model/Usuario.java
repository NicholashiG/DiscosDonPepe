package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

	// Variables globales
	private String username;
	private String contrasena;
	private String email;
	private ListaCircular<Cancion> cancionesPropias;

	// Constructor vacío
	public Usuario() {
		super();
	}

	// Constructor con variables
	public Usuario(String username, String contrasena, String email, ListaCircular<Cancion> cancionesPropias) {
		super();
		this.username = username;
		this.contrasena = contrasena;
		this.email = email;
		this.cancionesPropias = cancionesPropias;
	}

	// Getters y setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ListaCircular<Cancion> getCancionesPropias() {
		return cancionesPropias;
	}

	public void setCancionesPropias(ListaCircular<Cancion> cancionesPropias) {
		this.cancionesPropias = cancionesPropias;
	}

	
	// Este método recibe el atributo por el cual se le quiera ordenar, hay que
	// tener en cuenta de que el nombre del atributo debe de ser igual que los de la
	// clase Cancion, de lo contrario, el método no servirá y posiblemente petará;
	// para ello, desde la interfaz gráfica y los controladores se deben llamar de
	// la misma forma a los atributos, es muy necesario
	public ArrayList<Cancion> ordenarPorAtributo(String nombreAtributo) {
		// Se setea la lista circular de cancionesPropias del usuario
		ListaCircular<Cancion> lista = cancionesPropias;
		// Obtiene el tamaño de la lista y crea un arreglo a partir de ella
		int n = lista.tamano();
		Cancion[] array = lista.toArray();
		// Se crea un arraylist donde se guardarán las canciones ordenadas
		ArrayList<Cancion> cancionesOrdenadas = new ArrayList<>();

		// Algoritmo de ordenamiento burbuja con reflexión
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				try {
					// Obtiene el valor del atributo correspondiente al campo indicado por el
					// parámetro "nombreAtributo"
					
					String valor1 = (String) array[j].getClass().getMethod("get" + nombreAtributo).invoke(array[j]).toString();
					String valor2 = (String) array[j + 1].getClass().getMethod("get" + nombreAtributo).invoke(array[j + 1]).toString();
					
					/*
					 * Los métodos de .getMethod() y .invoke necesitan explicación:
					 * 
					 * El parámetro "nombreAtributo" es el nombre del atributo por el cual se desea
					 * ordenar, en este caso, debe ser un atributo de tipo String. Luego, se utiliza
					 * el método "getMethod" de la clase "Class" para obtener el método
					 * correspondiente al nombre del atributo (por ejemplo, si el nombre del
					 * atributo es "nombreCancion", se busca el método "getNombreCancion"). Una vez
					 * obtenido el método, se utiliza el método "invoke" para llamar al método en
					 * cada uno de los elementos del arreglo y obtener el valor del atributo
					 * correspondiente. Finalmente, se aplica el algoritmo de ordenamiento burbuja
					 * sobre el arreglo utilizando los valores obtenidos por reflexión.
					 * 
					 * .invoke devuelve un objeto que representa el valor de retorno del método
					 * invocado. Es una forma de acceder a los campos y métodos de un objeto en
					 * tiempo de ejecución, lo cual puede ser muy útil en situaciones en las que se
					 * necesite trabajar con objetos de diferentes clases o en las que se requiera
					 * una mayor flexibilidad en el código.
					 * 
					 * Espero con esta explicación haya quedado un poco más claro lo que es el
					 * .getMethod() y .invoke 
					 * 
					 * ~N
					 */

					// Compara los valores obtenidos e intercambia los elementos del arreglo si es
					// necesario
					if (valor1.compareTo(valor2) > 0) {
						Cancion temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;
					}
				} catch (Exception e) {
					// Maneja cualquier excepción que pueda ocurrir al invocar el método mediante
					// reflexión
					e.printStackTrace();
				}
			}
		}

		// Agrega los elementos ordenados en el orden correspondiente
		for (int i = 0; i < n; i++) {
			cancionesOrdenadas.add(array[i]);
		}
		return cancionesOrdenadas;
	}

}
