/**
 * 
 */
package com.SelTestProjectName.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author KMudali
 *
 */
public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/Config.properties");
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	public String getTestApplicationURL()
	{
		String applicationTestURL=pro.getProperty("applicationTestURL");
		return applicationTestURL;
	}

	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getIepath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}

}
