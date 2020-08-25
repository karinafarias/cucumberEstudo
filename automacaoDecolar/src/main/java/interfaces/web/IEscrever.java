package interfaces.web;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import drivers.web.DriverWeb;
import interfaces.log.ILog;

public interface IEscrever {

	/**
	 *  Escrever em algum campo
	 * @param elemento
	 * @param texto
	 */
	default void escrever(By elemento, String texto, String descricaoDoPasso) {
 		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			ILog.logAutomacao("---- Massa utilizada: " + texto);
			DriverWeb.getDriver().findElement(elemento).sendKeys(texto);
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
		}
	}
}