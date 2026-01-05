package oo2.patrones;

public class EmpleadoPasante extends Empleado {
    private int examenesRendidos;

    public EmpleadoPasante(int examenesRendidos){
        this.examenesRendidos = examenesRendidos;
    }

    @Override
    public double calcularSueldoBasico() {
        return 20000;
    }

    @Override
    public double calcularAdicional() {
        return this.examenesRendidos * 2000;
    }

}