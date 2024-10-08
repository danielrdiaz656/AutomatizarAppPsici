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
		System.out.println("Qa1");
		pruebaPotencial = new pruebaPotencial(driver);
		driver = pruebaPotencial.chromeDriverConnection();
	    if (driver == null) {
	        System.out.println("Error: El WebDriver no se inicializó correctamente.");
	        return;
	    }
		System.out.println("Qa2");
		pruebaPotencial.visitGoogle("https://accounts.google.com/");
		Thread.sleep(1000);
		System.out.println("Qa3");
		Thread.sleep(1000);
        System.out.println("Qa4");
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		System.out.println("Qa5");

	}



	@Test
	public void test() throws InterruptedException {
           
		pruebaPotencial.correoFirts();
		pruebaPotencial.comenzarQa();
		pruebaPotencial.potencialTestStart();
		pruebaPotencial.activarCamara();
		pruebaPotencial.continuarPrueba();
		pruebaPotencial.tomarFotoQa();
		pruebaPotencial.continuarPrueba();
		/*13%*/
		pruebaPotencial.continuarQaTest();
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*19%*/
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*25%*/
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*31%*/
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*38%*/
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*44%*/
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*50%*/
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*56%*/
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*63%*/
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*69%*/
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*75%*/
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*81%*/
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*88%*/
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*94%*/
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*100%*/
		pruebaPotencial.seleccionarTodasLasA();
		pruebaPotencial.continuarQaTest();
		/*Fin*/
		pruebaPotencial.finTest();
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		
		
		
	}

}
