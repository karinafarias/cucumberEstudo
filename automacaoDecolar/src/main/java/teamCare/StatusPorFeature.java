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

public class StatusPorFeature {
	public void obterStatusFeatures(String json) throws IOException {
		Map<String, List<String>> statusPorfeature = new HashMap<>();
		List<String> status = new ArrayList<>();
		String feature;

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
			feature = jsonObject.get("name").toString();

			for (int j = 0; j <= jsonArray2.length() - 1; j++) {
				jsonObject = jsonArray2.getJSONObject(j);
				JSONArray jsonArray3 = jsonObject.getJSONArray("steps");

				for (int x = 0; x <= jsonArray3.length() - 1; x++) {
					jsonObject = jsonArray3.getJSONObject(x);
					status.add(jsonObject.getJSONObject("result").get("status").toString());
				}
			}
			statusPorfeature.put(feature, status);
			status = new ArrayList<>();
		}

		Set<String> chaves = statusPorfeature.keySet();
		for (String chave : chaves) {
			if (chave != null) {
				 System.out.println("\n" + chave + statusPorfeature.get(chave));
			}
		}
	}
}
