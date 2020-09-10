package com.testProject.pageObjects;

import java.util.StringTokenizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver ldriver;

	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//marquee")
	WebElement sentence;

	public String findLongestWordInSentence() {
		String s = sentence.getText();
		String[] word = s.split(" ");
		String maxlethWord = "";
		for (int i = 0; i < word.length; i++) {
			if (word[i].length() >= maxlethWord.length()) {
				maxlethWord = word[i];
			}
		}
		System.out.println(maxlethWord.length());
		return maxlethWord;
	}

	public String findLongestWordMethod2() {
		String s = sentence.getText();
		String[] ns = s.split(" ");
		String longestWord = ns[0];
		for (String lw : ns) {
			if (lw.length() > longestWord.length()) {
				longestWord = lw;
			}
		}
		System.out.println("Longest word has " + longestWord.length() + " letters");
		return longestWord;
	}

	public String findLongestWordMethod3() {
		String s1 = sentence.getText();
		int max = 0;
		String s2 = new String();
		StringTokenizer t = new StringTokenizer(s1, " ");
		while (t.hasMoreTokens()) {
			String s3 = t.nextToken();
			int n = s3.length();
			if (n > max) {
				max = n;
				s2 = s3;
			}
		}
		return s2;
	}
}
