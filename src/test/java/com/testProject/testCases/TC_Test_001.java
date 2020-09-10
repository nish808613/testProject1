package com.testProject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testProject.pageObjects.LoginPage;

public class TC_Test_001 extends BaseClass {

	@Test
	public void loginTest() {

	
		logger.info("Url is open");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Entered username");
	
		lp.setPassword(passWord);
		logger.info("Entered password");
		lp.clickSubmit();

		if (driver.getTitle().equals(" Guru99 Bank Manager HomePage ")) {
			Assert.assertTrue(true);
			logger.info("login has passed");
		} else {
			Assert.assertFalse(false);
			logger.info("login has failed");
		}

	}

}
