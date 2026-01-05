package EmpleadoTest;

import oo2.patrones.Empleado;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmpleadoTest {
    // Desconozco el enfoque de la cátedra sobre testing ya que hago esta práctica durante vacaciones.
    //se consultará lo correspondiente a esto para asegurar cómo se busca que testeemos clases abstractas.
    @Test
    public void testCalcularDescuento() {
        Empleado empleadoMock = Mockito.mock(Empleado.class, Mockito.CALLS_REAL_METHODS);

        when(empleadoMock.calcularSueldoBasico()).thenReturn(1000.0);
        when(empleadoMock.calcularAdicional()).thenReturn(100.0);

        double resultado = empleadoMock.calcularDescuento();

        assertEquals(135.0, resultado, "El descuento debería ser el 13% del básico + 5% del adicional");
    }

    @Test
    public void testSueldo() {
        Empleado empleadoMock = Mockito.mock(Empleado.class, Mockito.CALLS_REAL_METHODS);

        when(empleadoMock.calcularSueldoBasico()).thenReturn(1000.0);
        when(empleadoMock.calcularAdicional()).thenReturn(100.0);

        assertEquals(965.0, empleadoMock.sueldo());
    }
}