package org.asanka.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import orag.asanka.utils.UIElementparms;

public class PersonalDetailsPage {
    WebDriver driver;

    public PersonalDetailsPage(WebDriver driver) {
        this.driver = driver;
        // Check that we're on the right page.
        if (!(driver.getCurrentUrl().contains("index.php/pim/viewPersonalDetails"))) {
            throw new IllegalStateException("This is not the viewPersonalDetails page");
        }
    }

    /**
     * Provide facility to viewPersonalDetails
     * 
     */
    public void viewPersonalDetails(String firstName, String lastName) {
    	
    	String actualFirstName=driver.findElement(By.id(UIElementparms.PERSONALDETAILS_FIRSTNAME_ID)).getAttribute("value");
    	Assert.assertEquals(actualFirstName, firstName,"Invalid personal details");
    	
    	String actualLastName=driver.findElement(By.id(UIElementparms.PERSONALDETAILS_LASTNAME_ID)).getAttribute("value");
    	Assert.assertEquals(actualLastName, lastName,"Invalid personal details");
    }
}
