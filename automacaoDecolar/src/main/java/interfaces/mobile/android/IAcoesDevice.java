package interfaces.mobile.android;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;

import drivers.mobile.DriverMobile;
import enums.ContextoMobile;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.GsmCallActions;
import io.appium.java_client.remote.MobileCapabilityType;

public interface IAcoesDevice {

	default int obterLarguraDispositivo() {
		return DriverMobile.getDriverAndroid().manage().window().getSize().getWidth();	
	}
	
	default int obterAlturaDispositivo() {
		return DriverMobile.getDriverAndroid().manage().window().getSize().getHeight();	
	}
	
	default void rotacionarAparelho(DeviceRotation rotacaoDoAparelho) {
		DriverMobile.getDriverAndroid().rotate(rotacaoDoAparelho);
	}

	default void rotacionarTela(ScreenOrientation orientacaoDaTela) {
		DriverMobile.getDriverAndroid().rotate(orientacaoDaTela);
	}

	default void esconderTeclado() {
		if (DriverMobile.getDriverAndroid().isKeyboardShown()) {
			DriverMobile.getDriverAndroid().hideKeyboard();
		}
	}
	
	default void abrirBarraNotificacoes() {
		DriverMobile.getDriverAndroid().openNotifications();
	}
	
	default void abrirActivity(Activity activity) {
		DriverMobile.getDriverAndroid().startActivity(activity);
	}
	
	default void iniciarGravacaoDaTela() {
		DriverMobile.getDriverAndroid().startRecordingScreen();
	}
		
	default void pararGravacaoDaTela() {
		DriverMobile.getDriverAndroid().stopRecordingScreen();
	}

	default void ligarModoAviao() {
		NetworkConnection mobileDriver = (NetworkConnection) DriverMobile.getDriverAndroid();
		mobileDriver.setNetworkConnection(ConnectionType.AIRPLANE_MODE);
	}

	default void ligarWifi() {
		NetworkConnection mobileDriver = (NetworkConnection) DriverMobile.getDriverAndroid();
		mobileDriver.setNetworkConnection(ConnectionType.WIFI);
	}
	
	default void desligarWifiEModoAviaoERedesDeDados() {
		NetworkConnection mobileDriver = (NetworkConnection) DriverMobile.getDriverAndroid();
		mobileDriver.setNetworkConnection(ConnectionType.NONE);
	}
	
	default void ligarWifiERedeDeDados() {
		NetworkConnection mobileDriver = (NetworkConnection) DriverMobile.getDriverAndroid();
		mobileDriver.setNetworkConnection(ConnectionType.ALL);
	}
	
	default void desbloquearDevice() {
		DriverMobile.getDriverAndroid().unlockDevice();
	}

	default void obterInformacoesDaBateria() {
		DriverMobile.getDriverAndroid().getBatteryInfo();
	}
	
	default void obterOrientacaoDaTela() {
		DriverMobile.getDriverAndroid().getOrientation();
	}
	
	default void validarSeTecladoEstaVisivel() {
		DriverMobile.getDriverAndroid().isKeyboardShown();
	}
	
	default void bloquearDevice() {
		DriverMobile.getDriverAndroid().lockDevice();
	}
	
	default void fazerChamadaGsm(String telefone, GsmCallActions acaoDaChamada) {
		DriverMobile.getDriverAndroid().makeGsmCall(telefone, acaoDaChamada);
	}
	
	default void enviarSMS(String telefone, String mensagem) {
		DriverMobile.getDriverAndroid().sendSMS(telefone, mensagem);
	}
	
	default void definirLocalizacaoDoDevice(double latitude, double longitude, double altitude) {
		Location location = new Location(latitude, longitude, altitude);
		DriverMobile.getDriverAndroid().setLocation(location);
	}
	
	default void mudarContextoParaNativeAPP() {
		DriverMobile.getDriverAndroid().context(ContextoMobile.NATIVE_APP.toString());
	}
	
	default void mudarContextoDaAutomacao(ContextoMobile contexto) {
		DriverMobile.getDriverAndroid().context(contexto.toString());
	}
	
	default String obterVersao() {
		return DriverMobile.getDriverAndroid().getCapabilities().getCapability(MobileCapabilityType.PLATFORM_VERSION).toString();
	}
}