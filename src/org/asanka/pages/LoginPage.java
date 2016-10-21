package org.asanka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import orag.asanka.utils.UIElementparms;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
    	this.driver=driver;
        // Check that we're on the right page.
        if (!(driver.getCurrentUrl().contains("index.php/auth/login"))) {
        	throw new IllegalStateException("This is not the correct login page");
        }
    }

    
    /**
     * Provide facility to log into the Orange HRM App
     *
     * @param userName login user name
     * @param password login password
     * @return boolean value according to the login status
     */
    public boolean loginToOrangeHRM(final String userName, final String password){

    	WebElement userNameField = driver.findElement(By.id(UIElementparms.LOGIN_USERNAME_ID));
        WebElement passwordField = driver.findElement(By.id(UIElementparms.LOGIN_PASSWORD_ID));
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        driver.findElement(By.id(UIElementparms.LOGIN_LOGINBTN_ID)).click();
        
        if(driver.findElements(By.id(UIElementparms.LOGIN_ERROR_ID)).size()>0){
        	Assert.assertEquals(driver.findElement(By.id(UIElementparms.LOGIN_ERROR_ID)).getText(),"Account disabled");
        	return false;
        	
        }
        
        return true;
    }


}
