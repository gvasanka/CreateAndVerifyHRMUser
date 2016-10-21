package org.asanka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserManagementPage {
    WebDriver driver;

    public UserManagementPage(WebDriver driver) {
    	this.driver=driver;
    }
    
    /**
     * Provide facility to select employee need to update
     * @return reference to EditUserPage
     */
    public EditUserPage updateEmpStatus(String username) {
    	driver.findElement(By.linkText(username)).click(); 	 	
        return new EditUserPage(driver);
    }

    

}
