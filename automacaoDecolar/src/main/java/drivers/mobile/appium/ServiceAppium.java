package drivers.mobile.appium;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ServiceAppium {

	AppiumDriverLocalService appiumService;
		
	public URL startAppiumServer(String caminhoDoNodeJs) throws IOException {
		String osName = System.getProperty("os.name");
		if (osName.contains("Mac")) {
			appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File("/usr/local/bin/node"))
					.withIPAddress("127.0.0.1").usingAnyFreePort()
					.withArgument(GeneralServerFlag.SESSION_OVERRIDE));
			appiumService.start();
		} else if (osName.contains("Windows")) {
			appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File(caminhoDoNodeJs))
					.withIPAddress("127.0.0.1").usingAnyFreePort()
					.withArgument(GeneralServerFlag.SESSION_OVERRIDE));
			appiumService.start();
		}
		appiumService.start();
		
		return appiumService.getUrl();
	}
}
