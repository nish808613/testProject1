package com.testProject.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.testProject.utilites.ReadConfig;

public class BaseClass {

	/*
	 * Common variable required
	 */

	ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getApplicationUrl();
	public String userName = readConfig.getUserName();
	public String passWord = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		logger = Logger.getLogger("largestWord");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + readConfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir") + readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
