package oo2.patrones;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.List;

public class JsonSimpleAdapter extends VoorheesExporter {

    @SuppressWarnings("unchecked")
    @Override
    public String exportar(List<Socio> socios){
        JSONArray jsonArray = new JSONArray();
        socios.forEach(socio -> jsonArray.add(this.crearJsonSocio(socio)));
        return jsonArray.toJSONString();
    }

    @SuppressWarnings("unchecked")
    private JSONObject crearJsonSocio(Socio socio) {
        JSONObject jsonSocio = new JSONObject();
        jsonSocio.put("nombre", socio.getNombre());
        jsonSocio.put("email", socio.getEmail());
        jsonSocio.put("legajo", socio.getLegajo());

        return jsonSocio;
    }
}