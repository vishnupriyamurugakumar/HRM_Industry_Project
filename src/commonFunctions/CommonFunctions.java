package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {
	
	public static Properties properties;
	public static WebDriver driver;
	static String browser;
	static String driverLocation;
	static String url;
	Logger logger = Logger.getLogger(CommonFunctions.class);
	
	public Properties readConfigFile() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		properties= new Properties();
		properties.load(fileInputStream);
		return properties;
	}
	
	public void getConfigDetails() {
		browser = properties.getProperty("browser");
		driverLocation = properties.getProperty("driverlocation");
		url = properties.getProperty("url");
	}
	
	@BeforeSuite
	public void launchBrowser() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		readConfigFile();
		getConfigDetails();
		logger.info("HRM Test Begins....");
		if(browser.equalsIgnoreCase("chrome")) {
			logger.info("Launching Chrome Browser!!!");
			System.setProperty("webdriver.chrome.driver",driverLocation);
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			logger.info("Launching FireFox Browser!!!");
			System.setProperty("webdriver.gecko.driver",driverLocation);
			driver = new FirefoxDriver();
		}else {
			logger.info("Mentioned Browser is not available, Launching Default Browser!!!");
			System.setProperty("webdriver.chrome.driver",driverLocation);
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		logger.info("Launching Application Login Page");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void closeBrowser() {
		logger.info("End of HRM Test");
		logger.info("Closing Browser");
		driver.quit();
	}
}
