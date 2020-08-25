package interfaces.mobile.ios;

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

import drivers.mobile.DriverMobile;
import interacoes.InteracaoIOS;
import interfaces.log.ILog;

public interface ICombo {
	
	default void selecionarCombo(By elemento, String valor) {
		try {
			WebElement webElement = DriverMobile.getDriverIOS().findElement(elemento);
			Select combo = new Select(webElement);
			combo.selectByVisibleText(valor);
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}

	default void selecionarCombo(By elemento, int posicao) {
		try {
			WebElement webElement = DriverMobile.getDriverIOS().findElement(elemento);
			Select combo = new Select(webElement);
			combo.selectByIndex(posicao);
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}

	default String obterTextoDaPrimeiraPosicaoDoCombo(By elemento) {
		Select combo = null;
		try {
			WebElement element = DriverMobile.getDriverIOS().findElement(elemento);
			combo = new Select(element);
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
		return combo.getFirstSelectedOption().getText();
	}

	default Integer obterQuantidadeOpcoesCombo(By elemento) {
		List<WebElement> options = new ArrayList<>();
		try {
			WebElement element = DriverMobile.getDriverIOS().findElement(elemento);
			Select combo = new Select(element);
			options = combo.getOptions();
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
		return options.size();
	}

	default boolean passarTextoEverificarSeExisteOpcaoDeAcordoComOtextoNoCombo(By elemento, String texto) {
		boolean retorno = false;
		try {
			WebElement element = DriverMobile.getDriverIOS().findElement(elemento);
			Select combo = new Select(element);
			List<WebElement> options = combo.getOptions();
			for (WebElement option : options) {
				if (option.getText().equals(texto)) {
					retorno = true;
				}
			}
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
		return retorno;
	}

	default void desmarcarComboPorTextoVisivel(By elemento, String valor) {
		try {
			WebElement element = DriverMobile.getDriverIOS().findElement(elemento);
			Select combo = new Select(element);
			combo.deselectByVisibleText(valor);
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}

	default List<String> obterTextosCombo(By elemento) {
		List<String> listaDeTexto = new ArrayList<String>();
		try {
			WebElement element = DriverMobile.getDriverIOS().findElement(elemento);
			Select combo = new Select(element);
			int quantidade = obterQuantidadeOpcoesCombo(elemento);
			for (int i = 0; i <= quantidade; i++) {
				listaDeTexto.add(combo.getOptions().get(i).getText());
			}
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
		return listaDeTexto;
	}

	default List<String> obterTodasAsOpcoesSelecionadasQueEstaoSelecionadasNoCombo(By elemento) {
		List<String> valores = new ArrayList<String>();
		try {
			WebElement element = DriverMobile.getDriverIOS().findElement(elemento);
			Select combo = new Select(element);
			List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
			for (WebElement opcao : allSelectedOptions) {
				valores.add(opcao.getText());
			}
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoIOS.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoIOS.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
		return valores;
	}
}