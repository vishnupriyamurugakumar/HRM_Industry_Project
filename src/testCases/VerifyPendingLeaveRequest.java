package testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonFunctions.CommonFunctions;
import pageObjects.DashboardPageObjects;
import pageObjects.LoginPageObjects;


public class VerifyPendingLeaveRequest extends CommonFunctions{

	Logger logger = Logger.getLogger(CommonFunctions.class);
	
	public void loginApplication() {
		PageFactory.initElements(driver, LoginPageObjects.class);
		logger.info("Login into application...");
		LoginPageObjects.userName.sendKeys(properties.getProperty("username"));
		LoginPageObjects.passWord.sendKeys(properties.getProperty("password"));
		LoginPageObjects.loginButton.click();
	}

	@Test
	public void verifyPendingLeaveRequests() {
		PropertyConfigurator.configure("log4j.properties");
		loginApplication();
		logger.info("Verify Pending LeaveRequests Test starts");
		PageFactory.initElements(driver, DashboardPageObjects.class);
		String pendingLeaveRequestValues = DashboardPageObjects.pendingLeaveRequest.getText();
		Assert.assertNotEquals(pendingLeaveRequestValues, "No Records are Available");
		logger.info("End of Verify Pending LeaveRequests Testcase");
	}
}
