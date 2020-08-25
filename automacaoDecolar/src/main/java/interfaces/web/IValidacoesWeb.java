package interfaces.web;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import drivers.web.DriverWeb;
import interfaces.log.ILog;

public interface IValidacoesWeb extends IObter {

	default void validarMensagem(String textoOriginal, By elemento, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			ILog.logAutomacao("---- Mensagem a ser validada: " + textoOriginal);
			String textoDeComparacao = obterTexto(elemento, descricaoDoPasso);

			if (textoOriginal.equals(textoDeComparacao)) {
			} else {
				ILog.logAutomacaoWarn(" -- ERRO: mensagem diferente ou nao encontrada.");
				Assert.fail(LocalDateTime.now() + "Mensagem diferente ou nao encontrada!");
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
	}

	default void validarSeElementoEstaVisivel(By elemento, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			assertEquals(true, DriverWeb.getDriver().findElement(elemento).isDisplayed());
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

	default void validarSeElementoEstaHabilitado(By elemento, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			assertEquals(true, DriverWeb.getDriver().findElement(elemento).isEnabled());
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

	default void validarTituloDoBrowser(String tituloDaAba, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			assertEquals(tituloDaAba, DriverWeb.getDriver().getTitle());
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: aba: '" + tituloDaAba + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar À aba: '" + tituloDaAba + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: tempo excedido para encontrar à aba: '" + tituloDaAba);
			Assert.fail(LocalDateTime.now() + " tempo excedido para encontrar à aba: '" + tituloDaAba + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: aba: '" + tituloDaAba + "' NAO esta visivel");
			Assert.fail(LocalDateTime.now() + " -- À aba: " + tituloDaAba + "NAO esta visivel'.");
		}
	}

	default void validarUrlAtual(String url, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			assertEquals(url, DriverWeb.getDriver().getCurrentUrl());
		} catch (Exception e) {
			ILog.logAutomacaoWarn(" -- ERRO: url: '" + url + "' NAO pode ser carregada.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel carregar a url: '" + url);
		}
	}

	default boolean validarSeElementoEstaSelecionado(By elemento, String descricaoDoPasso) {
		boolean retorno = false;
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			retorno = DriverWeb.getDriver().findElement(elemento).isSelected();
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

	default boolean validarSeOcheckBoxEstaMarcado(By elemento, String descricaoDoPasso) {
		boolean retorno = false;
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			retorno = DriverWeb.getDriver().findElement(elemento).isSelected();
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

	default void validarQtdCaracteresCampoCpfComMascara(By elemento, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			String qtdCpf = obterTexto(elemento, descricaoDoPasso);
			if (qtdCpf.length() > 14 || qtdCpf.length() != 14) {
				ILog.logAutomacaoWarn(" -- ERRO: O elemento: '" + elemento
						+ "' aceita uma quantidade de caracteres maior que o permitido.");
				Assert.fail(
						LocalDateTime.now() + " -- O campo aceita uma quantidade de caracteres maior que o permitido.");
			}
		} catch (NullPointerException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' está nulo.");
			Assert.fail(LocalDateTime.now() + " -- ERRO: o elemento: " + elemento + "esta nulo.");
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

	default void validarQtdCaracteresCampoCpfSemMascara(By elemento, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			String qtdCpf = obterTexto(elemento, descricaoDoPasso);
			if (qtdCpf.length() > 11 || qtdCpf.length() != 11) {
				ILog.logAutomacaoWarn(" -- ERRO: O elemento: '" + elemento
						+ "' aceita uma quantidade de caracteres maior que o permitido.");
				Assert.fail(
						LocalDateTime.now() + " -- O campo aceita uma quantidade de caracteres maior que o permitido.");
			}
		} catch (NullPointerException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' está nulo.");
			Assert.fail(LocalDateTime.now() + " -- ERRO: o elemento: " + elemento + "esta nulo.");
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

	default void validarQtdCaracteresCampoCnpjComMascara(By elemento, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			String qtdCnpj = obterTexto(elemento, descricaoDoPasso);
			if (qtdCnpj.length() > 14 || qtdCnpj.length() != 14) {
				ILog.logAutomacaoWarn(" -- ERRO: O elemento: '" + elemento
						+ "' aceita uma quantidade de caracteres maior que o permitido.");
				Assert.fail(
						LocalDateTime.now() + " -- O campo aceita uma quantidade de caracteres maior que o permitido.");
			}
		} catch (NullPointerException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' está nulo.");
			Assert.fail(LocalDateTime.now() + " -- ERRO: o elemento: " + elemento + "esta nulo.");
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

	default void validarQtdCaracteresCampoCnpjSemMascara(By elemento, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			String qtdCnpj = obterTexto(elemento, descricaoDoPasso);
			if (qtdCnpj.length() > 11 || qtdCnpj.length() != 11) {
				ILog.logAutomacaoWarn(" -- ERRO: O elemento: '" + elemento
						+ "' aceita uma quantidade de caracteres maior que o permitido.");
				Assert.fail(
						LocalDateTime.now() + " -- O campo aceita uma quantidade de caracteres maior que o permitido.");
			}
		} catch (NullPointerException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' está nulo.");
			Assert.fail(LocalDateTime.now() + " -- ERRO: o elemento: " + elemento + "esta nulo.");
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

	default void validarCaracteresCampoCpf(By elemento, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			String cpf = obterTexto(elemento, descricaoDoPasso);
			for (int i = 0; i < cpf.length(); i++) {
				if (Character.isLetter(cpf.charAt(i))) {
					ILog.logAutomacaoWarn(" -- ERRO: o elemento: '" + elemento + "' aceita caracteres nao permitidos.");
					Assert.fail(LocalDateTime.now() + " -- o elemento: '" + elemento
							+ "' aceita caracteres nao permitidos.");
				}
			}
		} catch (NullPointerException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' está nulo.");
			Assert.fail(LocalDateTime.now() + " -- ERRO: o elemento: " + elemento + "esta nulo.");
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

	default void validarCaracteresCampoCnpj(By elemento, String descricaoDoPasso) {
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			String cnpj = obterTexto(elemento, descricaoDoPasso);
			for (int i = 0; i < cnpj.length(); i++) {
				if (Character.isLetter(cnpj.charAt(i))) {
					ILog.logAutomacaoWarn(" -- ERRO: o elemento: '" + elemento + "' aceita caracteres nao permitidos.");
					Assert.fail(LocalDateTime.now() + " -- o elemento: '" + elemento
							+ "' aceita caracteres nao permitidos.");
				}
			}
		} catch (NullPointerException e) {
			ILog.logAutomacaoWarn(" -- Elemento: '" + elemento + "' está nulo.");
			Assert.fail(LocalDateTime.now() + " -- ERRO: o elemento: " + elemento + "esta nulo.");
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- o elemento: " + elemento + "NAO esta visivel' em tela.");
		}
	}

	default String validarCampoData(By elemento, String descricaoDoPasso) {
		String data = null;
		try {
			ILog.logAutomacao("----" + descricaoDoPasso);
			String dataCampo = obterTexto(elemento, descricaoDoPasso);
			SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
			format.setLenient(false);
			data = format.parse(dataCampo).toString();
		} catch (ParseException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento
					+ "' não foi possível realizar a conversão ou o campo aceita dados diferente de data.");
			Assert.fail(LocalDateTime.now() + " -- erro com na conversão da data: " + data);
		} catch (NullPointerException | IllegalArgumentException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' está nulo ou recebeu um argumento inválido");
			Assert.fail(LocalDateTime.now() + " -- elemento: '" + elemento
					+ "' está nulo ou recebeu um argumento inválido");
		} catch (NoSuchElementException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO encontrado.'");
			Assert.fail(LocalDateTime.now() + " -- NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			ILog.logAutomacaoWarn(" -- ERRO: Tempo excedido para encontrar elemento: '" + elemento);
			Assert.fail(LocalDateTime.now() + " Tempo excedido para encontrar o elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			ILog.logAutomacaoWarn(" -- ERRO: elemento: '" + elemento + "' NAO esta visivel na plataforma: '");
			Assert.fail(LocalDateTime.now() + " -- o elemento: " + elemento + "NAO esta visivel' em tela.");
		}
		return data;
	}

	default String retornaCorDoElementoCssColor(By elemento, String tipoCor) {
		String hex = null;
		String corRgb = DriverWeb.getDriver().findElement(elemento).getCssValue("color");
		String[] numbers = corRgb.replace("" + tipoCor + "(", "").replace(")", "").split(",");
		int r = Integer.parseInt(numbers[0].trim());
		int g = Integer.parseInt(numbers[1].trim());
		int b = Integer.parseInt(numbers[2].trim());
		hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
		return hex;
	}

	default String retornaCorDoElementoCssBackground(By elemento, String tipoCor) {
		String hex = null;
		String corRgb = DriverWeb.getDriver().findElement(elemento).getCssValue("background");
		String[] numeros = corRgb.replace("" + tipoCor + "(", "").replace(")", "").split(",");
		int r = Integer.parseInt(numeros[0].trim());
		int g = Integer.parseInt(numeros[1].trim());
		int b = Integer.parseInt(removeLetrasDoRgb(numeros[2]).trim());
		hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
		return hex;
	}

	default String obterCorDaImagem(File imagemPath, int width, int height) {
		String corRgb = null;
		BufferedImage imagem = null;
		try {
			imagem = ImageIO.read(imagemPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int dataColor = imagem.getRGB(width, height);
		Color c = new Color(dataColor);
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		corRgb = "Rgb(" + transformarInteiroEmString(r) + ", " + transformarInteiroEmString(g) + ", "
				+ transformarInteiroEmString(b) + ")";
		return corRgb;
	}

	/**
	 * O método obtem uma variavel do tipo string e remove letras da mesma.
	 * 
	 * @author leonardoananias
	 * @param numeroRgb recebe a string do rgb que deve ser retirado as letras
	 *                  complementares
	 * @return retorna o rgb correto
	 */
	default String removeLetrasDoRgb(String numeroRgb) {
		StringBuilder resultado = new StringBuilder();
		String rgb = numeroRgb.substring(0, 3);
		for (int i = 0; i < rgb.length(); i++) {
			if (!Character.isLetter(rgb.charAt(i))) {
				char c = rgb.charAt(i);
				resultado.append(c);
			}
		}
		return resultado.toString();
	}

	default String transformarInteiroEmString(int numero) {
		ILog.logAutomacao(" -- Realiza a transformação do inteiro para string -- ");
		String texto = Integer.toString(numero);
		return texto;
	}
}