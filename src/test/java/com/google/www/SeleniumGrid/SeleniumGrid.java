package com.google.www.SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumGrid {

	//protected ThreadLocal<WebDriver> wd = new ThreadLocal<WebDriver>();

	WebDriver wd;
	@BeforeMethod
	public void setUp() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);

		ChromeOptions options = new ChromeOptions();
		options.merge(cap);

		String hubURL = "http://10.0.0.130:4444/wd/hub";
		wd=new RemoteWebDriver(new URL(hubURL), options);
		//wd.set(new RemoteWebDriver(new URL(hubURL), options));

	}

	@Test
	public void getTitleOfGoogle() throws InterruptedException {
		wd.get("https://www.google.com/");
		Thread.sleep(5000);
		System.out.println(wd.getTitle());
	}

	@Test
	public void getTitleOfAutomationPractise() throws InterruptedException {
		wd.get("http://automationpractice.com/index.php");
		Thread.sleep(5000);
		System.out.println(wd.getTitle());
	}

	@Test
	public void getTitleOfDemoQa() throws InterruptedException {
		wd.get("https://demoqa.com/automation-practice-form");
		Thread.sleep(5000);
		System.out.println(wd.getTitle());
	}

	@Test
	public void getTitleOfPhpTravel() throws InterruptedException {
		wd.get("https://www.phptravels.net/");
		Thread.sleep(5000);
		System.out.println(wd.getTitle());
	}
	
	@Test
	public void getTitleOfParaBank() throws InterruptedException {
		wd.get("https://parabank.parasoft.com/parabank/register.htm");
		Thread.sleep(5000);
		System.out.println(wd.getTitle());
	}

	@AfterMethod
	public void tearDown() {
		wd.quit();

	}

}
