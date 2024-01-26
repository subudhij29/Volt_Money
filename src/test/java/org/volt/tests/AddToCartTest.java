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
    	 
    	 
//   	WebElement ele= driver.findElement(By.xpath("//*[contains(text(),'"+product[0]+"')]//ancestor::div[@class='inventory_item_description']"
//   	 		+ "//child::button[text()='Add to cart']"));
   	
   	 
     }else {
    	 WebActions.click(driver, FileReaderUtil.getObjProperty(Constants.ADD_TO_CART));
    	 
     }
   	
   	WebActions.click(driver, FileReaderUtil.getObjProperty(Constants.SHOPPING_CART));
   	
   	
    }
}
