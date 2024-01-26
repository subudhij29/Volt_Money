package org.volt.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilitis.FileReaderUtil;

public class BaseClass {
	public static WebDriver driver;

	// Browser Settings
	@Parameters({ "browser" })
	@BeforeClass
	public void setUp(String br) {

		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		} else {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(FileReaderUtil.getConfigProperty(Constants.URL));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
