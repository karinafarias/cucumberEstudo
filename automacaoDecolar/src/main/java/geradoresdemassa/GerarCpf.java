package geradoresdemassa;

import java.util.ArrayList;
import java.util.List;

public class GerarCpf {
	private String cpfGerado = null;
	private String numerosCpf = null;
	private String digito = null;
	private List<String> listaDeCpf = new ArrayList<String>();
	private Integer primDig, segDig;
	private int soma = 0, peso = 10;
	private String cpfGeradoDigito;
	private String iniciais = "";
	private Integer numero = null;
	private String numDig;
	private boolean validaCpf;

	protected List<String> gerarCpf(int quantidade) {
		for (int i = 1; i <= quantidade; i++) {
			cpfGerado = geraNumerosCpf();
			digito = calcDigVerif(cpfGerado);
			cpfGerado = cpfGerado + digito;

			int cont = 0;
			while (validaCpf(cpfGerado) == false && cont < 40) {
				cont++;
			}
			listaDeCpf.add(cpfGerado);
			cpfGerado = "";
			digito = "";
			numero = null;
			numDig = "";
			iniciais = "";
			cpfGeradoDigito = "";
			numerosCpf = "";
		}
		return listaDeCpf;
	}

	/**
	 * @param num
	 * @return string cpf com digito verificador
	 */
	private String calcDigVerif(String num) {
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
		if (soma % 11 == 0 | soma % 11 == 1)
			primDig = new Integer(0);
		else
			primDig = new Integer(11 - (soma % 11));
		soma = 0;
		peso = 11;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
		soma += primDig.intValue() * 2;
		if (soma % 11 == 0 | soma % 11 == 1)
			segDig = new Integer(0);
		else
			segDig = new Integer(11 - (soma % 11));
		cpfGeradoDigito = primDig.toString() + segDig.toString();
		return cpfGeradoDigito;
	}

	/**
	 * @return string cpf
	 */
	private String geraNumerosCpf() {
		for (int i = 0; i < 9; i++) {
			numero = new Integer((int) (Math.random() * 10));
			iniciais += numero.toString();
		}
		numerosCpf = iniciais;
		return numerosCpf;
	}

	/**
	 * @param cpf
	 * @return true caso cpf for v�lido, ou false caso cpf for inv�lido
	 */
	private boolean validaCpf(String cpf) {
		if (cpf.length() != 11 && cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999"))
			return false;
		numDig = cpf.substring(9, 11);
		validaCpf = calcDigVerif(numDig).equals(cpf.substring(9, 11));
		return validaCpf;
	}

}
