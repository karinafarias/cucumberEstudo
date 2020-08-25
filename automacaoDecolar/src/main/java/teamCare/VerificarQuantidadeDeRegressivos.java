package teamCare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class VerificarQuantidadeDeRegressivos {
	public void verificarQuantidadesDeRegressivos(String json) throws IOException {
		List<String> status = new ArrayList<>();
		List<String> regressivo = new ArrayList<>();
		Map<String, List<String>> statusPorRegressivo = new HashMap<>();
		String nomeCenario = null;
		FileReader fr = new java.io.FileReader(json);
		BufferedReader br = new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb = sb.append(line);
		}
		br.close();
		fr.close();

		JSONArray jsonArray = new JSONArray(sb.toString());

		for (int i = 0; i <= jsonArray.length() - 1; i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			JSONArray jsonArray2 = jsonObject.getJSONArray("elements");

			for (int j = 0; j <= jsonArray2.length() - 1; j++) {
				nomeCenario = jsonArray2.getJSONObject(j).getString("name");
				jsonObject = jsonArray2.getJSONObject(j);
				JSONArray jsonArray3 = jsonObject.getJSONArray("tags");
				JSONArray jsonArray4 = jsonObject.getJSONArray("steps");
				
				for (int x = 0; x <= jsonArray3.length() - 1; x++) {
					jsonObject = jsonArray3.getJSONObject(x);
					String tag = jsonObject.get("name").toString().toLowerCase();
			
					if (tag.contains("regressivo")) {
						regressivo.add(tag);
					}
				}
				for (int z = 0; z <= jsonArray4.length() - 1; z++) {
					jsonObject = jsonArray4.getJSONObject(z);
					status.add(jsonObject.getJSONObject("result").get("status").toString());
				}
			}
			statusPorRegressivo.put("\n" + "O regressivo do cenário" + " '" + nomeCenario + "' gerou os seguintes status: ", status);
			status = new ArrayList<>();
			regressivo = new ArrayList<>();
		}
		
		Set<String> keys = statusPorRegressivo.keySet();
		for (String chave : keys) {
			if (chave != null) {
				System.out.println(chave + " " + statusPorRegressivo.get(chave));
			}
		}
	}
}