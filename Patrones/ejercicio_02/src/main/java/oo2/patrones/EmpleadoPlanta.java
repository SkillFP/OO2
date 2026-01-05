package oo2.patrones;

public class EmpleadoPlanta extends Empleado {
    private boolean casado;
    private int aniosAntiguedad;
    private int cantidadHijos;

    public EmpleadoPlanta(boolean casado, int aniosAntiguedad, int cantidadHijos){
        this.casado = casado;
        this.aniosAntiguedad = aniosAntiguedad;
        this.cantidadHijos = cantidadHijos;
    }
    @Override
    public double calcularSueldoBasico() {
        return 50000;
    }

    @Override
    public double calcularAdicional() {
        double valorHijo = 2000;
        double valorAnioAntiguedad = 2000;
        if (!this.casado) return this.aniosAntiguedad * valorAnioAntiguedad + this.cantidadHijos * valorHijo;
        return this.aniosAntiguedad * valorAnioAntiguedad + this.cantidadHijos * valorHijo + 5000;
    }
}
