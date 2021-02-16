package AppHooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.gherkin.model.Scenario;

import Factory.DriverFactory;
import Util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {

	private DriverFactory df;
	private WebDriver driver;
	private ConfigReader reader;
	private Properties prop;

	@Before(order = 0)
	public void getProperty() {
		reader = new ConfigReader();
		prop = reader.init_ReadProperties();
	}

	@Before(order = 1)

	public void launchBrowser() {
		String bname = prop.getProperty("browser");
		df = new DriverFactory();
		df.init_setBrowser(bname);
	}

	@After(order = 0)
	public void closeDriver() {
		//df.logoutfromGmail();
		// driver.quit();
	}

}
