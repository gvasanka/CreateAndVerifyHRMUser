package org.asanka.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import orag.asanka.utils.OrangeHRMBaseTest;
import org.asanka.pages.AddEmployeePage;
import org.asanka.pages.EditUserPage;
import org.asanka.pages.EmployeeListPage;
import org.asanka.pages.LoginPage;
import org.asanka.pages.PersonalDetailsPage;
import org.asanka.pages.UserManagementPage;



public class EmployeerCreationTestCase extends OrangeHRMBaseTest {
	LoginPage loginPage;
	String adminUserName="AdminOH";
	String adminPassword="adminoh";
	
  @BeforeClass()
  public void init(){
	  super.init(); 
	  driver.get(this.getLoginURL());
	  driver.manage().window().maximize();
  }
	
 @Test()
  public void loginTest() {
	  
	  Assert.assertEquals("OrangeHRM", driver.getTitle());
	  loginPage=new LoginPage(driver);
	  loginPage.loginToOrangeHRM(adminUserName, adminPassword); 	  
  }
 
 @Test(dependsOnMethods="loginTest")
 @Parameters({"firstname","lastname","username","password","repassword"})
 public void addEmployee(String firstname,String lastname,String username, String password,String repassword){
	 AddEmployeePage addEmployeePage=basePage.loadAddEmployeePage();
	  PersonalDetailsPage personalDetailsPage=addEmployeePage.addNewEmployee(firstname, lastname,username,password,repassword);
	  personalDetailsPage.viewPersonalDetails(firstname, lastname);
	  basePage.logoutFromOrangeHRM();	 
 }
 
 @Test(dependsOnMethods="addEmployee")
 @Parameters({"username","password"})
 public void loginWithNewEmployeeCredentials(String username, String password){	 
	if(!loginPage.loginToOrangeHRM(username, password)){
		loginPage.loginToOrangeHRM(adminUserName, adminPassword); 
	}
 }
 
 @Test(dependsOnMethods="loginWithNewEmployeeCredentials")
 @Parameters("username")
 public void updteNewEmployeeStatus(String username){
	 UserManagementPage userManagementPage=basePage.loadAdminUserManagenetPage();
	 EditUserPage editUserPage=userManagementPage.updateEmpStatus(username);
	 userManagementPage=editUserPage.editUserDetails();
	 basePage.logoutFromOrangeHRM();	 
 }
 
 @Test(dependsOnMethods="updteNewEmployeeStatus")
 @Parameters({"username","password"})
 public void loginbackWithNewEmployeeCredentials(String username, String password){	 
	 loginPage.loginToOrangeHRM(username, password);
 }
 
  
  @AfterClass()
  public void teardown(){
	  driver.get(this.getLoginURL());
	  new LoginPage(driver).loginToOrangeHRM(adminUserName,adminPassword);
	  EmployeeListPage employeeListPage=basePage.loadEmployeeListPage();
	  employeeListPage.deleteAddedEmployee();
	  basePage.logoutFromOrangeHRM();
	 
	  if(driver!=null){
		 driver.quit();
	  }
  }
  
}
