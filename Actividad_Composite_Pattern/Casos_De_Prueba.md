# Casos de Prueba del Composite Pattern

A continuación presento los dos casos de prueba que diseñé para asegurar que nuestra implementación del patrón Composite funciona a la perfección. Estos casos se pueden ver en acción dentro del archivo Main.java.

## Caso de Prueba 1: Funcionamiento de los objetos Leaf
Objetivo: Comprobar que una canción individual, que actúa como nuestra hoja, pueda reproducirse y cambiar su velocidad sin depender de nada más.

Pasos que seguimos:
1. Creamos dos canciones distintas.
2. Ponemos a reproducir la primera canción para ver que funcione con su velocidad normal.
3. A la segunda canción le cambiamos la velocidad a 1.5x.
4. Reproducimos la segunda canción para verificar el cambio.

Resultados que obtenemos:
La primera canción suena tal cual la creamos. La segunda nos confirma que guardó su nueva velocidad y se reproduce un poco más rápido. Todo esto pasa sin que una afecte a la otra, demostrando que son totalmente independientes.

## Caso de Prueba 2: Comportamiento de los objetos Composite
Objetivo: Ver la magia del patrón en acción, validando que una lista de reproducción pueda contener canciones y otras listas, y que al darle una orden a la lista principal, esta se la pase a todos sus elementos.

Pasos que seguimos:
1. Creamos una lista de reproducción de rock y le metemos las dos canciones del primer caso.
2. Creamos una tercera canción totalmente nueva.
3. Creamos una lista maestra gigante y le metemos la lista de rock y la canción nueva.
4. Mandamos a reproducir la lista maestra.
5. Luego, le decimos a la lista maestra que queremos escuchar todo a 1.25x de velocidad.
6. Volvemos a reproducir la lista maestra para checar.

Resultados que obtenemos:
Al reproducir la lista maestra, vemos cómo va imprimiendo todo en orden: entra a la lista de rock, toca sus canciones, y luego toca la canción suelta. Cuando le cambiamos la velocidad a la lista maestra, nos damos cuenta de que automáticamente todas las canciones de adentro actualizan su velocidad. Es súper práctico probar cómo una sola instrucción desde arriba afecta a toda la estructura.
