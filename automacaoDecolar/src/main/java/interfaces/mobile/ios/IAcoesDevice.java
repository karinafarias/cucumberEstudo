package interfaces.mobile.ios;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;

import drivers.mobile.DriverMobile;

public interface IAcoesDevice {
	
	default void esconderTeclado() {
		DriverMobile.getDriverIOS().hideKeyboard();
}
	default void rotacionarAparelho(DeviceRotation rotacaoDoAparelho) {
		DriverMobile.getDriverIOS().rotate(rotacaoDoAparelho);
	}
	
	default void rotacionarTela(ScreenOrientation orientacaoDaTela) {
		DriverMobile.getDriverIOS().rotate(orientacaoDaTela);
	}
	
	default void ligarModoAviao() {
		NetworkConnection mobileDriver = (NetworkConnection) DriverMobile.getDriverIOS();
		mobileDriver.setNetworkConnection(ConnectionType.AIRPLANE_MODE);
	}

	default void ligarWifi() {
		NetworkConnection mobileDriver = (NetworkConnection) DriverMobile.getDriverIOS();
		mobileDriver.setNetworkConnection(ConnectionType.WIFI);
	}
	
	default void desligarWifiEModoAviaoERedesDeDados() {
		NetworkConnection mobileDriver = (NetworkConnection) DriverMobile.getDriverIOS();
		mobileDriver.setNetworkConnection(ConnectionType.NONE);
	}
}