package org.volt.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import utilitis.FileReaderUtil;
import webActions.WebActions;

public class CheckoutTest extends BaseClass {

	@Test
	public void checkOut() {
		WebActions.sendKeys(driver, FileReaderUtil.getObjProperty(Constants.FIRST_NAME),FileReaderUtil.getConfigProperty(Constants.ENTER_FNAME));
		WebActions.sendKeys(driver, FileReaderUtil.getObjProperty(Constants.LAST_NAME),FileReaderUtil.getConfigProperty(Constants.ENTER_LNAME));
		WebActions.sendKeys(driver, FileReaderUtil.getObjProperty(Constants.POSTALCODE),FileReaderUtil.getConfigProperty(Constants.ENTER_POSTALCODE));

		WebActions.click(driver, FileReaderUtil.getObjProperty(Constants.CONTINUE));
		System.out.println("clicked on continue");
		WebActions.click(driver, FileReaderUtil.getObjProperty(Constants.FINISH_BUTTON));
		String orderStatus = WebActions.getText(driver, FileReaderUtil.getObjProperty(Constants.SUCCESS_STATUS));
		String actualStatus = FileReaderUtil.getConfigProperty(Constants.ACTUAL_SUCCESS_STATUS);
		Assert.assertEquals(orderStatus, actualStatus, "Order status doesnt match");
		String message = WebActions.getText(driver, FileReaderUtil.getObjProperty(Constants.COMPLETE_MSSG));
		System.out.println("OrderStatus=" + message);
		WebActions.click(driver, FileReaderUtil.getObjProperty(Constants.OPEN_MENU_ICON));
		WebActions.click(driver, FileReaderUtil.getObjProperty(Constants.LOGOUT));
		System.out.println("sucuessfull");
	}
}
