package interfaces.mobile.android;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import drivers.mobile.DriverMobile;
import interacoes.InteracaoAndroid;

public interface IValidacoesAndroid extends IObter {
	Log logger = LogFactory.getLog(IValidacoesAndroid.class);

	@SuppressWarnings("unlikely-arg-type")
	default void validarMensagem(By textoOriginal, By elemento) {
		try {
			String textoDeComparacao = obterTexto(elemento);

			if (textoOriginal.equals(textoDeComparacao)) {
				System.out.println("Teste realizado com sucesso.");
			} else {
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
			System.out.println(e);
		}
	}

	default void validarSeElementoEstaVisivel(By elemento) {
		assertEquals(true, DriverMobile.getDriverAndroid().findElement(elemento).isDisplayed());
	}

	default void validarSeElementoEstaHabilitado(By elemento) {
		assertEquals(true, DriverMobile.getDriverAndroid().findElement(elemento).isEnabled());
	}

	default boolean validarSeElementoEstaSelecionado(By elemento) {
		boolean retorno = false;
		try {
			logger.info(" -- Realizar acao de verificar se radio do elemento: " + elemento + " esta marcado.");
			retorno = DriverMobile.getDriverAndroid().findElement(elemento).isSelected();
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
		return retorno;
	}

	default boolean validarSeOcheckBoxEstaMarcado(By elemento) {
		boolean retorno = false;
		try {
			retorno = DriverMobile.getDriverAndroid().findElement(elemento).isSelected();
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoAndroid.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
		return retorno;
	}

	default String verificarOrientacaoDaTela() {
		return DriverMobile.getDriverAndroid().getOrientation().toString();
	}

	default String obterTempoAparelho() {
		return DriverMobile.getDriverAndroid().getDeviceTime();
	}
}