package interfaces.mobile.ios;

import drivers.mobile.DriverMobile;

public interface IAcoesAPP {

	default void fecharApp() {
		DriverMobile.getDriverIOS().closeApp();
	}

	default void removerApp(String bundleId) {
		DriverMobile.getDriverIOS().removeApp(bundleId);
	}

	default void resetarApp() {
		DriverMobile.getDriverIOS().resetApp();
	}
}