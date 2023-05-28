##  TIENDA DE MÚSICA - PROYECTO FINAL


------------------

### To-do

- Pulir interfaces gráficas 
	(Busqueda, Principal.)
- ~~Hacer que se puedan agregar canciones~~
- ~~Conectar las ventanas~~
- Método de deshacer
- Método de rehacer
- Consulta de género con más canciones en la tienda y el artista más popular (En este contexto, ¿cómo se ve quién es el más popular? ¿el que tenga más canciones?)
- Validar Campos en los Crud
	(Que no se puedan crear artistas o canciones en blanco).

-----------------

Las estructuras de datos son utilizadas para guardar información de manera organizada y para consultar o recuperar dicha información eficientemente, por lo tanto, el proyecto final del espacio académico estructura de datos consiste en desarrollar un proyecto donde se practique el uso de las estructuras vistas en clase durante todo el semestre. En consecuencia con lo anterior, la tienda de música Storify necesita una aplicación moderna donde sus usuarios puedan iniciar sesión, buscar canciones, guardarlas como favoritas y reproducirlas dentro de la misma aplicación. 

#### La información requerida es:
- De una Canción se necesita un código único (generado aleatoriamente), nombre de la canción, nombre del álbum, carátula, año, duración, género (Rock, Pop, Punk, Reggaeton, Electrónica) y url de la canción en youtube.
- De un Autor/Artista se conoce un código, nombre (único), nacionalidad, un atributo que identifique si el Artista es un grupo o no, y una lista doblemente enlazada de Canciones.
- De un Usuario se conoce su username (único), contraseña, email, además el usuario tiene una lista propia de Canciones, dicha lista es una Lista circular.
- La tienda guarda su catálogo de música agrupando las Canciones en sus respectivos autores en forma de lista, los Artistas se almacenan en forma de Árbol Binario, el orden del árbol está dado por el nombre de los Artistas. Además, tenga en cuenta que los usuarios se guardan en un HashMap, donde la llave de cada usuario es su username. 

La aplicación debe tener interfaz gráfica de usuario y además debe poder guardar toda la información en el disco duro, por lo tanto, debe usar serialización de objetos. 

#### Las funcionalidades de la tienda son:
##### Del lado del usuario:
1.	Iniciar sesión: Los usuarios deben poder iniciar sesión usando su username y contraseña, una vez iniciada la sesión debe cargar todas las canciones que el usuario tenga guardadas.
2.	Buscar: El usuario debe poder buscar música en la tienda, hay tres formas de buscar:
 -	Búsqueda Artistas: Debido a que los artistas se guardan en un árbol binario, su búsqueda es muy eficiente, por lo tanto, dado el nombre de un Artista debe retornar su lista de canciones.
 -	Búsqueda O: Dados los valores de dos o más atributos de una Canción, retorne una lista con las canciones con al menos un atributo que coincida.
 -	Búsqueda Y: Dados los valores de dos o más atributos de una Canción, retorne una lista con las canciones con todos los atributos que coincidan.
 -	Para la búsqueda O y la búsqueda Y: Usar Hilos de ejecución de tal manera que un hilo se encargue de buscar en el lado derecho del árbol, y otro hilo busque en el lado izquierdo del árbol.
3.	Guardar/Eliminar una canción en la lista del usuario: El usuario puede guardar cualquier canción en su lista de canciones, así como eliminar de su lista las canciones que desee.
4.	Deshacer: Deshacer una inserción o eliminación
5.	Rehacer: Rehacer la función que se deshizo anteriormente.

6.	Ordenamiento: El usuario debe poner ordenar su lista de canciones. Se debe poder ordenar usando cualquier atributo de la canción.


##### Del lado del administrador:
1.	Iniciar sesión: El administrador debe poder iniciar sesión (usar la misma interfaz de inicio de sesión del usuario), la aplicación solo tiene un administrador, cuyo username es admin y contraseña es $aDmiN.

2.	Crear artistas - Agregar canción: El administrador debe poder crear Artistas y agregarle canciones. 
3.	Consultar el género con más canciones en la Tienda y el Artista más popular.
