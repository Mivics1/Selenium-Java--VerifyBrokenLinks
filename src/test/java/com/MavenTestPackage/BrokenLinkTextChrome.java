package com.MavenTestPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinkTextChrome {
	
	public static WebDriver driver;

	List<WebElement> activeLinks = new ArrayList<WebElement>();
	
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver", "‪‪..\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	@Test
	public void getLinks() {
		
		//List for all links and image
		List<WebElement> linkImgList = driver.findElements(By.tagName("a"));
		linkImgList.addAll(driver.findElements(By.tagName("img")));
		
		//Initial total Links and Images
		int initialTotal = linkImgList.size();
		System.out.println("Initially, We have a total of: "+initialTotal+" link(s) present in the webpage");
		
		for(int num=0; num<linkImgList.size(); num++) {
			if(linkImgList.get(num).getAttribute("href") != null && (!linkImgList.get(num).getAttribute("href").contains("JavaScript"))) {
				activeLinks.add(linkImgList.get(num));
			}
			
		}
		//Final total Links and Images
		int finalTotal = activeLinks.size();
		System.out.println("Finally, we have a total of "+finalTotal+" link(s) present in the webpage");
		}
	
	//
	@Test
	public void verifyBrokenLinksChrome() throws IOException {
		VerifyBrokenLinkChrome obj = new VerifyBrokenLinkChrome();
		for(int num=0; num<activeLinks.size();num++) {
			WebElement ele = activeLinks.get(num);
			String url = ele.getAttribute("href");
			obj.verifyBrokenLinks(url);
		}
		System.err.println("Total Valid Links: "+obj.validLinks);
		System.err.println("Total Invalid Links: "+obj.invalidLinks);
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
