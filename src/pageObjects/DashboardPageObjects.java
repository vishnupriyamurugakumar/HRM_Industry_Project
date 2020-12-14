package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageObjects {
	@FindBy(id="dashboard__pendingLeaveRequests")
	public static WebElement pendingLeaveRequest;
}
