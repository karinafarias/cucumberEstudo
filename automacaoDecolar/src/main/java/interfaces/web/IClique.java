package interfaces.web;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import drivers.web.DriverWeb;
import interfaces.log.ILog;

public interface IClique {

	/**
	 *  Clicar em um ou mais elementos
	 * @param elementos
	 */
	default void clicarElementos(List<By> elementos, String descricaoDoPasso) {
		ILog.logAutomacao("----" + descricaoDoPasso);
		for (By elemento : elementos) {
			try {
				DriverWeb.getDriver().findElement(elemento).click();
			} catch (NoSuchElementException e) {
				ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
				Assert.fail(
						LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
			} catch (TimeoutException e) {
				ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
				Assert.fail(
						LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
			} catch (ElementNotVisibleException e) {
				ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
				Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
			} catch (Exception e) {
				ILog.logAutomacaoWarn(" -- ERRO: erro ao clicar no elemento:" + elemento);
				Assert.fail(LocalDateTime.now() + "erro ao clicar no elemento:" + elemento);
			}
		}
	}

	default void clicarElementoPorTextoVisivel(String texto, String descricaoDoPasso, String elemento) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			DriverWeb.getDriver().findElement(By.xpath("//" + elemento + "[text()='" + texto + "']")).click();
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: texto: '" + texto + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento pelo texto: '" + texto
					+ "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + texto + "pelo texto");
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento pelo texto: '" + texto);
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: texto: '" + texto + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O texto: " + texto + "NAO esta visivel' em tela.");
		} catch (Exception e) {
			ILog.logAutomacaoWarn(" -- ERRO: erro ao clicar no elemento pelo texto:" + texto);
			Assert.fail(LocalDateTime.now() + "erro ao clicar no elemento pelo texto:" + texto);
		}
	}

	/**
	 *  Clicar em um elemento
	 * @param elemento
	 */
	default void clicar(By elemento, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			DriverWeb.getDriver().findElement(elemento).click();
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
			ILog.logAutomacaoWarn(" -- ERRO: erro ao clicar no elemento:" + elemento);
			Assert.fail(LocalDateTime.now() + "erro ao clicar no elemento:" + elemento);
		}
	}

	/**
	 * @param elemento
	 * @param descricaoDoPasso
	 */
	default void duploCliqueNoElemento(By elemento, String descricaoDoPasso) {
		Actions action = new Actions(DriverWeb.getDriver());
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			action.doubleClick(DriverWeb.getDriver().findElement(elemento));
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
			ILog.logAutomacaoWarn(" -- ERRO: erro ao clicar no elemento:" + elemento);
			Assert.fail(LocalDateTime.now() + "erro ao clicar no elemento:" + elemento);
		}
	}

	default void submeterFormulario(By elemento, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			DriverWeb.getDriver().findElement(elemento).submit();
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
			ILog.logAutomacaoWarn(" -- ERRO: erro ao clicar no elemento:" + elemento);
			Assert.fail(LocalDateTime.now() + "erro ao clicar no elemento:" + elemento);
		}
	}

	/**
	 * 
	 */
	default void duploCliqueOndeEstiverOFocoDoMouse() {
		Actions action = new Actions(DriverWeb.getDriver());
		action.doubleClick();
	}
}