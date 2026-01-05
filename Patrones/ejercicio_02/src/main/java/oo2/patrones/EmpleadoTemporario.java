package oo2.patrones;

public class EmpleadoTemporario extends Empleado {
    private double horasTrabajadas;
    private boolean casado;
    private int cantidadHijos;

    public EmpleadoTemporario(boolean casado, double horasTrabajadas, int cantidadHijos){
        this.casado = casado;
        this.horasTrabajadas = horasTrabajadas;
        this.cantidadHijos = cantidadHijos;
    }

    @Override
    public double calcularSueldoBasico() {
        return 20000 + this.horasTrabajadas * 300;
    }

    @Override
    public double calcularAdicional() {
        double valorHijo = 2000;
        if (!this.casado) return this.cantidadHijos * valorHijo;

        return this.cantidadHijos * valorHijo + 5000;
    }
}