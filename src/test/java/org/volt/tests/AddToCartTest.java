package org.volt.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import constants.Constants;
import utilitis.FileReaderUtil;
import webActions.WebActions;

public class AddToCartTest extends BaseClass {
	
    @Test
    public void addToCart(String... product) {
     if(product.length>=0) {
    	 WebActions.click(driver, FileReaderUtil.getObjProperty(Constants.ADDTO_CART).replace("PARAM",product[0] ));
    	 
    	 

   	
   	 
     }else {
    	 WebActions.click(driver, FileReaderUtil.getObjProperty(Constants.ADD_TO_CART));
    	 
     }
   	
   	WebActions.click(driver, FileReaderUtil.getObjProperty(Constants.SHOPPING_CART));
   	
   	
    }
}
