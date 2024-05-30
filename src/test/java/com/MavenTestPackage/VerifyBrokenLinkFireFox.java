package com.MavenTestPackage;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyBrokenLinkFireFox {
	public static WebDriver driver;

	List<WebElement> activeLinks = new ArrayList<WebElement>();
	
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver", "‪‪..\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void getLinks() {
		System.out.println("The Web App title is: "+driver.getTitle());
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
