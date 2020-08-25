package interfaces.mobile.android;

import java.util.Set;

import drivers.mobile.DriverMobile;
import io.appium.java_client.android.Activity;

public interface IAcoesAPP {

	default void fecharApp() {
		DriverMobile.getDriverAndroid().closeApp();
	}

	default void removerApp(String bundleId) {
		DriverMobile.getDriverAndroid().removeApp(bundleId);
	}

	default void resetarApp() {
		DriverMobile.getDriverAndroid().resetApp();
	}

	default void abrirApp() {
		DriverMobile.getDriverAndroid().launchApp();
	}

	default void obterActivityCorrente() {
		DriverMobile.getDriverAndroid().currentActivity();
	}

	default void iniciarActivity(String nomePacote, String nomeActivity) {
		Activity activity = new Activity(nomePacote, nomeActivity);
		DriverMobile.getDriverAndroid().startActivity(activity);
	}

	default void terminarApp(String idDoApp) {
		DriverMobile.getDriverAndroid().terminateApp(idDoApp);
	}

	default String obterContexto() {
		return DriverMobile.getDriverAndroid().getContext();
	}

	default void mudarContextoParaNativo() {
		Set<String> allContext = DriverMobile.getDriverAndroid().getContextHandles();
		for (String context : allContext) {
			if (context.contains("NATIVE"))
				DriverMobile.getDriverAndroid().context(context);
		}
	}

	default void mudarContextoParaWeb() {
		Set<String> allContext = DriverMobile.getDriverAndroid().getContextHandles();
		for (String context : allContext) {
			if (!context.contains("NATIVE"))
				DriverMobile.getDriverAndroid().context(context);
		}
	}
}