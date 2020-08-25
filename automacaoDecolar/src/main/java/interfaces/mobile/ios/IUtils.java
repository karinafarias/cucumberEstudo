package interfaces.mobile.ios;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import drivers.mobile.DriverMobile;

public interface IUtils {
	
	default void tirarScreenshotMobileIOS(String caminhoDaImagem, String nomeDaImagem) {
		File screenshot = ((TakesScreenshot) DriverMobile.getDriverIOS()).getScreenshotAs(OutputType.FILE);
		File destino = new File(caminhoDaImagem + nomeDaImagem + ".png");
		try {
			FileUtils.copyFile(screenshot, destino);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}