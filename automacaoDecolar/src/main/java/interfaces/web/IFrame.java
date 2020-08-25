package interfaces.web;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.TimeoutException;

import drivers.web.DriverWeb;
import interfaces.log.ILog;

public interface IFrame {

	default void entrarFrame(String elemento, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			DriverWeb.getDriver().switchTo().frame(elemento);
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: frame: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o frame: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: tempo excedido para encontrar frame: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o frame: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O frame: " + elemento + "NAO esta visivel' em tela.");
		} catch (NoSuchFrameException e) {
			ILog.logAutomacaoWarn(" -- ERRO: frame: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o frame: '" + elemento + "' em tela.");
		}
	}

	default void sairFrame(String descricaoDoPasso) {
		ILog.logAutomacao("----" + descricaoDoPasso);
		DriverWeb.getDriver().switchTo().defaultContent();
	}
}