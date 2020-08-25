package interfaces.mobile.ios;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import drivers.mobile.DriverMobile;

public interface IArrastar {
	
	default void arrastar(By elementoAoSerPressionado, By elementoDestinoASerMovido) {
		TouchActions pressionar = new TouchActions(DriverMobile.getDriverIOS());
		pressionar.longPress(DriverMobile.getDriverIOS().findElement(elementoAoSerPressionado))
				.moveToElement(DriverMobile.getDriverIOS().findElement(elementoDestinoASerMovido)).release()
				.perform();
	}
}