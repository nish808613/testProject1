package com.testProject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testProject.pageObjects.HomePage;
import com.testProject.pageObjects.LoginPage;

public class TC_Test_002 extends BaseClass{
	
	@Test
	public void Test2() {
		logger.info("Url is open");
		
		LoginPage lp = new LoginPage(driver);
		
		HomePage hp = new HomePage(driver);
		
		lp.setUserName(userName);
		logger.info("Entered username");
	
		lp.setPassword(passWord);
		logger.info("Entered password");
		lp.clickSubmit();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login has passed");
		} else {
			Assert.assertFalse(false);
			logger.info("login has failed");
		}
		
		String longestWord = hp.findLongestWordInSentence();
		Assert.assertEquals(longestWord, "Manager's");
		logger.info("longest word in a sentence is " + longestWord);
		
	}

}
