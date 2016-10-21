package org.asanka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import orag.asanka.utils.UIElementparms;

public class AddEmployeePage {
    WebDriver driver;

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        // Check that we're on the right page.
        if (!(driver.getCurrentUrl().contains("index.php/pim/addEmployee"))) {
            throw new IllegalStateException("This is not the PIM page");
        }
    }

    /**
     * Provide facility to add new Employee
     *
     * @param firstName employee first name
     * @param lastname employee last name
     * @param username employee user name
     * @param password employee password
     * @param confirmPasword employee confirm password
     * @return reference to PersonalDetailsPage page
     */
    public PersonalDetailsPage addNewEmployee(final String firstName, final String lastName,final String userName,
    		final String password, final String confirmPasword) {

        WebElement firstNameField = driver.findElement(By.id(UIElementparms.ADDEMPLOYEE_FIRSTNAME_ID));
        WebElement lastNameField = driver.findElement(By.id(UIElementparms.ADDEMPLOYEE_LASTNAME_ID));
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);

        if (!driver.findElement(By.id(UIElementparms.ADDEMPLOYEE_CREATELOGIN_ID)).isSelected()){       
        	driver.findElement(By.id(UIElementparms.ADDEMPLOYEE_CREATELOGIN_ID)).click();
        }
        
        boolean isLoginDetailFieldsVisible=driver.findElements(By.id(UIElementparms.ADDEMPLOYEE_USERNAME_ID)).size()>0 &&
        		driver.findElements(By.id(UIElementparms.ADDEMPLOYEE_USERPASSWORD_ID)).size()>0 &&
        				driver.findElements(By.id(UIElementparms.ADDEMPLOYEE_CONFIRMPASSWORD_ID)).size()>0 &&
        				driver.findElements(By.id(UIElementparms.ADDEMPLOYEE_STATUS_ID)).size()>0;
        				
        if(isLoginDetailFieldsVisible){
        	driver.findElement(By.id(UIElementparms.ADDEMPLOYEE_USERNAME_ID)).sendKeys(userName);
        	driver.findElement(By.id(UIElementparms.ADDEMPLOYEE_USERPASSWORD_ID)).sendKeys(password);
        	driver.findElement(By.id(UIElementparms.ADDEMPLOYEE_CONFIRMPASSWORD_ID)).sendKeys(confirmPasword);
        	
        	Select select=new Select(driver.findElement(By.id(UIElementparms.ADDEMPLOYEE_STATUS_ID)));
        	select.selectByVisibleText("Disabled");
        	
        	driver.findElement(By.id(UIElementparms.ADDEMPLOYEE_SAVEBTN_ID)).click();
        	
        }	
      return new PersonalDetailsPage(driver);
    }
}
