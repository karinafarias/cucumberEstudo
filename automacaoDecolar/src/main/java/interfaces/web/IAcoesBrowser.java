package interfaces.web;

import java.time.LocalDateTime;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;

import drivers.web.DriverWeb;
import interfaces.log.ILog;

public interface IAcoesBrowser {

	default void abrirUrl(String url, String descricaoDoPasso) {
		try {
			DriverWeb.getDriver().get(url);
		} catch (Exception e) {
		}
	}

	default void navegarUrl(String url, String descricaoDoPasso) {
		try {
			DriverWeb.getDriver().navigate().to(url);
		} catch (Exception e) {
		}
	}

	default void trocarJanela(Integer indice, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			Set<String> handles = DriverWeb.getDriver().getWindowHandles();
			Object[] it = handles.toArray();
			DriverWeb.getDriver().switchTo().window((String) it[indice]);
		} catch (NoSuchWindowException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + indice + "' NAO encontrado.");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel trocar para a janela: '" + indice);
		} catch (Exception e) {
			ILog.logAutomacaoWarn(" -- ERRO: erro ao trocar para a janela de índice: " + indice);
			Assert.fail(LocalDateTime.now() + "erro ao trocar para a janela de índice: " + indice);
		}
	}

	default void trocarJanela(String nameOrHandle, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			DriverWeb.getDriver().switchTo().window(nameOrHandle);
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + nameOrHandle + "' NAO encontrado.");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel trocar para a janela: '" + nameOrHandle);
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: tempo excedido para encontrar a janela: '" + nameOrHandle);
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel trocar para a janela: '" + nameOrHandle);
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: janela: '" + nameOrHandle + "' NAO esta visivel.");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel trocar para a janela: '" + nameOrHandle);
		} catch (NoSuchWindowException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + nameOrHandle + "' NAO encontrado.");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel trocar para a janela: '" + nameOrHandle);
		}
	}

	default void mudarAba(int numero, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			DriverWeb.getDriver().switchTo()
					.window((String) DriverWeb.getDriver().getWindowHandles().toArray()[numero]);
		} catch (NoSuchWindowException e) {
			ILog.logAutomacaoWarn(" -- ERRO: aba de numero: '" + numero + "' NAO encontrado.");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel trocar para a aba: '" + numero);
		}
	}
}