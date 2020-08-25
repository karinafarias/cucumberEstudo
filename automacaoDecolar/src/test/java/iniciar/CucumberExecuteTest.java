package iniciar;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;

import com.paulhammant.ngwebdriver.NgWebDriver;

import annotations.ExtendedCucumberRunner;
import cucumber.api.CucumberOptions;
import drivers.web.DriverWeb;
import enums.Browser;

@RunWith(ExtendedCucumberRunner.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {
		"json:src/test/resources/json/Resultado.json" }, glue = { "" }, monochrome = true, dryRun = false, strict = false,
				tags= "")
public class CucumberExecuteTest {

	@BeforeClass
	public static void setarConfiguracoes() {
		DriverWeb.getDriver(Browser.CHROME, null, true, false);
		NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) DriverWeb.getDriver());
		ngWebDriver.waitForAngularRequestsToFinish();

}
}