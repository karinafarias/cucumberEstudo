package interfaces.web;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import drivers.web.DriverWeb;
import interfaces.log.ILog;

public interface IMover {

	/**
	 * @param elemento
	 */
	default void moverParaOelemento(By elemento, String descricaoDoPasso) {
		Actions action = new Actions(DriverWeb.getDriver());
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			action.moveToElement(DriverWeb.getDriver().findElement(elemento)).build().perform();
			// or
			// action.moveToElement(DriverWeb.getDriver().findElement(elemento)).perform();
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

	default void moverParaElementoeClicar(By elemento, String descricaoDoPasso) {
		Actions action = new Actions(DriverWeb.getDriver());
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			action.moveToElement(DriverWeb.getDriver().findElement(elemento)).click().perform();
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

	default void manterElementoPressionado(By elemento, String descricaoDoPasso) {
		Actions action = new Actions(DriverWeb.getDriver());
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			action.clickAndHold(DriverWeb.getDriver().findElement(elemento)).perform();
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