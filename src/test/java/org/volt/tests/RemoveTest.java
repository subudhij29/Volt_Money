package org.volt.tests;

import org.testng.annotations.Test;

import constants.Constants;
import utilitis.FileReaderUtil;
import webActions.WebActions;

public class RemoveTest extends BaseClass{
	@Test
	public void removebtn() {
		WebActions.click(driver, FileReaderUtil.getObjProperty(Constants.REMOVE_PRODUCT));
		WebActions.click(driver, FileReaderUtil.getObjProperty(Constants.CHECK_OUT));
}}
