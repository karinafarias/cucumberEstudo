package interfaces.api;

import static com.jayway.restassured.RestAssured.given;

import java.util.Map;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public interface IPost extends IValidacoes {

	default Response post(String url, String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().contentType(contentType).body(xmlOuJson).when().post(url).then().extract().response();
		} else {
			resposta = given().contentType(contentType).when().post(url).then().extract().response();
		}
		return resposta;
	}

	default Response postComParametroNaUrl(String url, Map<String, ?> parametersMap, String xmlOuJson,
			ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().contentType(contentType).params(parametersMap).body(xmlOuJson).when().post(url).then()
					.extract().response();
		} else {
			resposta = given().contentType(contentType).params(parametersMap).when().post(url).then().extract()
					.response();
		}
		return resposta;
	}

	default Response postComPathParam(String url, Map<String, ?> pathParametersMap, String xmlOuJson,
			ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().contentType(contentType).pathParams(pathParametersMap).body(xmlOuJson).when().post(url)
					.then().extract().response();
		} else {
			resposta = given().contentType(contentType).pathParams(pathParametersMap).when().post(url).then().extract()
					.response();
		}
		return resposta;
	}

	default Response postComParametroNaUrlEAutenticacaoNoCabecalho(String url, Map<String, ?> parametros,
			String parametroUmDeAutenticacaoNoCabecalho, String parametroDoisDeAutenticacaoNoCabecalho,
			String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).params(parametros).body(xmlOuJson).when().post(url).then().extract()
					.response();
		} else {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).params(parametros).when().post(url).then().extract().response();
		}
		return resposta;
	}

	// EXAMPLE. http://ergast.com/api/f1/{raceSeason}/circuits.json
	default Response postComPathParamEAutenticacaoNoCabecalho(String url, Map<String, ?> pathParams,
			String parametroUmDeAutenticacaoNoCabecalho, String parametroDoisDeAutenticacaoNoCabecalho,
			String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).pathParams(pathParams).body(xmlOuJson).when().post(url).then().extract()
					.response();
		} else {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).pathParams(pathParams).when().post(url).then().extract().response();
		}
		return resposta;
	}

	default Response postComAutenticacaoNoCabecalho(String url, String parametroUmDeAutenticacaoNoCabecalho,
			String parametroDoisDeAutenticacaoNoCabecalho, String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).body(xmlOuJson).when().post(url).then().extract().response();
		} else {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).when().post(url).then().extract().response();
		}
		return resposta;
	}

	default Response postComPathParamEParametroNaUrl(String url, Map<String, ?> pathParams, Map<String, ?> params,
			String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().contentType(contentType).pathParams(pathParams).params(params).body(xmlOuJson).when()
					.post(url).then().extract().response();
		} else {
			resposta = given().contentType(contentType).pathParams(pathParams).params(params).when().post(url).then()
					.extract().response();
		}
		return resposta;
	}

	default Response postComPathParamAutenticacaoNoCabecalhoEParametroNaUrl(String url, Map<String, ?> pathParams,
			Map<String, ?> params, String parametroUmDeAutenticacaoNoCabecalho,
			String parametroDoisDeAutenticacaoNoCabecalho, String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).pathParams(pathParams).params(params).body(xmlOuJson).when().post(url)
					.then().extract().response();
		} else {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).pathParams(pathParams).params(params).when().post(url).then().extract()
					.response();
		}
		return resposta;
	}
}