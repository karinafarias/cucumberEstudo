package interfaces.mobile.android;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import drivers.mobile.DriverMobile;
import interacoes.InteracaoAndroid;
import interfaces.log.ILog;

public interface IEscrever {

	default void escrever(By elemento, String texto) {
		try {
			ILog.logAutomacao(" -- Realizar acao de escrever no elemento: " + elemento + " o texto: " + texto);
			DriverMobile.getDriverAndroid().findElement(elemento).sendKeys(texto);
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn("-- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoAndroid.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoAndroid.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoAndroid.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoAndroid.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}
}