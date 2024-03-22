package com.google.www.SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumGrid {

	WebDriver wd;
	int cnt=0;

	@BeforeMethod
	public void setUp() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		/*
		 * cap.acceptInsecureCerts(); cap.setVersion("");
		 */

		ChromeOptions options = new ChromeOptions();
		options.merge(cap);

		String hubURL = "http://192.168.99.1:4444/wd/hub";
		wd=new RemoteWebDriver(new URL(hubURL), options);
		System.out.println(cnt + " :Instance no. " + wd);
		cnt++;

	}

	@Test()
	public void getTitleOfGoogle() throws InterruptedException {
		System.out.println("Google wd is "+ wd);
		wd.get("https://www.google.com/");
		Thread.sleep(5000);
		System.out.println(wd.getTitle());
	}

	@Test
	public void getTitleOfAutomationPractise() throws InterruptedException {
		System.out.println("Automation practise wd is "+ wd);
		wd.get("http://automationpractice.com/index.php");
		Thread.sleep(5000);
		System.out.println(wd.getTitle());
	}

	@Test
	public void getTitleOfDemoQa() throws InterruptedException {
		System.out.println("Demo qa wd is "+ wd);
		wd.get("https://demoqa.com/automation-practice-form");
		Thread.sleep(5000);
		System.out.println(wd.getTitle());
	}

	@Test
	public void getTitleOfPhpTravel() throws InterruptedException {
		System.out.println("Php wd is "+ wd);
		wd.get("https://www.phptravels.net/");
		Thread.sleep(5000);
		System.out.println(wd.getTitle());
	}
	
	@Test
	public void getTitleOfParaBank() throws InterruptedException {
		System.out.println("Para Bank wd is "+ wd);
		wd.get("https://parabank.parasoft.com/parabank/register.htm");
		Thread.sleep(5000);
		System.out.println(wd.getTitle());
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("Closing wd is "+ wd);
		wd.quit();

	}

}
