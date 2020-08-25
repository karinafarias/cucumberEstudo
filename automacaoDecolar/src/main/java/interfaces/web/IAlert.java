package interfaces.web;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import drivers.web.DriverWeb;
import interfaces.log.ILog;

public interface IAlert {

	default void aceitarAlerta(String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			Alert alert = DriverWeb.getDriver().switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			ILog.logAutomacaoWarn(" -- ERRO: NAO ha alerta presente na tela.");
			Assert.fail(LocalDateTime.now() + " NAO ha alerta presente na tela.");
		} catch (Exception e) {
			ILog.logAutomacaoWarn(" -- ERRO: erro ao aceitar alerta:" + e.getMessage());
			Assert.fail(LocalDateTime.now() + "erro ao aceitar alerta: " + e.getMessage());
		}
	}

	default String obterTextoDoAlerta(String descricaoDoPasso) {
		String texto = null;
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			Alert alert = DriverWeb.getDriver().switchTo().alert();
			texto = alert.getText();
		} catch (NoAlertPresentException e) {
			ILog.logAutomacaoWarn(" -- ERRO: NAO ha alerta presente na tela.");
			Assert.fail(LocalDateTime.now() + " NAO ha alerta presente na tela.");
		} catch (Exception e) {
			ILog.logAutomacaoWarn(" -- ERRO: erro ao obter texto do alerta:" + e.getMessage());
			Assert.fail(LocalDateTime.now() + "erro ao obter texto do alerta: " + e.getMessage());
		}
		return texto;
	}

	default void negarAlerta(String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			Alert alert = DriverWeb.getDriver().switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			ILog.logAutomacaoWarn(" -- ERRO: NAO ha alerta presente na tela.");
			Assert.fail(LocalDateTime.now() + " NAO ha alerta presente na tela.");
		} catch (Exception e) {
			ILog.logAutomacaoWarn(" -- ERRO: erro ao escrever no alerta:" + e.getMessage());
			Assert.fail(LocalDateTime.now() + "erro ao escrever no alerta: " + e.getMessage());
		}
	}

	default void escreverNoAlerta(String texto, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			ILog.logAutomacao("---- Massa utilizada: " + texto);
			Alert alert = DriverWeb.getDriver().switchTo().alert();
			alert.sendKeys(texto);
		} catch (Exception e) {
			ILog.logAutomacaoWarn(" -- ERRO: erro ao escrever o texto: " + texto + " no alerta:" + e.getMessage());
			Assert.fail(LocalDateTime.now() + " erro ao escrever o texto: " + texto + " no alerta: " + e.getMessage());
		}
	}
}