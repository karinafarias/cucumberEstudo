package interfaces.mobile.ios;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import drivers.mobile.DriverMobile;
import interacoes.InteracaoIOS;
import interfaces.log.ILog;

public interface IClique {

	default void clicarElementos(List<By> elementos) {
		for(By elemento : elementos) {
			DriverMobile.getDriverIOS().findElement(elemento).click();
		}
	}

	default void clicar(By elemento) {
		try {
			ILog.logAutomacao(" -- Realizar acao de clicar no elemento: " + elemento);
			DriverMobile.getDriverIOS().findElement(elemento).click();
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

	default void duploCliqueNoElemento(By elemento) {
		Actions action = new Actions(DriverMobile.getDriverIOS());
		try {
			ILog.logAutomacao(" -- Realizar acao de duplo clique no elemento: " + elemento);
			action.doubleClick(DriverMobile.getDriverIOS().findElement(elemento));
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