# Investigación: Composite Pattern

## 1. ¿Qué problema de diseño busca resolver el patrón Composite?
El patrón Composite nos ayuda muchísimo cuando tenemos objetos que forman una estructura de árbol y queremos tratarlos a todos por igual. Imagina que tienes elementos individuales y grupos de esos elementos; sin este patrón, nuestro código tendría que estar adivinando si está trabajando con una sola cosa o con un grupo entero, lo que hace que todo sea súper revoltoso. Con el Composite, podemos darle las mismas instrucciones tanto a un objeto suelto como a una colección completa, y cada uno sabrá qué hacer.

## 2. ¿Qué tipos de estructuras de datos o sistemas se benefician más de este patrón?
Definitivamente, las estructuras jerárquicas o en forma de árbol son las que más le sacan provecho a esto. Algunos sistemas increíbles donde queda perfecto son:
- Los sistemas de archivos, donde tienes carpetas que guardan archivos y otras carpetas.
- Las interfaces de usuario, donde una ventana puede tener botones y paneles, y esos paneles tienen más botones.
- Los programas de dibujo o diseño, donde puedes agrupar varias figuras simples para formar un solo objeto complejo.

## 3. Explicación de los roles principales

- Component: Es la base de todo. Básicamente es una interfaz o clase que define los métodos que todos van a compartir. Es lo que nos permite hablarle de la misma forma a los elementos individuales y a los grupos.
- Leaf: Son las hojas del árbol, es decir, los objetos individuales que ya no tienen nada adentro. Aquí es donde realmente pasa la acción, porque al no tener hijos, ellos mismos hacen el trabajo pesado.
- Composite: Son los componentes que sí pueden tener otros elementos adentro, ya sean hojas u otros compuestos. Su trabajo es súper interesante porque cuando les pides que hagan algo, ellos se encargan de pasarle la misma instrucción a todos los elementos que tienen guardados.

## 4. Ejemplos donde el patrón Composite es aplicable
1. En un sistema de archivos: Imagina pedirle el tamaño a una carpeta. La carpeta como tal no tiene un peso fijo, así que le pregunta el tamaño a cada archivo y subcarpeta que tiene adentro y te devuelve la suma total.
2. En una tienda en línea: Si tienes una caja llena de diferentes productos y cajas más pequeñas, y quieres saber el precio total, la caja principal va sumando el precio de las cosas sueltas y le pregunta a las cajas pequeñas cuánto valen sus contenidos.

## 5. Ventajas y posibles desventajas

Ventajas:
- Nos hace la vida mucho más fácil a la hora de programar porque no tenemos que escribir un montón de condiciones para saber con qué tipo de objeto estamos tratando.
- Es súper flexible. Podemos agregar nuevos tipos de elementos sin tener que romper el código que ya tenemos funcionando.
- Nos permite construir estructuras geniales y complejas de manera sencilla.

Desventajas:
- A veces puede ser un poco difícil limitar qué cosas pueden ir dentro de un compuesto. Como todo está diseñado para ser general, si queremos que una carpeta solo acepte cierto tipo de archivos, vamos a tener que hacer validaciones extra.
- Puede que en proyectos muy sencillos resulte ser una solución un poco exagerada.
