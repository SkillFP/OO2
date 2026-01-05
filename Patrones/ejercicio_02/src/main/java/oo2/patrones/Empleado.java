package oo2.patrones;

public abstract class Empleado {

    public double sueldo(){
        return this.calcularSueldoBasico() + calcularAdicional() - calcularDescuento();
    }

    public abstract double calcularSueldoBasico();

    public abstract double calcularAdicional();

    public double calcularDescuento(){
        return this.calcularSueldoBasico() * 0.13 + this.calcularAdicional() * 0.05;
    }
}