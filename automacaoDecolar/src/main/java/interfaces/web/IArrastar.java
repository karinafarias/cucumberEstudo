package interfaces.web;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import drivers.web.DriverWeb;
import interfaces.log.ILog;

public interface IArrastar{
	
	default void arrastar(By elemento, By elemento_dois, String descricaoDoPasso) {
		Actions action = new Actions(DriverWeb.getDriver());
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			action.dragAndDrop(DriverWeb.getDriver().findElement(elemento), DriverWeb.getDriver().findElement(elemento_dois));
			action.perform();
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
		} catch (Exception e) {
			ILog.logAutomacaoWarn(" -- ERRO: erro ao arrastar elemento:" + elemento);
			Assert.fail(LocalDateTime.now() + "erro ao arrastar elemento:" + elemento);
		}
	}
}