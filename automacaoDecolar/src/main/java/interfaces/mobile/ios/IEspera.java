package interfaces.mobile.ios;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.mobile.DriverMobile;

public interface IEspera {

	default void esperarVisibilidadeDoElemento(By elemento, int tempoEmSegundos, String descricaoDoPasso) {
		WebDriverWait wait = new WebDriverWait(DriverMobile.getDriverIOS(), tempoEmSegundos);
		wait.until(ExpectedConditions.visibilityOf(DriverMobile.getDriverIOS().findElement(elemento)));
	}

	default void esperarSerClicavel(By elemento, int tempoEmSegundos, String descricaoDoPasso) {
		WebDriverWait wait = new WebDriverWait(DriverMobile.getDriverIOS(), tempoEmSegundos);
		wait.until(ExpectedConditions.elementToBeClickable(elemento));
	}

	default void esperarInvisibilidadeDoElemento(By elemento, int tempoEmSegundos, String descricaoDoPasso) {
		WebDriverWait wait = new WebDriverWait(DriverMobile.getDriverIOS(), tempoEmSegundos);
		wait.until(ExpectedConditions.invisibilityOf(DriverMobile.getDriverIOS().findElement(elemento)));
	}
}