package orag.asanka.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserManager {

	public static WebDriver driver;


    public static WebDriver getWebDriver(String driverSelection)  {
        if (driverSelection.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (driverSelection.equalsIgnoreCase("ie")) {
        	System.setProperty("webdriver.ie.driver", "resources/drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }  else if (driverSelection.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }
    
}
