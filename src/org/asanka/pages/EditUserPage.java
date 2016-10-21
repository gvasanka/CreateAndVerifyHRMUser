package org.asanka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import orag.asanka.utils.UIElementparms;

public class EditUserPage {
    WebDriver driver;

    public EditUserPage(WebDriver driver) {
    	this.driver=driver;
        // Check that we're on the right page.
        if (!(driver.getCurrentUrl().contains("index.php/admin/saveSystemUser"))) {
        	throw new IllegalStateException("This is not the correct EditUserPage");
        }
    }

    public UserManagementPage editUserDetails() {
		
		  if(driver.findElements(By.id(UIElementparms.EDITUSER_HEADINGTEXT_ID)).size()>0){
	        	Assert.assertEquals(driver.findElement(By.id(UIElementparms.
	        			EDITUSER_HEADINGTEXT_ID)).getText(),"Edit User","Page heading content invalid");
	        }
		  String status=new Select(driver.findElement(By.id(UIElementparms.
				  EDITUSER_STATUS_ID))).getFirstSelectedOption().getText();
		  Assert.assertEquals(status,"Disabled","Invalid status setting");
		  
		  driver.findElement(By.id(UIElementparms.EDITUSER_SAVEBTN_ID)).click();
		  Select select=new Select(driver.findElement(By.id(UIElementparms.EDITUSER_STATUS_ID)));
      	  select.selectByVisibleText("Enabled");
      	  driver.findElement(By.id(UIElementparms.EDITUSER_SAVEBTN_ID)).click();
      	  status=new Select(driver.findElement(By.id(UIElementparms.
      			  EDITUSER_STATUS_ID))).getFirstSelectedOption().getText();
		  Assert.assertEquals(status,"Enabled","Invalid status setting");
		  
		  return new UserManagementPage(driver);
	}

}
