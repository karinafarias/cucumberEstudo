package geradoresdemassa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GerarEndereco {
	private List<Integer> numero = new ArrayList<Integer>();
	private int numeroAleatorio;
	private int logradouroAleatorio;
	private int complementoAleatorio;
	private String EnderecoCompleto;

	protected List<String> gerarEndereco(int quantidade) {
		String logradouro[] = { "Vila", "Largo", "Travessa", "Viela", "Loteamento", "Patio", "Viaduto", "Area",
				"Via", "Distrito", "Vale", "Nucleo", "Trevo", "Trecho", "Estrada", "Sitio", "Morro", "Rua",
				"Chacara", "Rodovia", "Avenida", "Colonia", "Recanto", "Quadra", "Praca", "Parque", "Conjunto",
				"Alameda" };
		String complemento[] = { "Reinado do Cavalo Marinho", "Na paz do seu sorriso", "Borboletas Psicodelicas",
				"Ary da Rocha", "Itapolis", "Senador Vergueiro", "Joao Moura", "Doutor Bacelar", "Agostinho Gomes",
				"Taquari", "Dom Pedro II ", "Maranhao", " das Flores", "José Bonifácio", "Da Paz", "Santo Antônio",
				"Sete de Setembro", "São Sebastião", "Brasil", "Gonçalo de Carvalho", "Pedro Basso", "Bento Gonçalves",
				"Aurora" };

		for (int i = 0; i < quantidade; i++) {
			numeroAleatorio = (int) (Math.random() * 1000);
			numero.add(numeroAleatorio);
		}
		Random random = new Random();
		List<String> enderecos = new ArrayList<String>();
		for (int i = 0; i < quantidade; i++) {
			logradouroAleatorio = 0 + random.nextInt(logradouro.length);
			complementoAleatorio = 0 + random.nextInt(complemento.length);
			EnderecoCompleto = logradouro[logradouroAleatorio] + " "
					+ (complemento[complementoAleatorio] + ", " + numero.get(0));
			enderecos.add(EnderecoCompleto);
		}
		return enderecos;
	}
}