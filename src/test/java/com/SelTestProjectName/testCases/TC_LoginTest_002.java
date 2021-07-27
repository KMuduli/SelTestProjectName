
/**
 * 
 */
package com.SelTestProjectName.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SelTestProjectName.pageObjects.LoginPagePOM;
import com.SelTestProjectName.utilities.Common;
import com.SelTestProjectName.utilities.XLUtils;

/**
 * @author KMudali
 *
 */
public class TC_LoginTest_002 extends BaseClass
{
	
	LoginPagePOM loginPage;
	
@Test(dataProvider="LoginData")	
public void login002(String user,String pwd) throws IOException
{
	loginPage=new LoginPagePOM(driver);	
	loginPage.setUserName(user);
	logger.info("userName provided");
	loginPage.setPassword(pwd);
	logger.info("password provided");
	loginPage.clickSubmit();
	logger.info("clicked Submit button");
	
	if(isAlertPresent()==true)
	{
		captureScreenshot(driver,"login002");
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		logger.warn("Login FailTest");
		Assert.assertTrue(false);
	}
	else
	{
		Assert.assertTrue(true);
		loginPage.clickLogOut();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		logger.warn("Login Passed");
	}
	
}


@DataProvider(name="LoginData")
String [][] getData() throws IOException
{
	String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\SelTestProjectName\\testData\\SelProjectData.xlsx";
	int rownum=XLUtils.getRowCount(path, "Sheet1");
	int columncount=XLUtils.getCellCount(path, "Sheet1", 1);
	String logindata[][]=new String[rownum][columncount];
	
	for(int i=1;i<=rownum;i++)
	{
		for(int j=0;j<columncount;j++)
		{
			logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1",i,j);//1  0
		}
	}
	
	return logindata;
}



	

}
