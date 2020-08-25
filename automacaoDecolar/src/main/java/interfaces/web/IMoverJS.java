package interfaces.web;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.mozilla.javascript.JavaScriptException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import drivers.web.DriverWeb;
import interfaces.log.ILog;

public interface IMoverJS {

	default void moverParaOelementoJavascript(By elemento, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			JavascriptExecutor executor = (JavascriptExecutor) DriverWeb.getDriver();
			executor.executeScript("arguments[0].scrollIntoView(true);", DriverWeb.getDriver().findElement(elemento));
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
		} catch(JavaScriptException e) {
			ILog.logAutomacaoWarn(" -- ERRO: erro de Javascript ao tentar realizar acao no elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " -- erro de Javascript ao tentar realizar acao no elemento: '" + elemento);
		}
	}
}