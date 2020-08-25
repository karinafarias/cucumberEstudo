package interfaces.mobile.android;

import java.time.Duration;

import drivers.mobile.DriverMobile;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public interface ISwipe {

	@SuppressWarnings({ "rawtypes", "unused" })
	default void swipeEsquerdaDireita(int origemLargura, int posicaoDaAltura, int destinoLargura) {
		PointOption point = new PointOption();
		TouchAction action = new TouchAction(DriverMobile.getDriverAndroid())
				.press(point.withCoordinates(origemLargura, posicaoDaAltura))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(point.withCoordinates(destinoLargura, posicaoDaAltura)).release().perform();
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	default void swipeUpAndDown(int posicaoDaLargura, int origemAltura, int destinoAltura) {
		PointOption point = new PointOption();
		TouchAction action = new TouchAction(DriverMobile.getDriverAndroid())
				.longPress(point.withCoordinates(posicaoDaLargura, origemAltura)).moveTo(point.withCoordinates(posicaoDaLargura, destinoAltura))
				.release().perform();
	}
}