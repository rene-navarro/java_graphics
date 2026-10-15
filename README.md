# Gráficos en Java — Ejemplos con Swing y Java 2D

Repositorio didáctico de programas independientes que ilustran dibujo de componentes, primitivas gráficas, coordenadas, transformaciones geométricas, eventos de teclado y gestión de ventanas en Java mediante **Swing**, **AWT** y **Java 2D**.

## Contenido y objetivos

Los ejemplos permiten practicar:

- Creación de ventanas con `JFrame`, componentes con `JPanel` y `JComponent` y dibujo con `Graphics`/`Graphics2D`.
- Representación de texto, líneas, rectángulos, óvalos y ejes cartesianos.
- Modificación del tamaño de figuras y rotación de segmentos mediante trigonometría.
- Captura de eventos del teclado mediante `KeyAdapter`.
- Ventanas a pantalla completa y pantallas de bienvenida con progreso simulado.


## Requisitos

- JDK instalado y disponible en `PATH` (`java` y `javac`). El proyecto no declara una versión mínima de Java ni un *toolchain* específico.
- Entorno de escritorio con soporte gráfico para los ejemplos Swing.
- Gradle **9.1.0**, descargado por el **Gradle Wrapper** incluido en el repositorio; no es necesario instalar Gradle globalmente.
- Conexión a Internet la primera vez que el wrapper deba descargar Gradle o dependencias.

`build.gradle` aplica el plugin `java`, utiliza Maven Central y declara JUnit Jupiter mediante BOM `5.10.0` para pruebas. No configura el plugin `application` ni una clase principal predeterminada. El ZIP examinado no contiene clases de prueba en `src/test/java`.

## Compilación

Clonar el repositorio y situarse en su directorio raíz:

```bash
git clone https://github.com/rene-navarro/java_graphics.git
cd java_graphics
```

En macOS o Linux:

```bash
./gradlew classes
```

En Windows:

```powershell
.\gradlew.bat classes
```

Para compilar y ejecutar las tareas de verificación configuradas:

```bash
./gradlew build
```

Las clases compiladas se almacenan normalmente en `build/classes/java/main`.

## Ejecución de los ejemplos

Después de compilar, cada clase con `main` se puede iniciar directamente. En macOS o Linux:

```bash
java -cp build/classes/java/main mx.unison.basicos.Canvas
```

En Windows (PowerShell o CMD), se utiliza la misma sintaxis para esta ruta relativa:

```powershell
java -cp build/classes/java/main mx.unison.basicos.Canvas
```

Sustituir el nombre de clase por cualquiera de los puntos de entrada de la siguiente tabla:

| Paquete | Clase ejecutable | Demostración |
| --- | --- | --- |
| `mx.unison` | `Main` | Salida de texto `Hello world!` en consola. |
| `mx.unison.basicos` | `Canvas` | Dibujo del texto «Hola mundo» en azul. |
| `mx.unison.basicos` | `Circulo` | Óvalo relleno y borde; comparación de métodos de pintura. |
| `mx.unison.basicos` | `Cube` | Proyección de un cubo mediante segmentos de colores. |
| `mx.unison.basicos` | `PlanoCartesiano` | Ejes, marcas y gráfica discreta de una función seno. |
| `mx.unison.escalar` | `Dibujo` | Óvalo cuyo tamaño depende de un factor de escala. |
| `mx.unison.escalar` | `MainApp` | Ventana interactiva que escala el dibujo con el teclado. |
| `mx.unison.screens` | `FullScreenMode` | Ventana sin decoración a pantalla completa o maximizada. |
| `mx.unison.screens` | `SplashScreen` | Ventana de bienvenida con barra de progreso simulada. |
| `mx.unison.transformaciones` | `Sketch` | Texto, figuras, ejes discontinuos y transformación de `Graphics2D`. |
| `mx.unison.transformaciones` | `Triangle` | Triángulo compuesto por segmentos con rotación mediante teclado. |

`mx.unison.transformaciones.Geometry` es una clase auxiliar **sin método `main`**; se utiliza desde otros ejemplos, particularmente `Triangle`.

## Documentación por programa

### 1. `mx.unison.Main`

**Archivo:** `src/main/java/mx/unison/Main.java`.

Clase de entrada mínima cuyo método `main(String[] args)` imprime `Hello world!` en la salida estándar. No crea ventanas ni dibuja gráficos. Sirve como ejemplo básico de punto de entrada Java.

### 2. `basicos.Canvas`

**Archivo:** `src/main/java/mx/unison/basicos/Canvas.java`.

Extiende `JComponent` y sobreescribe `paintComponent(Graphics)` para dibujar el texto **«Hola mundo»** en azul, con fuente Arial negrita de 20 puntos, en las coordenadas `(10, 40)`. Su tamaño preferido es `640 × 480` píxeles, configurable mediante constructor.

**Métodos principales:** `Canvas()`, `Canvas(int w, int h)`, `getPreferredSize()`, `paintComponent(Graphics)` y `main(String[])`.

**Conceptos:** componentes personalizados, `Dimension`, color, tipografía y ciclo de repintado Swing.

### 3. `basicos.Circulo`

**Archivo:** `src/main/java/mx/unison/basicos/Circulo.java`.

Extiende `JPanel`. En `paint(Graphics)` dibuja un óvalo circular rojo relleno con contorno azul de `50 × 50` píxeles, ubicado en `(10, 10)`. También implementa `paintComponent(Graphics)` para dibujar un rectángulo negro en esa región. El tamaño preferido inicial es `640 × 480`.

**Métodos principales:** constructores, `getPreferredSize()`, `paint(Graphics)`, `paintComponent(Graphics)` y `main(String[])`.

**Conceptos:** diferencias entre `paint` y `paintComponent`, `fillOval`, `drawOval` y `drawRect`.

**Advertencia:** la implementación de `paint(Graphics)` no invoca `super.paint(g)`, por lo que el comportamiento habitual de pintura de Swing, incluido `paintComponent`, puede verse alterado. Se documentan ambos métodos tal como aparecen en el código; no debe asumirse que sus dibujos se combinan correctamente.

### 4. `basicos.Cube`

**Archivo:** `src/main/java/mx/unison/basicos/Cube.java`.

Extiende `JPanel` y dibuja mediante `drawLine` dos cuadrados desplazados: uno rojo desde `(0,0)` hasta `(50,50)` y otro azul desde `(25,25)` hasta `(75,75)`. Cuatro segmentos negros conectan sus vértices, produciendo una representación alámbrica de un cubo en perspectiva esquemática.

**Métodos principales:** `paint(Graphics)` y `main(String[])`.

**Conceptos:** primitivas lineales, composición de figuras y representación bidimensional de un objeto tridimensional.

**Advertencia:** `paint` no llama a `super.paint(g)`.

### 5. `basicos.PlanoCartesiano`

**Archivo:** `src/main/java/mx/unison/basicos/PlanoCartesiano.java`.

Extiende `JComponent`. Dibuja ejes horizontal y vertical centrados según el tamaño actual del componente, marcas grises cada 10 píxeles y puntos rojos que aproximan la curva:

```text
y = 50 * sin(0.1 * (x - x0)) + y0
```

Aquí `(x0, y0)` es el origen guardado al construir el componente; los puntos se calculan para valores de `x` separados por 2 píxeles. Las coordenadas de pantalla crecen hacia abajo en el eje vertical, de modo que la orientación visual no coincide con la convención matemática habitual.

**Métodos principales:** constructores, `getPreferredSize()`, `getOrigen()`, `paintComponent(Graphics)` y `main(String[])`.

**Conceptos:** sistemas de coordenadas, trazado de funciones, `Math.sin` y dibujo por muestreo.

**Advertencia:** al redimensionar la ventana, los ejes se recalculan con las dimensiones actuales, pero el origen utilizado por la curva conserva las coordenadas establecidas en el constructor.

### 6. `escalar.Dibujo`

**Archivo:** `src/main/java/mx/unison/escalar/Dibujo.java`.

Extiende `JPanel` y representa un óvalo rojo con borde azul en `(10,10)`. El diámetro inicial es `50` píxeles y se calcula como `int(radio * scaleFactor)`, donde `scaleFactor` inicia en `1.0`.

**Métodos principales:** constructores, `getPreferredSize()`, `paint(Graphics)`, `scaleUp()`, `scaleDown()` y `main(String[])`.

- `scaleUp()` incrementa el factor en `0.10`.
- `scaleDown()` disminuye el factor en `0.10`.

**Conceptos:** escalamiento de figuras y estado mutable del componente.

**Advertencias:** los métodos de escala no invocan `repaint()` por sí mismos; el programa `MainApp` se encarga de repintar. No hay límite inferior para el factor y `paint(Graphics)` no llama a `super.paint(g)`.

### 7. `escalar.MainApp`

**Archivo:** `src/main/java/mx/unison/escalar/MainApp.java`.

Extiende `JFrame`, agrega una instancia de `Dibujo` y registra un `KeyAdapter` para cambiar su factor de escala. Después de cada cambio llama a `repaint()`.

**Controles:**

| Tecla | Acción |
| --- | --- |
| `I` o `i` | Incrementa el factor de escala en `0.10`. |
| `O` o `o` | Disminuye el factor de escala en `0.10`. |

**Métodos principales:** constructor, `main(String[])`, `scaleUp()` y `scaleDown()` (estos dos últimos son privados).

**Conceptos:** eventos de teclado, composición de ventana y componente, y actualización visual. El teclado debe tener el foco en la ventana correspondiente.

### 8. `screens.FullScreenMode`

**Archivo:** `src/main/java/mx/unison/screens/FullScreenMode.java`.

Crea un `JFrame` sin bordes ni barra de título (`setUndecorated(true)`), consulta el dispositivo gráfico principal con `GraphicsEnvironment` y `GraphicsDevice`, y solicita modo de pantalla completa mediante `setFullScreenWindow(frame)` cuando está disponible. En caso contrario, maximiza la ventana.

**Control:** `Ctrl + Q` finaliza el proceso con `System.exit(0)` cuando la ventana recibe el evento de teclado.

**Conceptos:** dispositivos de visualización, ventanas sin decoración, modo de pantalla completa y combinaciones de teclas.

**Advertencia:** la ventana no incorpora contenido visible y el funcionamiento del modo exclusivo depende del sistema operativo y el dispositivo gráfico. Ejecútese en una sesión gráfica interactiva.

### 9. `screens.SplashScreen`

**Archivo:** `src/main/java/mx/unison/screens/SplashScreen.java`.

Extiende `JWindow` y crea una pantalla de bienvenida con título **«Desarrollo de Sistemas III»**, imagen central y `JProgressBar` de 0 a 100. Un hilo de trabajo simula una carga, actualizando el progreso en pasos de 20 unidades cada 800 ms. Al terminar, cierra la pantalla de bienvenida y abre un `JFrame` vacío de `800 × 600` píxeles titulado **«Aplicación Principal»**.

**Métodos principales:** constructor, `updateProgress(int progress, String message)` y `main(String[])`.

**Conceptos:** `JWindow`, `JProgressBar`, hilos y actualización de componentes mediante `SwingUtilities.invokeLater`.

**Recurso requerido:** `img/LOGO-OJO-BUHO-AMARILLO.png`. La ruta es relativa al directorio de trabajo; para mostrar la imagen, ejecutar el programa desde la raíz del repositorio. Si el recurso no se encuentra, el `ImageIcon` no mostrará la imagen esperada.

**Advertencia:** la carga es simulada y no representa el avance real de inicialización de componentes.

### 10. `transformaciones.Geometry`

**Archivo:** `src/main/java/mx/unison/transformaciones/Geometry.java`.

Clase auxiliar de operaciones geométricas estáticas; no tiene interfaz ni punto de entrada independiente.

| Método | Función |
| --- | --- |
| `toPoint(Point2D)` | Convierte a `Point`, truncando las coordenadas a enteros. |
| `m(Point, Point)` | Calcula la pendiente entre dos puntos. |
| `distance(Point, Point)` | Calcula la distancia euclidiana. |
| `distance(double, double, double, double)` | Calcula la distancia euclidiana a partir de coordenadas. |
| `rotate(Point, double)` | Rota un punto alrededor del origen. |
| `rotate(Point, Point, double)` | Rota un punto alrededor de otro punto. |
| `rotation(Point, Point, double)` | Otra implementación de rotación alrededor de un centro. |

Los ángulos se reciben en **grados** y se convierten a radianes internamente. Los métodos de rotación **modifican el objeto `Point` recibido**. Al usar coordenadas enteras se pierde precisión.

**Advertencia:** `m` divide por la diferencia horizontal sin comprobar si es cero; además, la sobrecarga `rotation(Point, Point, double)` altera temporalmente el punto y utiliza una expresión distinta de `rotate(Point, Point, double)`, por lo que conviene revisar su resultado antes de emplearla como operación geométrica general.

### 11. `transformaciones.Sketch`

**Archivo:** `src/main/java/mx/unison/transformaciones/Sketch.java`.

Extiende `JPanel` y dibuja un rectángulo rojo relleno con borde azul, el texto **«Hello World»**, ejes centrales discontinuos y una segunda representación del texto después de aplicar traslaciones y una rotación de `45°` al contexto `Graphics2D`. Utiliza `BasicStroke`, `Line2D` y medidas del texto obtenidas con `FontMetrics`.

**Métodos principales:** `paint(Graphics)` y `main(String[])`.

**Conceptos:** transformaciones afines, rotación, traslación, trazos discontinuos y coordenadas del contexto gráfico.

**Advertencias:** `paint` no invoca `super.paint(g)` y modifica el contexto gráfico sin restaurar su transformación original. El resultado de la rotación depende del orden de las operaciones `translate` y `rotate`.

### 12. `transformaciones.Triangle`

**Archivo:** `src/main/java/mx/unison/transformaciones/Triangle.java`.

Extiende `JComponent` y mantiene tres segmentos `Line2D.Double` en una lista de `Shape`, formando un triángulo cuyos vértices iniciales son `(270,300)`, `(370,300)` y `(320,200)`. Dibuja los lados en rojo, verde y azul, además de ejes centrales discontinuos. Mediante `Geometry.rotate`, rota los extremos de cada segmento alrededor del centro calculado a partir del tamaño preferido del componente y solicita un nuevo pintado.

**Controles:**

| Tecla | Acción |
| --- | --- |
| `R` o `r` | Rota el triángulo `+10°` según la convención usada por el código. |
| `L` o `l` | Rota el triángulo `-10°`. |

**Métodos principales:** constructores, `getPreferredSize()`, `setPreferredSize(Dimension)`, `paintComponent(Graphics)`, `rotateClockwise()` y `rotateCountClockwise()`.

**Conceptos:** `Shape`, `Line2D`, composición de figuras, transformaciones por vértice y repintado tras eventos de teclado.

**Advertencias:** los vértices iniciales usan coordenadas fijas; el constructor sin dimensiones devuelve un tamaño preferido de `250 × 100` si no se establece otro. Las rotaciones convierten extremos a `Point` enteros, por lo que la repetición puede introducir errores acumulados de redondeo. En coordenadas de pantalla, el sentido visual de los giros depende de que el eje Y crece hacia abajo.

## Organización del código

```text
java_graphics/
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
├── gradle/
│   └── wrapper/
├── img/
│   └── LOGO-OJO-BUHO-AMARILLO.png
└── src/
    ├── main/java/mx/unison/
    │   ├── Main.java
    │   ├── basicos/
    │   │   ├── Canvas.java
    │   │   ├── Circulo.java
    │   │   ├── Cube.java
    │   │   └── PlanoCartesiano.java
    │   ├── escalar/
    │   │   ├── Dibujo.java
    │   │   └── MainApp.java
    │   ├── screens/
    │   │   ├── FullScreenMode.java
    │   │   └── SplashScreen.java
    │   └── transformaciones/
    │       ├── Geometry.java
    │       ├── Sketch.java
    │       └── Triangle.java
    └── test/
```
