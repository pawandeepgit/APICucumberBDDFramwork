package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CommonMethods {

	protected static WebDriver driver;
	public static Properties prop;
	public static FileInputStream ip;

	public CommonMethods() {
		try {
			 prop = new Properties();
			ip = new FileInputStream(
					"C:\\learn\\trainings\\Cucumber-Project\\ConfigProperties\\config.properties");

			prop.load(ip);

		} catch (FileNotFoundException fn) {
			fn.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static WebDriver getBrowser() {
		System.out.println(prop.getProperty("browser"));
		if (prop.getProperty("browser").equalsIgnoreCase("ch")) {
			System.setProperty("webdriver.chrome.driver", "C:\\learn\\tools\\selenium\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\learn\\tools\\selenium\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", "C:\\learn\\tools\\selenium\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		driver.get(prop.getProperty("url"));
		// driver.get("https://skyid.sky.com/signup/skycom/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
return driver;
	}

	protected WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "C:\\learn\\tools\\selenium\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}

}
