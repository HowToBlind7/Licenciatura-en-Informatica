package ar.edu.unlp.info.oo2.biblioteca;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonAdapter extends VoorheesExporter {
	JSONArray jsonObj;
	
	public JsonAdapter() {
		jsonObj = new JSONArray();
	}
	
	public String exportar(List<Socio> socios) {
		jsonObj.toJSONString(socios);
		return this.toArrayJson(socios).toString().replace("\\", "");
	}
	
	private JSONObject socioToJsonObject(Socio socio) {
		JSONObject socioJson = new JSONObject();
		socioJson.put("nombre", socio.getNombre());
		socioJson.put("email", socio.getEmail());
		socioJson.put("legajo", socio.getLegajo());
		return socioJson;
	}
	
	private JSONArray toArrayJson(List<Socio> socios) {
		JSONArray jsonArray = new JSONArray();
		socios.stream()
			.forEach(s -> jsonArray.add(this.socioToJsonObject(s)));
		return jsonArray;
	}
}
