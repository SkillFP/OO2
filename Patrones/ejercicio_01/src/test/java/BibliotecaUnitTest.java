import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import oo2.patrones.JacksonAdapter;
import oo2.patrones.JsonSimpleAdapter;
import oo2.patrones.Socio;
import oo2.patrones.VoorheesExporter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BibliotecaUnitTest {
    private List<Socio> socios = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        this.socios.add(new Socio(
                "Mateo",
                "mateo@example.com",
                "12345"));
        this.socios.add(new Socio(
                "Ori",
                "ori@example.com",
                "67890"));
    }
    @Test
    void testExportarSocios() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        long versionesUnicas = Stream.of(
                new JacksonAdapter(),
                new VoorheesExporter(),
                new JsonSimpleAdapter()
        )
                .peek(e -> System.out.println("Procesando " + e.getClass().getSimpleName()))
                .map(e -> e.exportar(socios))
                .map(json -> {
                    try{
                        return mapper.readTree(json);
                    }
                    catch (JsonProcessingException e) { throw new RuntimeException("Fallo al parsear"); }
                })
                .distinct()
                .count();
        assertEquals(1, versionesUnicas);
    }
}
