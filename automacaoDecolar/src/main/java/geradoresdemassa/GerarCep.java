package geradoresdemassa;

import java.util.ArrayList;
import java.util.List;

import enums.Estado;

public class GerarCep {

	private Long validador;
	private List<String> cep = new ArrayList<String>();
	private String geraCep = "";
	private int contador = 0;
	private int cont = 0;
	private Integer numeroAleatorio;

	protected List<String> gerarCep(int param, String estado) {
		cep = new ArrayList<String>();
		geraCep = "";
		contador = 0;
		cont = 0;
		while (cont < param) {
			contador = 0;
			while (contador < 8) {
				numeroAleatorio = (int) (1 + Math.random() * 9);
				geraCep += numeroAleatorio.toString();
				contador++;
			}
			if (validaCep(geraCep, estado)) {
				cep.add(geraCep);
				cont++;
			}
			geraCep = "";
		}
		return cep;
	}

	private boolean validaCep(String geraCep, String estado) {
		validador = Long.parseLong(geraCep.substring(0, 5));
		if (estado == Estado.SaoPaulo.toString() && validador >= 01000 && validador <= 19999) {
			return true;
		} else if (estado == Estado.RioDeJaneiro.toString() && validador >= 20000 && validador <= 28999) {
			return true;
		} else if (estado == Estado.EspiritoSanto.toString() && validador >= 29000 && validador <= 29999) {
			return true;
		} else if (estado == Estado.MinasGerais.toString() && validador >= 30000 && validador <= 39999) {
			return true;
		} else if (estado == Estado.Bahia.toString() && validador >= 40000 && validador <= 48999) {
			return true;
		} else if (estado == Estado.Sergipe.toString() && validador >= 49000 && validador <= 49999) {
			return true;
		} else if (estado == Estado.Pernambuco.toString() && validador >= 49000 && validador <= 49999) {
			return true;
		} else if (estado == Estado.Alagoas.toString() && validador >= 57000 && validador <= 57999) {
			return true;
		} else if (estado == Estado.Paraiba.toString() && validador >= 58000 && validador < 58999) {
			return true;
		} else if (estado == Estado.RioGrandeDoNorte.toString() && validador >= 59000 && validador <= 59999) {
			return true;
		} else if (estado == Estado.Ceara.toString() && validador >= 60000 && validador <= 63999) {
			return true;
		} else if (estado == Estado.Piaui.toString() && validador >= 64000 && validador <= 64999) {
			return true;
		} else if (estado == Estado.Maranhao.toString() && validador >= 65000 && validador <= 65999) {
			return true;
		} else if (estado == Estado.Para.toString() && validador >= 66000 && validador <= 68899) {
			return true;
		} else if (estado == Estado.Amapa.toString() && validador >= 68900 && validador <= 68999) {
			return true;
		} else if (estado == Estado.Amazonas.toString() && validador >= 69000 && validador <= 69899) {
			return true;
		} else if (estado == Estado.Roraima.toString() && validador >= 69300 && validador <= 69389) {
			return true;
		} else if (estado == Estado.Acre.toString() && validador >= 69900 && validador <= 69999) {
			return true;
		} else if (estado == Estado.DistritoFederal.toString() && validador >= 70000 && validador <= 73699) {
			return true;
		} else if (estado == Estado.Brasilia.toString() && validador >= 70000 && validador <= 73699) {
			return true;
		} else if (estado == Estado.Goias.toString() && validador >= 72800 && validador <= 76799) {
			return true;
		} else if (estado == Estado.Tocantins.toString() && validador >= 77000 && validador <= 77995) {
			return true;
		} else if (estado == Estado.MatoGrosso.toString() && validador >= 78000 && validador <= 78899) {
			return true;
		} else if (estado == Estado.Rondonia.toString() && validador >= 78900 && validador <= 78999) {
			return true;
		} else if (estado == Estado.MatoGrossoDoSul.toString() && validador >= 79000 && validador <= 79999) {
			return true;
		} else if (estado == Estado.Parana.toString() && validador >= 79000 && validador <= 79999) {
			return true;
		} else if (estado == Estado.SantaCatarina.toString() && validador >= 88000 && validador <= 89999) {
			return true;
		} else if (estado == Estado.RioGrandeDoSul.toString() && validador >= 90000 && validador <= 99999) {
			return true;
		}
		return false;
	}
}