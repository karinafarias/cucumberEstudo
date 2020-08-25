package api.steps;


import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import interacoes.InteracaoRequisicao;

public class API implements InteracaoRequisicao{
	Response resposta;
	String url;
	
	@Dado("^que eu faço uma requisição$")
	public void que_eu_faço_uma_requisição() {
		url = "https://jsonplaceholder.typicode.com/posts/1";
		usarHttps();	    
		resposta = get(url,"", ContentType.JSON);
		System.out.println(resposta.asString());
	}
	    
	@Então("^eu obtenho um código de sucesso$")
	public void eu_obtenho_um_código_de_sucesso()  {
	    validarStatusCode(resposta, 200);
		 
	}	

	@Então("^eu obtenho uma resposta em formato válido$")
	public void eu_obtenho_uma_resposta_em_formato_válido() {
	 validarEstruturaJson(resposta.asString());
	}
	
	@Então("^valido se a chave name retorna o valor correto$")
	public void valido_se_a_chave_name_retorna_o_valor_correto() {
		validarValorDeElementoJsonPorChave("id", 1, resposta.asString());
	}

	@Então("^eu valido o esquema fornecido$")
	public void eu_valido_o_esquema_fornecido() {
	    validarEsquema(url, "schema_json.json");
	}
	
	@Então("^valido se a chave Content-type retorna o valor correto$")
	public void valido_se_a_chave_Content_type_retorna_o_valor_correto() throws Throwable {
		validarChaveHeader("Content-Type", "application/json; charset=utf-8", resposta);
	}

}