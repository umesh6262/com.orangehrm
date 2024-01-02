package factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	private DriverFactory() {}

	@SuppressWarnings("deprecation")
	public static WebDriver getDriver(String browserName) throws MalformedURLException {
		WebDriver driver;
		
		if(browserName.equalsIgnoreCase("chrome")) {
			//capabilities
			//{"browserName":"chrome","browserVersion":"120.0","goog:chromeOptions":{"binary":"/usr/bin/google-chrome"}, "platformName":"linux","se:noVncPort":7900,"se:vncEnabled":true}
			DesiredCapabilities dc= new DesiredCapabilities();
			dc.setCapability("browserName", "chrome");
//			dc.setCapability("browserVersion", "120.0");
			dc.setCapability("platformName", "linux");
			driver = new RemoteWebDriver(new URL("http://admin:admin@localhost:4444"), dc);

//			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//{"browserName":"firefox","browserVersion":"120.0","moz:firefoxOptions":{"binary":"/usr/bin/firefox"},"platformName":"linux","se:noVncPort":7900,"se:vncEnabled":true}
			DesiredCapabilities dc= new DesiredCapabilities();
			dc.setCapability("browserName", "firefox");
//			dc.setCapability("browserVersion", "120.0");
			dc.setCapability("platformName", "linux");
			driver = new RemoteWebDriver(new URL("http://admin:admin@localhost:4444"), dc);

//			driver =  new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			DesiredCapabilities dc= new DesiredCapabilities();
			dc.setCapability("browserName", "MicrosoftEdge");
//			dc.setCapability("browserVersion", "120.0");
			dc.setCapability("platformName", "linux");
			driver = new RemoteWebDriver(new URL("http://admin:admin@localhost:4444"), dc);

//			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();
		}
		else {
			throw new IllegalArgumentException();
		}
		//			return driver;
		return driver;
	}
}
