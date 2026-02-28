# Guion para el Video de la Actividad (VERSIÓN INTERACTIVA)

Empiezas el video grabando la pantalla, mostrando nuestro archivo Investigacion_Composite_Pattern.md.

Dices: Hola, en este video voy a explicar la implementación que realicé del patrón de diseño Composite en Java. Primero, aquí tengo mi documento de investigación donde respondí las preguntas teóricas sobre qué es este patrón, cómo funciona con estructuras de árbol y cuáles son sus ventajas y desventajas.

Bajas un poco el documento para que la maestra vea que están todas las preguntas contestadas.

Dices: Como pueden ver, el patrón nos ayuda mucho a tratar de la misma forma a objetos individuales y a colecciones de objetos, lo cual simplifica bastante el código e implementaciones.

Ahora te cambias de archivo y pasas directo al código abriendo IComponent.java.

Dices: Para el desarrollo del sistema, me basé en el diagrama de clases y creé primero la interfaz IComponent. Esta interfaz es clave porque tiene los métodos que van a compartir tanto las canciones sueltas como las listas de reproducción, como el reproducir y cambiar la velocidad.

Abres el archivo Song.java y el archivo Playlist.java, explicando que son la hoja (Leaf) y el compuesto (Composite) tal como pedía el diagrama, sin hacer mucho énfasis en el código interno.

Dices: Luego hice la clase Song, que representa las hojas de nuestro árbol, y la clase Playlist, que es nuestro Composite y contiene a otras listas y canciones.

Abres el archivo Main.java. Bajas a donde está el código.

Dices: Aquí en el Main puse en práctica estos casos. Para hacer la prueba más dinámica, le agregué un menú interactivo en la consola para elegir qué caso queremos correr.

Ahora abres tu terminal y ejecutas el programa (con el comando de compilación que te pasé e ingresando tu número).

Dices: Ahora voy a correr el programa para mostrarles que funciona perfectamente. 

(La consola te pedirá elegir un número).

Dices: Como podemos notar, el programa nos da elegir. Primero escribiré el número 1 para probar la primera versión con canciones sueltas.

(Escribes el "1" y presionas Enter. Se imprimen las dos canciones).

Dices: En este caso, la prueba funciona excelente, las canciones se ejecutan independientemente mostrando sus respectivas velocidades.

Dices: Ahora probaré la estructura completa del patrón eligiendo la opción 2.

(Escribes el "2" y presionas Enter).

Dices: Al darle correr a la opción 2, le damos "reproducir" a toda la lista maestra. Podemos ver cómo entra a las listas anidadas de forma correcta imprimiendo las canciones. Además, al acelerar esa lista maestra desde arriba, todas las canciones adentro cambiaron su velocidad a 1.25x automáticamente. Todo gracias al patrón Composite.

Eliges "3" para salir.

Dices: Con esto concluyo mi explicación y la demostración de los casos de prueba del patrón Composite. Muchas gracias por su atención. 

Terminas la grabación.
