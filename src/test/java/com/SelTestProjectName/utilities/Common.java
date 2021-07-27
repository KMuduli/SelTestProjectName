/**
 * 
 */
package com.SelTestProjectName.utilities;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author KMudali
 *
 */
public class Common {
	
	public static WebDriver driver;
	Actions action;
	
	
	public void captureScreenshot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");	
		
	}
	
	public boolean isAlertPresent()//User Defined method to check alert is present or not
	{
		try
		{
	      driver.switchTo().alert();
	      return true;
	    		
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	
	
	public void explicitWait(WebElement element,int seconds)
	{
	WebDriverWait wait =new WebDriverWait(driver, seconds);
	WebElement Element=wait.until(ExpectedConditions.elementToBeClickable(element));
	Element.click();
	}
	
	
	
	public void selectDropDownByIndex(WebElement sel,int index)
	{
		Select select= new Select(sel);
		select.selectByIndex(index);
		
	}
	
	public void selectDropDownByValue(WebElement sel,String value)
	{
		Select select= new Select(sel);
		select.selectByValue(value);
		
	}
	
	public void selectDropDownByVisibleText(WebElement sel,String text)
	{
		Select select= new Select(sel);
		select.selectByVisibleText(text);
		
	}
	
	
	public void dragAndDropElement(WebElement source,WebElement target)
	{
		
		action.dragAndDrop(source, target).build().perform();
	}
	
	
	public void deleteAllCookies()
	{
		driver.manage().deleteAllCookies();
	}
	
	public void selectIFrameUsingIndex(int index)
	{   
		 
	    driver.switchTo().frame(index);
	}
	 
	//Using iframe name
	public void selectIFrameUsingName(String name) 
	{
	 
	    driver.switchTo().frame(name);
	    
	}
	
	public void selectParentIFrame() 
	{
	 
	    driver.switchTo().defaultContent();
	    
	}
	 
	//Using WebElement 
	public void selectIFrameUsingWebElement(WebElement element) 
	{
	 
	    driver.switchTo().frame(element);
	}
	
	
	public boolean isElementDisplayed(WebElement element) 
	{
	 if(element.isDisplayed())
	 {
		 return true;
	 }
	 else
	 {
		 return false;
	 }
	   
	}
	
	
	public boolean isElementEnable(WebElement element) 
	{
	 if(element.isEnabled())
	 {
		return true;
	 }
	 else
	 {
		 return false;
	 }
	   
	}
	
	
	public boolean isElementSelected(WebElement element) 
	{
	 if(element.isSelected())
	 {
		 return true;
	 }
	 else
	 {
		 return false;
	 }
	   
	}
	
	
	public boolean verifyTextOnPage(WebElement ele,String text) 
	{
	 explicitWait(ele,20);
	 if(driver.getPageSource().contains(text))
	 {
		 return true;
	 }
	 else
	 {
		 return false;
	 }
	   
	}
	
	
	
	
	public void fluentWait(WebElement element)
	{
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).
				withTimeout(30,TimeUnit.SECONDS).
				pollingEvery(3,TimeUnit.SECONDS).
				ignoring(NoSuchElementException.class);
   
		element = wait.until(new Function<WebDriver, WebElement>(){

        public WebElement apply(WebDriver driver ) {
            return driver.findElement(By.xpath("//button[@id='btn_ok']"));
        }
        
    });
		element.click();
	}
	
	

}
