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

public class SeleniumGrid3 {

	protected ThreadLocal<WebDriver> wd = new ThreadLocal<WebDriver>();

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
		wd.set(new RemoteWebDriver(new URL(hubURL), options));

	}

	@Test()
	public void getTitleOfGoogle() throws InterruptedException {
		getThreadSafeCopyOfWebdriver().get("https://www.google.com/");
		Thread.sleep(5000);
		System.out.println(wd.get().getTitle());
	}

	@Test
	public void getTitleOfAutomationPractise() throws InterruptedException {
		getThreadSafeCopyOfWebdriver().get("http://automationpractice.com/index.php");
		Thread.sleep(5000);
		System.out.println(wd.get().getTitle());
	}

	@Test
	public void getTitleOfDemoQa() throws InterruptedException {
		getThreadSafeCopyOfWebdriver().get("https://demoqa.com/automation-practice-form");
		Thread.sleep(5000);
		System.out.println(wd.get().getTitle());
	}

	@Test
	public void getTitleOfPhpTravel() throws InterruptedException {
		getThreadSafeCopyOfWebdriver().get("https://www.phptravels.net/");
		Thread.sleep(5000);
		System.out.println(wd.get().getTitle());
	}
	
	@Test
	public void getTitleOfParaBank() throws InterruptedException {
		getThreadSafeCopyOfWebdriver().get("https://parabank.parasoft.com/parabank/register.htm");
		Thread.sleep(5000);
		System.out.println(wd.get().getTitle());
	}

	@AfterMethod
	public void tearDown() {
		getThreadSafeCopyOfWebdriver().quit();

	}
	
	public WebDriver getThreadSafeCopyOfWebdriver() {
		return wd.get();
				
	}

}
