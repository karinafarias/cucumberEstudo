package teamCare;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PercorrerFeature {
	
	public int percorrer(String path) throws IOException {
		int regressivo = 0;
		File file = new File(path);
		File afile[] = file.listFiles();
		int i = 0;
		for (int j = afile.length; i < j; i++) {
			@SuppressWarnings("unused")
			File arquivos = afile[i];
			regressivo += percorrerFeature(afile[i].getAbsolutePath());
		}
		return regressivo;
	}
	
	
	public int percorrerFeature(String file) throws IOException {
		BufferedReader leitor = null;
		leitor = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		return lerCenario(leitor);
	}
	
	private int lerCenario(BufferedReader leitor) throws IOException {
		int regressivo = 0;
		String linha = null;
		do{
			try {
			linha = leitor.readLine();
			if (linha.toLowerCase().contains("regressivo")) {
				regressivo += 1;
			}
			}catch(NullPointerException e) {
				
			}
		
		}while(linha != null);
		
		return regressivo;
	}
}