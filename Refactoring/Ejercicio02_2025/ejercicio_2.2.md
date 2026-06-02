## 2.2 Juego
### Código original:
```java
public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.puntuacion = j.puntuacion + 100;
    }
    public void decrementar(Jugador j) {
        j.puntuacion = j.puntuacion - 50;
    }
}

public class Jugador {
    public String nombre;
    public String apellido;
    public int puntuacion = 0;
}
```
### Bad Smell: *Feature Envy*.
La clase `Juego` está utilizando y modificando directamente atributos de la clase `Jugador`.
### Refactor a aplicar: *Move Method*.
```java
public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.incrementarPuntuacion();
    }
    public void decrementar(Jugador j) {
        j.decrementarPuntuacion();
    }
}

public class Jugador {
    public String nombre;
    public String apellido;
    public int puntuacion = 0;
    
    public void incrementarPuntuacion(){ this.puntuacion += 100; }
    public void decrementarPuntuacion(){ this.puntuacion-=50; }
}
```
### Bad Smell: *Nombres no explicativos*.
Los métodos `incrementar(Jugador j)` y `decrementar(Jugador j)` de la clase `Juego` no expresan su finalidad.
### Refactor a aplicar: *Rename Method*.
```java
public class Juego {
    // ......
    public void incrementarPuntuacionDeJugador(Jugador j) {
        j.incrementarPuntuacion();
    }
    public void decrementarPuntuacionDeJugador(Jugador j) {
        j.decrementarPuntuacion();
    }
}

public class Jugador {
    public String nombre;
    public String apellido;
    public int puntuacion = 0;
    
    public void incrementarPuntuacion(){ this.puntuacion += 100; }
    public void decrementarPuntuacion(){ this.puntuacion-=50; }
}
```
### Bad Smell: *Rompe encapsulamiento*.
Las variables de instancia de `Jugador` son `public`.
### Refactor a aplicar: *Encapsulate Field*.

```java
public class Juego {
    // ......
    public void incrementarPuntuacionDeJugador(Jugador j) {
        j.incrementarPuntuacion();
    }

    public void decrementarPuntuacionDeJugador(Jugador j) {
        j.decrementarPuntuacion();
    }
}

public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public void incrementarPuntuacion() {
        this.puntuacion += 100;
    }

    public void decrementarPuntuacion() {
        this.puntuacion -= 50;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
```