package org.asanka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import orag.asanka.utils.UIElementparms;

public class EmployeeListPage {
    WebDriver driver;

    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
        // Check that we're on the right page.
        if (!(driver.getCurrentUrl().contains("index.php/pim/viewEmployeeList"))) {
            throw new IllegalStateException("This is not the correct EmployeeListPage page");
        }
    }
    
    
    /**
     * Provide facility to delete added user in test run
     */
    public void deleteAddedEmployee(){
    	
        if (!driver.findElement(By.id(UIElementparms.EMPLOYEELIST_CHECKBOX_ID)).isSelected()){       
        	driver.findElement(By.id(UIElementparms.EMPLOYEELIST_CHECKBOX_ID)).click();
        }
        driver.findElement(By.id(UIElementparms.EMPLOYEELIST_DELETEBTN_ID)).click();
        
        String dialog=driver.getWindowHandle();
        driver.switchTo().window(dialog);
        driver.findElement(By.id(UIElementparms.EMPLOYEELIST_OKBTN_ID)).click();

    }
    
}
