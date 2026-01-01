package oo2.patrones;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class JacksonAdapter extends VoorheesExporter {
    
    public String exportar(List<Socio> socios){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(socios);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al exportar los datos a JSON";
        }
    }
}
