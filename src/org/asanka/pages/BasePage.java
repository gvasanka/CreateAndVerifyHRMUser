package org.asanka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import orag.asanka.utils.UIElementparms;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Provide facility to load Add Employee page
     * @return reference to AddEmployeePage page
     */

    public AddEmployeePage loadAddEmployeePage() {
    	driver.findElement(By.id(UIElementparms.BASE_MAINMENU_PIM_ID)).click();
        driver.findElement(By.id(UIElementparms.BASE_PIM_ADDEMPLOYEE_ID)).click();            
        return new AddEmployeePage(driver);
    }
    
    /**
     * Provide facility to load UserManagementPage page
     * @return reference to UserManagementPage page
     */

    public UserManagementPage loadAdminUserManagenetPage() {

        driver.findElement(By.id(UIElementparms.BASE_MAINMENU_ADMIN_ID)).click();  
        driver.findElement(By.id(UIElementparms.BASE_ADMIN_USERMANEGMENT_ID)).click(); 
        if(driver.findElements(By.xpath(UIElementparms.USERMANAGEMENT_SYSTEMUSERINFO_XPATH)).size()>0){
        	Assert.assertEquals(driver.findElement(By.xpath(UIElementparms.
        			USERMANAGEMENT_SYSTEMUSERINFO_XPATH)).getText(), "System Users","Table heading content invalid");
        }
       return new UserManagementPage(driver);
    }
    
    /**
     * Provide facility to load EmployeeListPage page
     * @return reference to EmployeeListPage page
     */
    
    public EmployeeListPage loadEmployeeListPage(){
    	driver.findElement(By.id(UIElementparms.BASE_MAINMENU_PIM_ID)).click();
    	driver.findElement(By.id(UIElementparms.BASE_PIM_EMPLOYEELIST_ID)).click();
    	
    	return new EmployeeListPage(driver);
    }
    
    /**
     * Provide facility to logout from OrangeHRM APP
     * @return reference to Login page
     */
    
    public LoginPage logoutFromOrangeHRM(){
        driver.findElement(By.id(UIElementparms.LOGOUT_WELCOME_ID)).click();
        if(driver.findElements(By.linkText(UIElementparms.LOGOUT_LOGOUT_LINK)).size()>0 ){
        	
        }
        driver.findElement(By.linkText(UIElementparms.LOGOUT_LOGOUT_LINK)).click();
        return new LoginPage(driver);
        
    }
}
