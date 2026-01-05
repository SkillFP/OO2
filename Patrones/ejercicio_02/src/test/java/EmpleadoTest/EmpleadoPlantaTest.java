package EmpleadoTest;

import oo2.patrones.EmpleadoPlanta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoPlantaTest {
    private EmpleadoPlanta empleadoCasado;
    private EmpleadoPlanta empleadoConUnoAntiguedad;
    private EmpleadoPlanta empleadoUnoAntiguedadUnHijo;

    @BeforeEach
    void setUp(){
        empleadoCasado = new EmpleadoPlanta(true, 0, 0);
        empleadoConUnoAntiguedad = new EmpleadoPlanta(false, 1, 0);
        empleadoUnoAntiguedadUnHijo = new EmpleadoPlanta(false, 1, 1);
    }

    @Test
    public void testCalcularSueldoBasico(){
        assertEquals(50000, empleadoCasado.calcularSueldoBasico());
        assertEquals(50000, empleadoConUnoAntiguedad.calcularSueldoBasico());
        assertEquals(50000, empleadoUnoAntiguedadUnHijo.calcularSueldoBasico());
    }

    @Test
    public void testCalcularAdicional(){
        assertEquals(5000, empleadoCasado.calcularAdicional());
        assertEquals(2000, empleadoConUnoAntiguedad.calcularAdicional());
        assertEquals(4000, empleadoUnoAntiguedadUnHijo.calcularAdicional());
    }

    @Test
    public void testSueldo(){
        assertEquals(48250, empleadoCasado.sueldo());
        assertEquals(45400, empleadoConUnoAntiguedad.sueldo());
        assertEquals(47300, empleadoUnoAntiguedadUnHijo.sueldo());
    }
}
