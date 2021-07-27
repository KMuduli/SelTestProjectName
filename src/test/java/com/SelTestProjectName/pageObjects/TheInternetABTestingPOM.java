/**
 * 
 */
package com.SelTestProjectName.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author KMudali
 *
 */
public class TheInternetABTestingPOM {
	
    WebDriver ldriver;
	
	public TheInternetABTestingPOM(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'A/B Testing')]")
	public WebElement lnk_ABTesting;
	
	@FindBy(how=How.XPATH, using="//h3[contains(text(),'A/B Test Variation 1')]")
	public WebElement lnk_ABTestingText;
	
	
	
	
	
	
	
	
	public void clickLnkABTesting()
	{
		lnk_ABTesting.click();
	}
	
	

}
