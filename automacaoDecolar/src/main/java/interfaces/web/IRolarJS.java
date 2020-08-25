package interfaces.web;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.mozilla.javascript.JavaScriptException;
import org.openqa.selenium.JavascriptExecutor;

import drivers.web.DriverWeb;
import interfaces.log.ILog;

public interface IRolarJS {

	default void rolarJavascript(int quantidade, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			JavascriptExecutor jse = (JavascriptExecutor) DriverWeb.getDriver();
			jse.executeScript("window.scrollBy(0, " + quantidade + ")");
		} catch (JavaScriptException e) {
			ILog.logAutomacaoWarn(" -- ERRO: erro de Javascript ao tentar realizar acao de rolagem.");
			Assert.fail(LocalDateTime.now() + " -- erro de Javascript ao tentar realizar acao de rolagem.");
		}
	}
}