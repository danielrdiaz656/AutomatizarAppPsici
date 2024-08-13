package com.Qa.Automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pruebaPotencial extends Base {
	
	
	//By emailLocator = By.xpath("//tr[@jscontroller='ZdOxDb' and @jsmodel='nXDxbd' and @role='row' and @tabindex='-1']");
	By emailLocator = By.xpath("//span[@class=\"bog\"]");

	public pruebaPotencial(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void correoFirts () throws InterruptedException {
	
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
	    click(emailLocator);
	    


	  /* 
	   WebDriverWait wait = new WebDriverWait(driver, 15);
	    WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(emailLocator)); 
	   * 
	   * 
	   * if (emailElement.isDisplayed() && emailElement.isEnabled()) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", emailElement);
	    } else {
	        System.out.println("El elemento no es interactuable.");
	    }*/
	}

	    
}
