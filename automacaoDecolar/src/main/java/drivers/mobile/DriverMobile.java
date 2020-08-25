package drivers.mobile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import drivers.mobile.appium.ServiceAppium;
import enums.TipoOS;
import enums.TipoRetorno;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import planilha.Planilha;

public class DriverMobile {

	private static AndroidDriver<?> driverAndroid = null;
	private static IOSDriver<?> driverIOS = null;
	private static DesiredCapabilities capabilities = null;
	
	
	
	public static void iniciarAndroid(String identificadorSetadoNaPlanilhaDeTestes, boolean nativo, String caminhoDoNodeJs) throws MalformedURLException, Exception {
			iniciarDriverAndroid(identificadorSetadoNaPlanilhaDeTestes, nativo, caminhoDoNodeJs);
			validarContexto(nativo, driverAndroid);
			driverAndroid.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void iniciarAndroidWeb(String identificadorSetadoNaPlanilhaDeTestes, String caminhoDoNodeJs) throws MalformedURLException, Exception {
			iniciarDriverAndroidWeb(identificadorSetadoNaPlanilhaDeTestes, caminhoDoNodeJs);
			driverAndroid.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void iniciarIOS(String identificadorSetadoNaPlanilhaDeTestes, boolean nativo, String caminhoDoNodeJs) throws MalformedURLException, Exception {
			iniciarDriverIOS(identificadorSetadoNaPlanilhaDeTestes, nativo, caminhoDoNodeJs);
			validarContexto(nativo, driverIOS);
			driverIOS.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void iniciarAndroid(DesiredCapabilities capabilities, boolean nativo, String caminhoDoNodeJs) throws MalformedURLException, Exception {
			iniciarDriverAndroid(capabilities, nativo, caminhoDoNodeJs);
			validarContexto(nativo, driverAndroid);
			driverAndroid.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void iniciarIOS(DesiredCapabilities capabilities, boolean nativo, String caminhoDoNodeJs) throws MalformedURLException, Exception {
			iniciarDriverIOS(capabilities, nativo, caminhoDoNodeJs);
			validarContexto(nativo, driverIOS);
			driverIOS.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static IOSDriver<?> getDriverIOS() {
		return driverIOS;
	}

	public static AndroidDriver<?> getDriverAndroid() {
		return driverAndroid;
	}

	public static void FinalizarDriver() {
		if (driverAndroid != null) {
			driverAndroid.quit();
			driverAndroid = null;
		} else if (driverIOS != null) {
			driverIOS.quit();
			driverIOS = null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	private static void iniciarDriverAndroid(String identificadorSetadoNaPlanilhaDeTestes, boolean nativo, String caminhoDoNodeJs) throws MalformedURLException, Exception {
		ServiceAppium serv = new ServiceAppium();
		driverAndroid = new AndroidDriver(serv.startAppiumServer(caminhoDoNodeJs), definirCapabilitiesAndroid(identificadorSetadoNaPlanilhaDeTestes, nativo));
	}
	
	@SuppressWarnings("rawtypes")
	private static void iniciarDriverAndroidWeb(String identificadorSetadoNaPlanilhaDeTestes, String caminhoDoNodeJs) throws MalformedURLException, Exception {
		ServiceAppium serv = new ServiceAppium();
		driverAndroid = new AndroidDriver(serv.startAppiumServer(caminhoDoNodeJs), definirCapabilitiesAndroidWeb(identificadorSetadoNaPlanilhaDeTestes));
	}
	
	@SuppressWarnings("rawtypes")
	private static void iniciarDriverAndroid(DesiredCapabilities capabilities, boolean nativo, String caminhoDoNodeJs) throws MalformedURLException, Exception {
		ServiceAppium serv = new ServiceAppium();	
		driverAndroid = new AndroidDriver(serv.startAppiumServer(caminhoDoNodeJs), definirCapabilitiesAndroid(capabilities, nativo));
	}
	
	@SuppressWarnings("rawtypes")
	private static void iniciarDriverIOS(String identificadorSetadoNaPlanilhaDeTestes, boolean nativo, String caminhoDoNodeJs) throws MalformedURLException, Exception {
		ServiceAppium serv = new ServiceAppium();
		driverIOS = new IOSDriver(serv.startAppiumServer(caminhoDoNodeJs), definirCapabilitesIOS(identificadorSetadoNaPlanilhaDeTestes, nativo));
	}
	
	@SuppressWarnings("rawtypes")
	private static void iniciarDriverIOS(DesiredCapabilities capabilities, boolean nativo, String caminhoDoNodeJs) throws MalformedURLException, Exception {
		ServiceAppium serv = new ServiceAppium();	
		driverIOS = new IOSDriver(serv.startAppiumServer(caminhoDoNodeJs), definirCapabilitesIOS(capabilities, nativo));
	}
	
	@SuppressWarnings("rawtypes")
	private static void validarContexto(boolean nativo, AppiumDriver driver) {
		if (!nativo) driver.context("WEBVIEW");
	}
	
	private static DesiredCapabilities definirCapabilitiesAndroidWeb(String identificadorSetadoNaPlanilhaDeTestes) throws IOException {
		Planilha planilha = new Planilha();
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("setWebContentsDebuggingEnabled", "true");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TipoOS.ANDROID);
		capabilities.setCapability("udid", planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.DEVICEID));
		capabilities.setCapability(MobileCapabilityType.HAS_TOUCHSCREEN, true);
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.DEVICENAME));
		
		if(planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.VERSAODOSO).startsWith("8")) { 
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); 
			capabilities.setCapability("systemPort", planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.SYSTEMPORT));
		}
		return capabilities;
	}
	
	private static DesiredCapabilities definirCapabilitiesAndroid(String identificadorSetadoNaPlanilhaDeTestes, boolean nativo) throws IOException {
		Planilha planilha = new Planilha();
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("setWebContentsDebuggingEnabled", "true");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TipoOS.ANDROID);
		capabilities.setCapability("udid", planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.DEVICEID));
		capabilities.setCapability(MobileCapabilityType.APP, new File("src" + File.separator + "test" + File.separator + "resources" + File.separator + "armazenador" + File.separator  +  planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.NOMEAPK)).getCanonicalPath());
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.DEVICENAME));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.VERSAODOSO));
		
		if (!nativo) {	capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true); }
		
		if(planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.VERSAODOSO).startsWith("8")) { 
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); 
			capabilities.setCapability("systemPort", planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.SYSTEMPORT));}
		if (planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.APPWAITACTIVITY) != null || !planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.APPWAITACTIVITY).matches(" ") || planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.APPWAITACTIVITY).matches("")) {
			capabilities.setCapability("appWaitActivity", planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.APPWAITACTIVITY));
		}
		return capabilities;
	}
	
	private static DesiredCapabilities definirCapabilitesIOS(String identificadorSetadoNaPlanilhaDeTestes, boolean nativo) throws IOException {
		Planilha planilha = new Planilha();
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TipoOS.IOS);
		capabilities.setCapability(MobileCapabilityType.APP, new File("src" + File.separator + "test" + File.separator + "resources" + File.separator + "armazenador" + File.separator  +  planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.NOMEAPK)).getCanonicalPath());
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.DEVICEID));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.VERSAODOSO));
	
		if (!nativo) {	capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true); }

		if (planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.APPWAITACTIVITY) != null || !planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.APPWAITACTIVITY).matches(" ") || planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.APPWAITACTIVITY).matches("")) {
				capabilities.setCapability("appWaitActivity", planilha.retornarElementoDaPlanilha(identificadorSetadoNaPlanilhaDeTestes, TipoRetorno.APPWAITACTIVITY));
		}
		return capabilities;
	}
	
	private static DesiredCapabilities definirCapabilitesIOS(DesiredCapabilities desiredCapabilities, boolean nativo) {
		capabilities = new DesiredCapabilities(desiredCapabilities);
		if (!nativo) {	capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true); }
		return capabilities;
	}
	
	private static DesiredCapabilities definirCapabilitiesAndroid(DesiredCapabilities desiredCapabilities, boolean nativo) {
		capabilities = new DesiredCapabilities(desiredCapabilities);
		if (!nativo) {	capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true); }
		return capabilities;
	}
}