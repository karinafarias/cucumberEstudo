package geradoresdemassa;

import java.util.ArrayList;
import java.util.List;

public class GerarTelefone {
	private List<Integer> telefoneFixo = new ArrayList<Integer>();
	private List<String> telefones = new ArrayList<String>();
	private int contador = 0;
	private int cont = 0;
	private int numeroPrefixoAleatorio;
	private String str;
	private List<Integer> telefoneCelular = new ArrayList<Integer>();
	private int numeroAleatorio;

	protected List<String> gerarTelefoneFixo(int quantidade) {
		while (cont < quantidade) {
			contador = 0;
			while (contador < 10) {
				numeroPrefixoAleatorio = (int) (1 + Math.random() * 9);
				telefoneFixo.add(numeroPrefixoAleatorio);
				contador++;
			}
			str = telefoneFixo.get(0) + "" + telefoneFixo.get(1) + "" + telefoneFixo.get(2) + "" + telefoneFixo.get(3)
					+ "" + telefoneFixo.get(4) + "" + telefoneFixo.get(5) + "" + telefoneFixo.get(6) + ""
					+ telefoneFixo.get(7) + "" + telefoneFixo.get(8) + telefoneFixo.get(9);
			telefones.add(str);
			telefoneFixo.clear();
			cont++;
		}
		return telefones;
	}

	protected List<String> gerarTelefoneCelular(int quantidade) {
		while (cont < quantidade) {
			contador = 0;
			while (contador < 10) {
				numeroAleatorio = (int) (1 + Math.random() * 9);
				telefoneCelular.add(numeroAleatorio);
				contador++;
			}
			str = telefoneCelular.get(0) + "" + telefoneCelular.get(1) + "9" + telefoneCelular.get(2) + ""
					+ telefoneCelular.get(3) + "" + telefoneCelular.get(4) + "" + telefoneCelular.get(5) + ""
					+ telefoneCelular.get(6) + "" + telefoneCelular.get(7) + "" + telefoneCelular.get(8) + ""
					+ telefoneCelular.get(9);
			telefones.add(str);
			telefoneCelular.clear();
			cont++;
		}
		return telefones;
	}
}