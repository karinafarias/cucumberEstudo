package interfaces.mobile.ios;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import drivers.mobile.DriverMobile;
import interacoes.InteracaoIOS;
import interfaces.log.ILog;

public interface IMover {

	default void moverParaOelemento(By elemento) {
		Actions action = new Actions(DriverMobile.getDriverIOS());
		try {
			ILog.logAutomacao(" -- Realizar acao de mover para o elemento: " + elemento);
			action.moveToElement(DriverMobile.getDriverIOS().findElement(elemento)).build().perform();
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