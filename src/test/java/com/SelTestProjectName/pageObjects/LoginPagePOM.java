/**
 * 
 */
package com.SelTestProjectName.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author KMuduli
 *
 */
public class LoginPagePOM {
	
	WebDriver ldriver;
	
	public LoginPagePOM(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	public WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	public WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	public WebElement btnLogin;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	@CacheLookup
	public WebElement btnLogout;
	
	
	
	
	public void setUserName(String name)
	{
		txtUserName.sendKeys(name);
	}

	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
	public void clickLogOut()
	{
		btnLogout.click();
	}
}
