package com.testProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@name='uid']")
	@CacheLookup
	public WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	public WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	public WebElement btnLogin;

	public void setUserName(String uName) {
		txtUserName.sendKeys(uName);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
	@FindBy(xpath = "//marquee")
	WebElement sentence;
	
	public int longestWord() {
		String s = sentence.getText();
		String [] words = s.split(" ");
		int longestWord = 0;
		String lw = "";
		for(String word:words) {
			if(longestWord<word.length()) {
				longestWord=word.length();
				lw = word;
			}
		}
		System.out.println(lw);
		return longestWord;
	}

}
