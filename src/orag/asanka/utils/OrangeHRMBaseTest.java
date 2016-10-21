package orag.asanka.utils;

import org.asanka.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class OrangeHRMBaseTest {

    protected WebDriver driver;
    protected BasePage basePage;

    protected void init(){
        this.driver=BrowserManager.getWebDriver(PropertyMapper.getInstance().getElement("defaultBrowser"));
        this.basePage=new BasePage(driver);
    }
    /**
     * Gets the default login url for OrangeHRM App.
     * @return The URL.
     */
    protected String getLoginURL()  {
        return PropertyMapper.getInstance().getElement("orangeHRMBaseURL");
    }
}
