package com.Qa.Automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pruebaPotencial extends Base {
	
	
	By emailLocator = By.xpath("//tr[@jscontroller='ZdOxDb' and @jsmodel='nXDxbd' and @role='row' and @tabindex='-1']");


	public pruebaPotencial(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void correoFirts () throws InterruptedException {
	
		Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
        Actions actions = new Actions(driver);
        actions.moveToElement(emailElement).click().perform();
	}

}
