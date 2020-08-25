package interfaces.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import io.restassured.module.jsv.JsonSchemaValidator;

interface IValidacoes {

	default long verificarTempoDeRequisicaoEresposta(Response resposta, TimeUnit unidadeDeTempo) {
		return resposta.getTimeIn(unidadeDeTempo);
	}

	default void validarEstruturaJson(String jsonAsString) {
		try {
			new JSONObject(jsonAsString);
		} catch (JSONException ex) {
			try {
				new JSONArray(jsonAsString);
			} catch (JSONException ex1) {
				fail();
			}
		}
	}
	
	default void validarItensBody(Response response, Map<String, String> listaItens) {
		for (String chave : listaItens.keySet()) {
			response.then().assertThat().body(chave, equalTo(listaItens.get(chave)));
		}
	}

	default void validarItemBody(Response response, String item, String valor) {
		response.then().assertThat().body(item, equalTo(valor));
	}

	default void validarEstruturaXml(String xml) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			builder.parse(new InputSource(new StringReader(xml)));
		} catch (Exception e) {
			fail();
		}
	}

	default void validarStatusCode(Response response, int statusDesejado) {
		assertEquals(response.getStatusCode(), statusDesejado);
	}
	
	default void validarStatusLine(Response response, String statusLineDesejado) {
		Assert.assertEquals(response.statusLine(), statusLineDesejado);
	}

	default void validarContentType(Response response, ContentType contentType) {
		Assert.assertEquals(response.getContentType(), contentType);
	}

	default void validarValorDoCookie(Response response, String nomeCookie, String valorDoCookie) {
		assertTrue(response.getCookie(nomeCookie).contains(valorDoCookie));
	}
	
	default void validarValorDeElementoJsonPorChave(String chave, Object valor, String json) {
		JSONObject jsonObject = new JSONObject(json);
		assertTrue(jsonObject.has(chave));
		
		Object valorCampo = jsonObject.get(chave);
		assertEquals(valorCampo, valor);
	}
	
	
	
	default void validarValorDeElementoXmlPorTagGenerica(String tagNameDoElemento, String valor, String xml)
			throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		int numeroDeVezesEncontrado = 0;
		dbf.setNamespaceAware(false);
		DocumentBuilder docBuilder = dbf.newDocumentBuilder();
		Document doc = docBuilder.parse(new InputSource(new StringReader(xml)));
		NodeList dadosNodeList = doc.getElementsByTagNameNS("*", tagNameDoElemento);
		for (int i = 0; i < dadosNodeList.getLength(); i++) {
			if (dadosNodeList.item(i).getTextContent().equals(valor)) {
				numeroDeVezesEncontrado = numeroDeVezesEncontrado + 1;
			}
		}
		if(numeroDeVezesEncontrado == 0) {
			fail();
		}

	}
	
	default boolean validarSeFoiInformadoJsonOuXml(ContentType contentType, String xmlOuJson) {
		boolean retorno = false;
		if (contentType != ContentType.ANY && !xmlOuJson.isEmpty()) {
			if (ContentType.JSON == contentType) {
				validarEstruturaJson(xmlOuJson);
				retorno = true;
			} else if (ContentType.XML == contentType) {
				validarEstruturaXml(xmlOuJson);
				retorno = true;
			}
		}
		return retorno;
	}
	
	default void validarEsquema(String url, String jsonFile) {
			File json = new File("src\\test\\resources\\armazenador\\"+jsonFile);
			RestAssured.given()
			.when()
			.get(url)
			.then()
			.assertThat()
			.body(JsonSchemaValidator.matchesJsonSchema(json));
		}
	
	default void validarChaveHeader(String chaveHeader, String conteudoEsperado, Response resposta) {
		String headerName = resposta.getHeader(chaveHeader);
		assertEquals(headerName, conteudoEsperado);
	}
	
}