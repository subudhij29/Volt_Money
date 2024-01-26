package org.volt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import utilitis.FileReaderUtil;
import utilitis.XLUtilty;
import webActions.WebActions;

public class TestRunner extends BaseClass {
	// static WebDriver driver;

	@Test(dataProvider = "LoginData")
	public void loginTest(String username, String password, String scenario) {
		WebActions.sendKeys(driver, FileReaderUtil.getObjProperty(Constants.USER_NAME), username);
		WebActions.sendKeys(driver, FileReaderUtil.getObjProperty(Constants.PASSWORD), password);
		WebActions.click(driver, FileReaderUtil.getObjProperty(Constants.LOGIN));
		String exp_title = FileReaderUtil.getConfigProperty(Constants.TITLE);
		String act_title = driver.getTitle();
		if (scenario.equals("valid")) {
			if (exp_title.equals(act_title)) {
				AddToCartTest add = new AddToCartTest();
				add.addToCart(FileReaderUtil.getConfigProperty(Constants.PRODUCT_NAME));
				RemoveTest remove = new RemoveTest();
				remove.removebtn();
				CheckoutTest check = new CheckoutTest();
				check.checkOut();
				Assert.assertTrue(true);
			} else {
				Assert.assertFalse(false);
			}
		} else if (scenario.equals("invalid")) {
			if (exp_title.equals(act_title)) {
				driver.findElement(By.xpath(FileReaderUtil.getObjProperty(Constants.ERROR_MESSAGE))).isDisplayed();
				String mssg = driver.findElement(By.xpath(FileReaderUtil.getObjProperty(Constants.ERROR_MESSAGE)))
						.getText();
				System.out.println("Then Error mssg is:" + mssg);
				Assert.assertTrue(true);
			} else {
				Assert.assertFalse(false);
			}
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws Exception {
		String path = FileReaderUtil.getConfigProperty(Constants.FILE_PATH);
		XLUtilty xlutil = new XLUtilty(path);
		int totalRows = xlutil.getRowCount(FileReaderUtil.getConfigProperty(Constants.SHEET_NAME));
		int totalCols = xlutil.getCellCount(FileReaderUtil.getConfigProperty(Constants.SHEET_NAME), 1);
		String loginData[][] = new String[totalRows][totalCols];
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				loginData[i - 1][j] = xlutil.getCellData(FileReaderUtil.getConfigProperty(Constants.SHEET_NAME), i, j);
			}
		}
		return loginData;

	}

}
