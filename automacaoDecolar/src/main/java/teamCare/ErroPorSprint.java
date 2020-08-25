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

public class ErroPorSprint {
	
	public void verificarErrosNasSprints(String json) throws IOException {
		List<String> sprint = new ArrayList<>();
		Map<List<String>, List<String>> erroPorSprint = new HashMap<>();
		List<String> errorMessage = new ArrayList<>();

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
				jsonObject = jsonArray2.getJSONObject(j);
				JSONArray jsonArray3 = jsonObject.getJSONArray("tags");
				JSONArray jsonArray4 = jsonObject.getJSONArray("steps");

				for (int x = 0; x <= jsonArray3.length() - 1; x++) {
					jsonObject = jsonArray3.getJSONObject(x);
					String tag = jsonObject.get("name").toString().toLowerCase();

					if (tag.contains("sprint")) {
						sprint.add(tag);
					}
				}
				for (int z = 0; z <= jsonArray4.length() - 1; z++) {
					jsonObject = jsonArray4.getJSONObject(z);
					try {
						errorMessage.add(jsonObject.getJSONObject("result").get("error_message").toString());
					} catch (Exception e) {
					}
				}
			}
			erroPorSprint.put(sprint, errorMessage);
			sprint = new ArrayList<>();
			errorMessage = new ArrayList<>();
		}

		Set<List<String>> chaves = erroPorSprint.keySet();
		for (List<String> chave : chaves) {
			if (chave != null) {
				System.out.println("\n" + chave + " " + erroPorSprint.get(chave));
			}
		}
	}
}