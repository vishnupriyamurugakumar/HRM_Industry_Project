package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.UsersPageObjects;


public class CheckUserRoleAndStatus extends CommonFunctions{
	
	Logger logger = Logger.getLogger(CommonFunctions.class);

	public void moveToUsers() {
		
		PageFactory.initElements(driver, UsersPageObjects.class);
		UsersPageObjects.admin.click();
		
//		**** Another way
//		Actions action = new Actions(driver);
//		action.moveToElement(UsersPageObjects.admin);
//		action.moveToElement(UsersPageObjects.userManagement);
//		action.moveToElement(UsersPageObjects.users);
//		UsersPageObjects.users.click();	
		
		logger.info("Moving to Users...");
	}

	public void selectRoleStatus() {
		logger.info("Selecting Role and status...");
		Select select = new Select(UsersPageObjects.userRole);
		select.selectByIndex(1);
		Select select1 = new Select(UsersPageObjects.status);
		select1.selectByIndex(1);
		UsersPageObjects.search.click();
		logger.info("searching based on Role and status...");
		
	}
	
	@Test
	public void checkUserRoleAndStatus() {
		PropertyConfigurator.configure("log4j.properties");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		moveToUsers();
		selectRoleStatus();
		logger.info("Check User Role And Status Starts...");
		String userRoleValue = UsersPageObjects.userRoleForUser.getText();
		String statusValue= UsersPageObjects.statusForUser.getText();
		Assert.assertEquals(userRoleValue, "Admin");
		Assert.assertEquals(statusValue, "Enabled");
		logger.info("End of CheckUserRoleAndStatus Testcase");
	}
}
