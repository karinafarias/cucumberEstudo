package interfaces.mobile.android;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import drivers.mobile.DriverMobile;
import interacoes.InteracaoAndroid;
import interfaces.log.ILog;

public interface IMover{

	default void moverParaOelemento(By elemento) {
		Actions action = new Actions(DriverMobile.getDriverAndroid());
		try {
			ILog.logAutomacao(" -- Realizar acao de mover para o elemento: " + elemento);
			action.moveToElement(DriverMobile.getDriverAndroid().findElement(elemento)).build().perform();
			// or action.moveToElement(DriverMobile.getDriverAndroid().findElement(elemento)).perform();
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'. NAO foi possivel localizar o elemento: '"
					+ elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'. Tempo excedido para encontrar elemento: '"
					+ elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
	}
	
	default void swipe1() {
		TouchActions action = new TouchActions(DriverMobile.getDriverAndroid());
		action.down(0, 50);
	}

	default void swipe2() {
		TouchActions action = new TouchActions(DriverMobile.getDriverAndroid());
		action.flick(0, 30);
	}
	
	default void swipe3(By elemento) {
		TouchActions action = new TouchActions(DriverMobile.getDriverAndroid());
		action.flick(DriverMobile.getDriverAndroid().findElement(elemento), 0, 30, 2);
	}
}