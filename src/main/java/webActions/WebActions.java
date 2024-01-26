package webActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActions {
     public static void click(WebDriver driver,String xpath) {
    	 waitElement(driver, xpath);
    	 driver.findElement(By.xpath(xpath)).click();


     }
     public static void waitElement(WebDriver driver,String xpath) {
    	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
     }
     public static void sendKeys(WebDriver driver,String xpath,String text) {
    	 waitElement(driver, xpath);
    	 driver.findElement(By.xpath(xpath)).clear();
    	 driver.findElement(By.xpath(xpath)).sendKeys(text);
     }
     public static String getText(WebDriver driver,String xpath) {
    	return driver.findElement(By.xpath(xpath)).getText();
     }
}





