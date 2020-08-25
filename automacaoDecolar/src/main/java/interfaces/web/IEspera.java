package interfaces.web;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.web.DriverWeb;
import interfaces.log.ILog;

public interface IEspera {

	default void esperarSerClicavel(By elemento, int tempoEmSegundos, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), tempoEmSegundos);
			wait.until(ExpectedConditions.elementToBeClickable(elemento));
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

	default void esperarSerSelecionavel(By elemento, int tempoEmSegundos, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), tempoEmSegundos);
			wait.until(ExpectedConditions.elementToBeSelected(elemento));
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

	default void esperarUrlSerCarregada(String url, int tempoEmSegundos, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), tempoEmSegundos);
			wait.until(ExpectedConditions.urlToBe(url));
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para carregar a url: '" + url);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para carregar a url: '" + url + "' em tela.");
		}
	}

	default void esperarVisibilidadeDoElemento(By elemento, int tempoEmSegundos, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			WebDriverWait wait = new WebDriverWait(DriverWeb.getDriver(), tempoEmSegundos);
			wait.until(ExpectedConditions.visibilityOf(DriverWeb.getDriver().findElement(elemento)));
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
	
	default void esperarPadrao(int tempoEmSegundos) {
		try {
			Thread.sleep(tempoEmSegundos * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}