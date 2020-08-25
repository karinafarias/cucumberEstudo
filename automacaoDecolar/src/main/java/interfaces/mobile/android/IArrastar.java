package interfaces.mobile.android;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.interactions.touch.TouchActions;

import drivers.mobile.DriverMobile;
import interacoes.InteracaoAndroid;
import interfaces.log.ILog;

public interface IArrastar {

	default void arrastar(By elementoAoSerPressionado, By elementoDestinoASerMovido) {
		try {
			ILog.logAutomacao(" -- Realizar acao de clicar no elemento: " + elementoDestinoASerMovido);
			TouchActions pressionar = new TouchActions(DriverMobile.getDriverAndroid());
			pressionar.longPress(DriverMobile.getDriverAndroid().findElement(elementoAoSerPressionado))
					.moveToElement(DriverMobile.getDriverAndroid().findElement(elementoDestinoASerMovido)).release()
					.perform();
			ILog.logAutomacaoWarn(" -- Tempo excedido para encontrar elemento: '" + elementoDestinoASerMovido
					+ "' na plataforma: '" + InteracaoAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elementoDestinoASerMovido + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elementoDestinoASerMovido + "' NAO esta visivel na plataforma: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elementoDestinoASerMovido + "NAO visivel' em tela.");
		}
	}
}