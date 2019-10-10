package com.atmecs.utility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class PageManager 

{
	public static void manageTimeOuts(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(Constants.waitingTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.waitingTime, TimeUnit.SECONDS);
	}
	
	
	
	public static void loadpropertyFile(String filePath,Properties property) throws IOException {
		FileInputStream input = new FileInputStream(filePath);
		property.load(input);
	}
	public static void scrollAndView(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", element);
	}
	public static  void selectDropDownText(WebDriver driver,String dropDownXpath, String dropDownText) {
		Select dropdown = new Select(driver.findElement(By.xpath(dropDownXpath)));  
		dropdown.selectByVisibleText(dropDownText);
	}
	public static void scrollAndViewAtTop(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	

}
