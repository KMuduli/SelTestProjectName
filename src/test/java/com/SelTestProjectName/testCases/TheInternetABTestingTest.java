/**
 * 
 */
package com.SelTestProjectName.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SelTestProjectName.pageObjects.TheInternetABTestingPOM;

/**
 * @author KMudali
 *
 */
public class TheInternetABTestingTest extends BaseClass{
	
	
	TheInternetABTestingPOM abTest;
	
	
	@Test(priority=0)
	public void ABTesting() throws IOException
	{
	 abTest=new TheInternetABTestingPOM(driver);
	 abTest.clickLnkABTesting();
	 logger.info("Clicked A/B Testing link");
	 if(verifyTextOnPage(abTest.lnk_ABTestingText,"A/B Test Control"))
	 {
		Assert.assertTrue(true); 
		logger.info("Text Verified successfully");
	 }
	 else
	 {	 logger.error("Text Verification Failed");
		 captureScreenshot(driver,"ABTesting");
		 Assert.assertTrue(false);		 
	 }		
	}
	
	
	
	
}
