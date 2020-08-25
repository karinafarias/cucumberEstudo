package interfaces.web;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import drivers.web.DriverWeb;

public interface IUtils {

	default void tirarScreenshotWeb(String caminhoDaImagem, String nomeDaImagem) {
		File screenshot = ((TakesScreenshot) DriverWeb.getDriver()).getScreenshotAs(OutputType.FILE);
		File destino = new File(caminhoDaImagem + nomeDaImagem + ".png");
		try {
			FileUtils.copyFile(screenshot, destino);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
