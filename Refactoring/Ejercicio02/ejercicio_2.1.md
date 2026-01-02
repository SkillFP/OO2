## 2.1 Empleados
### Código original:
```java
public class EmpleadoTemporario {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico
                + (this.horasTrabajadas * 500)
                + (this.cantidadHijos * 1000)
                - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico
                + (this.cantidadHijos * 2000)
                - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```
### Bad Smell: *Breaks encapsulation*.
Existen variables de instancia que son `public`.
### Refactoring a aplicar: *Encapsulate Field*.
```java
public class EmpleadoTemporario {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    private double horasTrabajadas = 0;
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico
                + (this.horasTrabajadas * 500)
                + (this.cantidadHijos * 1000)
                - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico
                + (this.cantidadHijos * 2000)
                - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```
### Bad Smell: *Duplicated Code*.
Las clases `EmpleadoTemporal`, `EmpleadoPlanta` y `EmpleadoPasante` comparten las variables de instancia `nombre`, `apellido` y `sueldoBasico` y métodos con código repetido.
### Refactoring a aplicar: *Extract Class*.
```java
public abstract class Empleado {}
public class EmpleadoTemporario extends Empleado {
    private String nombre;
    private String apellido;
    private int sueldoBasico = 0;
    private double horasTrabajadas = 0;
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico
                + (this.horasTrabajadas * 500)
                + (this.cantidadHijos * 1000)
                - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta extends Empleado {
    private String nombre;
    private String apellido;
    private int sueldoBasico = 0;
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico
                + (this.cantidadHijos * 2000)
                - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante extends Empleado {
    private String nombre;
    private String apellido;
    private int sueldoBasico = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```
### Bad Smell: *Duplicated Code*.
Las clases `EmpleadoTemporal`, `EmpleadoPlanta` y `EmpleadoPasante` siguen compartiendo las variables de instancia `nombre`, `apellido` y `sueldoBasico` y métodos con código repetido.
### Refactoring a aplicar: *Pull up Fields*.
```java
public abstract class Empleado {
    private String nombre;
    private String apellido;
    private int sueldoBasico = 0;
}

public class EmpleadoTemporario extends Empleado {
    private double horasTrabajadas = 0;
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico
                + (this.horasTrabajadas * 500)
                + (this.cantidadHijos * 1000)
                - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta extends Empleado {
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico
                + (this.cantidadHijos * 2000)
                - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante extends Empleado {
    // ......
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```
### Bad Smell: *Duplicate Code*.
Las tres clases hacen cálculos que deberían ser su propio método.
### Refactoring a aplicar: *Extract Method*.
```java
public abstract class Empleado {
    private String nombre;
    private String apellido;
    private int sueldoBasico = 0;
}

public class EmpleadoTemporario extends Empleado {
    private double horasTrabajadas = 0;
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico
                + calcularSueldoPorHora()
                + calcularExtraPorHijos()
                - calcularDescuento();
    }
    
    private double calcularDescuento(){
        return this.sueldoBasico * 0.13;
    }
    
    private double calcularSueldoPorHora(){
        return this.horasTrabajadas * 500;
    }
    
    private double calcularExtraPorHijos(){
        return this.cantidadHijos * 1000;
    }
}

public class EmpleadoPlanta extends Empleado {
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico
                + calcularExtraPorHijos()
                - calcularDescuento();
    }

    private double calcularDescuento(){
        return this.sueldoBasico * 0.13;
    }
    
    private double calcularExtraPorHijos(){
        return this.cantidadHijos * 2000;
    }
    
}

public class EmpleadoPasante extends Empleado {
    // ......
    public double sueldo() {
        return this.sueldoBasico - calcularDescuento();
    }
    
    private double calcularDescuento(){
        return this.sueldoBasico * 0.13;
    }
}
```
### Bad Smell: *Duplicate Code*.
Los métodos `calcularDescuento()` y `sueldo()` están presentes en las tres clases.
### Refactoring a aplicar: *Pull Up Method*.
```java
public abstract class Empleado {
    private String nombre;
    private String apellido;
    private int sueldoBasico = 0;
    
    public double sueldo(){
        return this.sueldoBasico - calcularDescuento();
    }

    private double calcularDescuento(){
        return this.sueldoBasico * 0.13;
    }
}

public class EmpleadoTemporario extends Empleado {
    private double horasTrabajadas = 0;
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return super.sueldo() + calcularExtraPorHora() + calcularExtraPorHijos();
    }
    
    private double calcularExtraPorHora(){
        return this.horasTrabajadas * 500;
    }
    
    private double calcularExtraPorHijos(){
        return this.cantidadHijos * 1000;
    }
}

public class EmpleadoPlanta extends Empleado {
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return super.sueldo() + calcularExtraPorHijos();
    }
    
    private double calcularExtraPorHijos(){
        return this.cantidadHijos * 2000;
    }
    
}

public class EmpleadoPasante extends Empleado {
    // ......
    public double sueldo() {
        return super.sueldo();
    }
}
```
### Bad Smell: *Lazy Class*.
La clase `EmpleadoPasante` no hace nada más que llamar al cálculo de la clase padre. Por una cuestión de preferencia y mayor escalabilidad, opto por ignorar este *Bad Smell* previendo que hacer un *Template Method* dificulte la legibilidad y escalabilidad del esquema.
### Bad Smell: *Duplicate Code*.
Las clases `EmpleadoPlanta` y `EmpleadoTemporario` tienen el mismo método `calcularExtraPorHijos()`.
Elijo pasar por alto este *Bad Smell* porque:
- Crear una clase intermedia sería acoplar la solución.
- Hacer *Pull Up Method* causaría *Refused Bequest* en `EmpleadoPasante`.
- Ambas soluciones causan *side effects* y comprometen la escalabilidad.
### Bad Smell: *Método con nombre no explicativo*.
El método `sueldo()` en todas las clases no expresa su finalidad completamente.
### Refactor a aplicar: *Rename Method*.
```java
public abstract class Empleado {
    private String nombre;
    private String apellido;
    private int sueldoBasico = 0;
    
    public double calcularSueldoTotal(){
        return this.sueldoBasico - calcularDescuento();
    }

    private double calcularDescuento(){
        return this.sueldoBasico * 0.13;
    }
}

public class EmpleadoTemporario extends Empleado {
    private double horasTrabajadas = 0;
    private int cantidadHijos = 0;
    // ......
    public double calcularSueldoTotal() {
        return super.calcularSueldoTotal() + calcularExtraPorHora() + calcularExtraPorHijos();
    }
    
    private double calcularExtraPorHora(){
        return this.horasTrabajadas * 500;
    }
    
    private double calcularExtraPorHijos(){
        return this.cantidadHijos * 1000;
    }
}

public class EmpleadoPlanta extends Empleado {
    private int cantidadHijos = 0;
    // ......
    public double calcularSueldoTotal() {
        return super.calcularSueldoTotal() + calcularExtraPorHijos();
    }
    
    private double calcularExtraPorHijos(){
        return this.cantidadHijos * 2000;
    }
    
}

public class EmpleadoPasante extends Empleado {
    // ......
    public double calcularSueldoTotal() {
        return super.calcularSueldoTotal();
    }
}
```
___