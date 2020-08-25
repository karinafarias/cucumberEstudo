package steps;

import cucumber.api.java.pt.Dado;
import paginas.PagePassagem;

public class Passagem {
	PagePassagem pagi = new PagePassagem();
	
	@Dado("^que o usuário acessa o browser$")
	public void que_o_usuário_acessa_o_browser() throws Throwable {
	    pagi.acessarBrowser();
	}

	@Dado("^acesso o site$")
	public void acesso_o_site() throws Throwable {
		pagi.acessarBrowser();
	}

	@Dado("^preencho o campo origem$")
	public void preencho_o_campo_origem() throws Throwable {
	   
	}

	@Dado("^preencho o campo destino$")
	public void preencho_o_campo_destino() throws Throwable {
	   
	}

	@Dado("^seleciono a data de ida$")
	public void seleciono_a_data_de_ida() throws Throwable {
	    
	}

	@Dado("^seleciono a data de volta$")
	public void seleciono_a_data_de_volta() throws Throwable {
	    
	}

	@Dado("^seleciono a quantidade de passageiro adulto$")
	public void seleciono_a_quantidade_de_passageiro_adulto() throws Throwable {
	  
	}

	@Dado("^seleciono a quantidade de passageiro crianca$")
	public void seleciono_a_quantidade_de_passageiro_crianca() throws Throwable {
	   
	}

	@Dado("^seleciono a classe da passagem$")
	public void seleciono_a_classe_da_passagem() throws Throwable {

	}

	@Dado("^cliclo em aplicar$")
	public void cliclo_em_aplicar() throws Throwable {
	   
	}

	@Dado("^clico em procurar$")
	public void clico_em_procurar() throws Throwable {
	 
	}

	@Dado("^o site exibe os voos na tela$")
	public void o_site_exibe_os_voos_na_tela() throws Throwable {
	 
	}

}
