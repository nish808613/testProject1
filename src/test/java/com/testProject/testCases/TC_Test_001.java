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

		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Guru99 Bank Manager HomePage");
		logger.info("login has passed");
		

		int longestWord = lp.longestWord();
		Assert.assertEquals(longestWord, 9);
		logger.info("The longest word has " + longestWord + " letters");

	}

}
