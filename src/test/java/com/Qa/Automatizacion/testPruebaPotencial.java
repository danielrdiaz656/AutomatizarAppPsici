package com.Qa.Automatizacion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testPruebaPotencial {

	private WebDriver driver;
	private pruebaPotencial pruebaPotencial;
	

	@Before
	public void setUp() throws Exception {
		
		pruebaPotencial = new pruebaPotencial(driver);
		driver = pruebaPotencial.chromeDriverConnection();
		pruebaPotencial.visitGoogle("https://accounts.google.com/");
		Thread.sleep(2000);
		pruebaPotencial.visitGoogle("https://mail.google.com/mail/u/0/#inbox");
		
	}



	@Test
	public void test() throws InterruptedException {
           
		pruebaPotencial.correoFirts();
		
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		
		
		
	}

}
