package geradoresdemassa;

import java.util.ArrayList;
import java.util.List;

public class GerarRg {
	private String geraRg = "";
	private List<String> rg = new ArrayList<String>();
	private int contador = 0;
	private int cont = 0;
	private Integer numeroAleatorio;

	protected List<String> gerarRg(int quantidade) { // Cria Rgs com 9 digitos.
		while (cont < quantidade) {
			contador = 0;
			while (contador < 9) {
				numeroAleatorio = (int) (1 + Math.random() * 9);
				geraRg += numeroAleatorio.toString();
				contador++;
			}
			rg.add(geraRg);
			geraRg = "";
			cont++;
		}
		return rg;
	}
}