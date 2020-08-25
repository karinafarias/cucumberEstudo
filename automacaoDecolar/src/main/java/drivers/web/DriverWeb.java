package drivers.web;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import enums.Browser;
import interfaces.log.ILog;

public class DriverWeb {
	
	private static WebDriver driver = null;
	private static boolean maximizarJanela = true;
	private static String navegador = Browser.CHROME.toString();
	private static String caminhoDriver = System.getProperties().getProperty("pathDriver");
	private static String executarSemInterface = System.getProperties().getProperty("headless");
	private static String browserSetadoViaPrompt = System.getProperties().getProperty("browser");
	private static ChromeOptions chromeOptions = new ChromeOptions();
	private static FirefoxOptions firefoxOptions = new FirefoxOptions();
	private static InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();

	public static WebDriver getDriver() { return driver; }

	public static WebDriver getDriver(Browser navegadorDeExecucao, String caminhoDoDriver, boolean maximizarJanelaDoNavegador, boolean executarSemInterfaceGrafica) {
		validarCaminhoWebDriver(caminhoDoDriver);
		definirPropriedadesIniciais(navegadorDeExecucao, maximizarJanelaDoNavegador, executarSemInterfaceGrafica);
		if (driver == null) setarConfiguracoesDoDriver();
		maximizarJanela();
		return driver;
	}
	
	private static void validarCaminhoWebDriver(String caminhoDoDriver) {
		if (caminhoDriver == null && caminhoDoDriver == null) {
			caminhoDriver = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "drivers" + File.separator;
		}else if(caminhoDriver == null && caminhoDoDriver != null) { 
			caminhoDriver = caminhoDoDriver;
		}
	}

	private static void definirPropriedadesIniciais(Browser navegadorDeExecucao, boolean maximizarJanelaDoNavegador, boolean executarSemInterfaceGrafica) {
		navegador = navegadorDeExecucao.toString();
		maximizarJanela = maximizarJanelaDoNavegador;
		executarSemInterface = String.valueOf(executarSemInterfaceGrafica);
	}

	private static void setarConfiguracoesDoDriver() {
		if (browserSetadoViaPrompt != null) {
			navegador = browserSetadoViaPrompt;
			if (browserSetadoViaPrompt.contains(Browser.CHROME.toString()) || browserSetadoViaPrompt.contains(Browser.FIREFOX.toString()) || browserSetadoViaPrompt.contains(Browser.EXPLORER.toString())) {
				configs();
			}
		} else {
			if (navegador.contains(Browser.CHROME.toString()) || navegador.contains(Browser.FIREFOX.toString()) || navegador.contains(Browser.EXPLORER.toString())) {
				configs();
			}
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	private static void configs() { obterDriverEsetarNaPath(); configHeadless(); iniciarNavegador(); }

	private static void obterDriverEsetarNaPath() {
		if (System.getProperty("os.name").toLowerCase().contains("mac")) setarDriverMac();
		else if (System.getProperty("os.name").toLowerCase().contains("windows")) setarDriverWindows();
	    else setarDriverLinux();
	}

	private static void setarDriverMac() {
		if (navegador.contains(Browser.EXPLORER.toString())) System.setProperty("webdriver.ie.driver", "");
		else if (navegador.contains(Browser.CHROME.toString())) System.setProperty("webdriver.chrome.driver", "");
		else if (navegador.contains(Browser.FIREFOX.toString())) System.setProperty("webdriver.gecko.driver", "");
	}
	
	private static void setarDriverWindows() {
		if (navegador.contains(Browser.EXPLORER.toString())) System.setProperty("webdriver.ie.driver", caminhoDriver + "explorer.exe");
		else if (navegador.contains(Browser.CHROME.toString())) System.setProperty("webdriver.chrome.driver", caminhoDriver + "chromedriver.exe");
		else if (navegador.contains(Browser.FIREFOX.toString())) System.setProperty("webdriver.gecko.driver", caminhoDriver + "geckodriver.exe");
	}

	private static void setarDriverLinux() {
		if (navegador.contains(Browser.EXPLORER.toString())) System.setProperty("webdriver.ie.driver", caminhoDriver + "explorer");
		else if (navegador.contains(Browser.CHROME.toString())) System.setProperty("webdriver.chrome.driver", caminhoDriver + "chromedriver");
		else if (navegador.contains(Browser.FIREFOX.toString())) System.setProperty("webdriver.gecko.driver", caminhoDriver + "geckodriver");
	}

	private static void iniciarNavegador() {
		if (navegador.contains(Browser.EXPLORER.toString())) iniciarExplorer();
		else if (navegador.contains(Browser.CHROME.toString())) iniciarChrome();
		else if (navegador.contains(Browser.FIREFOX.toString())) iniciarFirefox();
	}

	private static void iniciarExplorer() { driver = (internetExplorerOptions != null) ? new InternetExplorerDriver(internetExplorerOptions) : new InternetExplorerDriver(); }

	private static void iniciarChrome() { 
		try{
			driver  = (chromeOptions != null) ? new ChromeDriver(chromeOptions) : new ChromeDriver();
		}catch(IllegalStateException e) {
			ILog.logAutomacaoError("ERRO: o driver não é um arquivo executável. Provavelmente você está em um Linux, verifique se o arquivo chromedriver está em estado 'executável'.");
			e.printStackTrace();
		}
	}
	
	private static void iniciarFirefox() { driver = (firefoxOptions != null) ? new FirefoxDriver(firefoxOptions) : new FirefoxDriver(); }

	private static void maximizarJanela() { if (maximizarJanela) driver.manage().window().maximize(); }

	private static void configHeadless() {
		if (executarSemInterface != null && executarSemInterface == "true") {
			if (navegador.contains(Browser.FIREFOX.toString())) {
				firefoxOptions.setHeadless(true);
				firefoxOptions.addArguments("window-size=1920,1080");
			} else if (navegador.contains(Browser.CHROME.toString())) {
				chromeOptions.setHeadless(true);
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("window-size=1920,1080");
			} else if (navegador.contains(Browser.EXPLORER.toString())) {
				ILog.logAutomacaoError("---- O navegador Internet Explorer não suporta o modo headless");
			}
		}
	}

	public static void FinalizarDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}