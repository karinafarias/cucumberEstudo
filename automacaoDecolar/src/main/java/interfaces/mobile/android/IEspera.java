package interfaces.mobile.android;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.mobile.DriverMobile;

public interface IEspera {

	default void esperarVisibilidadeDoElemento(By elemento, int tempoEmSegundos, String descricaoDoPasso) {
		WebDriverWait wait = new WebDriverWait(DriverMobile.getDriverAndroid(), tempoEmSegundos);
		wait.until(ExpectedConditions.visibilityOf(DriverMobile.getDriverAndroid().findElement(elemento)));
	}

	default void esperarSerClicavel(By elemento, int tempoEmSegundos, String descricaoDoPasso) {
		WebDriverWait wait = new WebDriverWait(DriverMobile.getDriverAndroid(), tempoEmSegundos);
		wait.until(ExpectedConditions.elementToBeClickable(elemento));
	}

	default void esperarInvisibilidadeDoElemento(By elemento, int tempoEmSegundos, String descricaoDoPasso) {
		WebDriverWait wait = new WebDriverWait(DriverMobile.getDriverAndroid(), tempoEmSegundos);
		wait.until(ExpectedConditions.invisibilityOf(DriverMobile.getDriverAndroid().findElement(elemento)));
	}
}