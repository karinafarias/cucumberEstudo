package interfaces.mobile.ios;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import drivers.mobile.DriverMobile;
import interacoes.InteracaoIOS;
import interfaces.log.ILog;

public interface ILimpar {

	default void limpar(By elemento, String texto) {
		try {
			ILog.logAutomacao(" -- Realizar acao de limpar o elemento: " + elemento);
			DriverMobile.getDriverIOS().findElement(elemento).clear();
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'. NAO foi possivel localizar o elemento: '"
					+ elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'. Tempo excedido para encontrar elemento: '"
					+ elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
	}

	default void limparValorComBackspace(WebElement elemento) {
		try {
			while (elemento.getAttribute("value").length() > 0) {
				ILog.logAutomacao(" -- Realizar acao de limpar o valor do: " + elemento + " com BACKSPACE");
				elemento.sendKeys(Keys.BACK_SPACE);
			}
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'. NAO foi possivel localizar o elemento: '"
					+ elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'. Tempo excedido para encontrar elemento: '"
					+ elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
	}

	default void limparCampo(By elemento) {
		try {
			ILog.logAutomacao(" -- Realizar acao de limpar o campo do elemento: " + elemento);
			DriverMobile.getDriverIOS().findElement(elemento).clear();
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'. NAO foi possivel localizar o elemento: '"
					+ elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'. Tempo excedido para encontrar elemento: '"
					+ elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
	}
}