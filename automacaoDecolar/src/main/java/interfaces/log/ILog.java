package interfaces.log;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public interface ILog {
	static String pathLog = "src" + File.separator + "test" + File.separator + "resources" + File.separator;

	/**
	 * @param step
	 * @param url
	 * @param response
	 */
	default void logGet(String step, Object url, Object response) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure(ILog.pathLog + "conflogs" + File.separator + "logGet.properties");
		Logger.getLogger("").info(step + System.lineSeparator() + "GET: " + url + System.lineSeparator() + "Resultado: "
				+ response + System.lineSeparator());
	}

	/**
	 * @param step
	 * @param url
	 * @param response
	 */
	default void logPut(String step, Object url, Object response) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure(ILog.pathLog + "conflogs/logPut.properties");
		Logger.getLogger("").info(step + System.lineSeparator() + "PUT: " + url + System.lineSeparator() + "Resultado: "
				+ response + System.lineSeparator());
	}
	
	/**
	 * @param step
	 * @param url
	 * @param response
	 */
	static void logAutomacao(String passo) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure(ILog.pathLog + "conflogs/logAutomacao.properties");
		Logger.getLogger("").info( System.lineSeparator() + passo);
	}
	
	/**
	 * @param step
	 * @param url
	 * @param response
	 */
	static void logAutomacaoError(String passo) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure(ILog.pathLog + "conflogs/logAutomacao.properties");
		Logger.getLogger("").error( System.lineSeparator() + passo);
	}

	/**
	 * @param step
	 * @param url
	 * @param response
	 */
	static void logAutomacaoWarn(String passo) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure(ILog.pathLog + "conflogs/logAutomacao.properties");
		Logger.getLogger("").warn( System.lineSeparator() + passo);
	}
	
	/**
	 * @param step
	 * @param url
	 * @param response
	 */
	default void logDelete(String step, Object url, Object response) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure(ILog.pathLog + "conflogs/logDelete.properties");
		Logger.getLogger("").info(step + System.lineSeparator() + "DELETE: " + url + System.lineSeparator()
				+ "Resultado: " + response + System.lineSeparator());
	}

	/**
	 * @param step
	 * @param url
	 * @param response
	 */
	default void logPatch(String step, Object url, Object response) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure(ILog.pathLog + "conflogs/logPatch.properties");
		Logger.getLogger("").info(step + System.lineSeparator() + "PATCH: " + url + System.lineSeparator()
				+ "Resultado: " + response + System.lineSeparator());
	}

	/**
	 * @param step
	 * @param url
	 * @param response
	 */
	default void logPost(String step, Object url, Object response) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure(ILog.pathLog + "conflogs/logPost.properties");
		Logger.getLogger("").info(step + System.lineSeparator() + "POST: " + url + System.lineSeparator()
				+ "Resultado: " + response + System.lineSeparator());
	}
}