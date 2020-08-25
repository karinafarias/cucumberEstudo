package interfaces.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import drivers.web.DriverWeb;
import interfaces.log.ILog;

public interface ICombo {

	/**
	 *  Selecionar combo por texto visível
	 * @param elemento
	 * @param valor
	 */
	default void selecionarCombo(By elemento, String valor, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			ILog.logAutomacao("---- Selecionar o valor: " + valor);
			WebElement webElement = DriverWeb.getDriver().findElement(elemento);
			Select combo = new Select(webElement);
			combo.selectByVisibleText(valor);
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
		}
	}

	/**
	 *  Clicar no combo pela posição (index)
	 * @param elemento
	 * @param posicao
	 */
	default void selecionarCombo(By elemento, int posicao, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			WebElement webElement = DriverWeb.getDriver().findElement(elemento);
			Select combo = new Select(webElement);
			combo.selectByIndex(posicao);
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
		}
	}

	/**
	 *  Obter texto da primeira posição do combo
	 * @param elemento
	 * @return String
	 */
	default String obterTextoDaPrimeiraPosicaoDoCombo(By elemento, String descricaoDoPasso) {
		Select combo = null;
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			WebElement element = DriverWeb.getDriver().findElement(elemento);
			combo = new Select(element);
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
		}
		return combo.getFirstSelectedOption().getText();
	}

	/**
	 *  Obter a quantidade de opções do combo
	 * @param elemento
	 * @return Integer
	 */
	default Integer obterQuantidadeOpcoesCombo(By elemento, String descricaoDoPasso) {
		List<WebElement> options = new ArrayList<>();
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			WebElement element = DriverWeb.getDriver().findElement(elemento);
			Select combo = new Select(element);
			options = combo.getOptions();
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
		}
		return options.size();
	}

	/**
	 *  Passar um texto e verificar se existe a opção no combo. Ex.: Se
	 *            quiser verificar num combo de cidade a opção "São Paulo", deverá
	 *            ser passado "São Paulo" como parâmetro
	 * @param elemento
	 * @param texto
	 * @return boolean
	 */
	default boolean passarTextoEverificarSeExisteOpcaoDeAcordoComOtextoNoCombo(By elemento, String texto,
			String descricaoDoPasso) {
		boolean retorno = false;
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			ILog.logAutomacao("---- Massa utilizada: " + texto);
			WebElement element = DriverWeb.getDriver().findElement(elemento);
			Select combo = new Select(element);
			List<WebElement> options = combo.getOptions();
			for (WebElement option : options) {
				if (option.getText().equals(texto)) {
					retorno = true;
				}
			}
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
		}
		return retorno;
	}

	/**
	 *  Desmarcar combo de acordo com o texto
	 * @param elemento
	 * @param valor
	 */
	default void desmarcarComboPorTextoVisivel(By elemento, String valor, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			ILog.logAutomacao("---- Massa utilizada: " + valor);
			WebElement element = DriverWeb.getDriver().findElement(elemento);
			Select combo = new Select(element);
			combo.deselectByVisibleText(valor);
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
		}
	}

	/**
	 *  Obter todos os textos do combo
	 * @param elemento
	 * @return List
	 */
	default List<String> obterTextosCombo(By elemento, String descricaoDoPasso) {
		List<String> listaDeTexto = new ArrayList<String>();
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			WebElement element = DriverWeb.getDriver().findElement(elemento);
			Select combo = new Select(element);
			int quantidade = obterQuantidadeOpcoesCombo(elemento, descricaoDoPasso);
			for (int i = 0; i <= quantidade; i++) {
				listaDeTexto.add(combo.getOptions().get(i).getText());
			}
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
		}
		return listaDeTexto;
	}

	/**
	 *  Obter uma lista das opções que estão selecionadas no combo
	 * @param elemento
	 * @return lista de String
	 */
	default List<String> obterTodasAsOpcoesSelecionadasQueEstaoSelecionadasNoCombo(By elemento,
			String descricaoDoPasso) {
		List<String> valores = new ArrayList<String>();
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			WebElement element = DriverWeb.getDriver().findElement(elemento);
			Select combo = new Select(element);
			List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
			for (WebElement opcao : allSelectedOptions) {
				valores.add(opcao.getText());
			}
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- O elemento: " + elemento + "NAO esta visivel' em tela.");
		}
		return valores;
	}

}