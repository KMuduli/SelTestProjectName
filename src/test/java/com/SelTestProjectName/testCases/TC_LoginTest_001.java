/**
 * 
 */
package com.SelTestProjectName.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SelTestProjectName.pageObjects.LoginPagePOM;
import com.SelTestProjectName.utilities.Common;
import com.SelTestProjectName.utilities.XLUtils;

import junit.framework.Assert;

/**
 * @author KMudali
 *
 */
@Test(dataProvider="testData")
public class TC_LoginTest_001 extends BaseClass{
	
	@Test(dataProvider="testData")	
	public void LoginTest(String data) throws IOException
	{
		System.out.println(data);
	}
	
	
	@DataProvider(name="testData")
	public String getdata() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\SelTestProjectName\\testData\\SelProjectData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int columncount=XLUtils.getCellCount(path, "Sheet1", 1);
		String data=XLUtils.getCellData(path,"Sheet1",1,1);
		return data;
		
	}	
	
	

}
