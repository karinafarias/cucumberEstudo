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

public class ErroPorFeature {
//	Features (Funcionalidades) testadas X Erros encontrados X Sprint - ok

//	Status das Execuções das Sprints (por feature, testes e seus status, ciclo de teste) - ok

//	Índice de Cobertura de Teste Regressivo (ver como fazer) - possível!

//	Índice de Erros de testes Regressivos (fornecer os erros provenientes dos testes regressivos) - ok


	public void obterErroFeatures(String json) throws IOException {
		List<String> errorMessage = new ArrayList<>();
		String feature;
		Map<String, List<String>> erroPorFeature = new HashMap<>();

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
					try {
						errorMessage.add(jsonObject.getJSONObject("result").get("error_message").toString());
					} catch (Exception e) {
					}
				}
			}
			erroPorFeature.put(feature, errorMessage);
			errorMessage = new ArrayList<>();
		}

		Set<String> chaves = erroPorFeature.keySet();
		chaves = erroPorFeature.keySet();
		for (String chave : chaves) {
			if (chave != null) {
				 System.out.println("\n" + chave + erroPorFeature.get(chave));
			}
		}
	}
}