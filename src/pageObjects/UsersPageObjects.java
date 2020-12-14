package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPageObjects {
	
	//id="menu_admin_viewAdminModule"

	@FindBy(linkText = "Admin")
	public static WebElement admin;
	@FindBy(id="menu_admin_UserManagement")
	public static WebElement userManagement;
	@FindBy(id="menu_admin_viewSystemUsers")
	public static WebElement users;
	@FindBy(id="searchSystemUser_userType")
	public static WebElement userRole;
	@FindBy(id="searchSystemUser_status")
	public static WebElement status;
	@FindBy(id="searchBtn")
	public static WebElement search;
	@FindBy(xpath="//td[3]")
	public static WebElement userRoleForUser;
	@FindBy(xpath="//td[5]")
	public static WebElement statusForUser;
	
	

}
