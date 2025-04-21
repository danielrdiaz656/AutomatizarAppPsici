package com.Qa.Automatizacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class testPruebaEthikos {

	private WebDriver driver;
	private pruebaEthikos pruebaEthikos;
	

	@Before
	public void setUp() throws Exception {
		System.out.println("Qa1");
		pruebaEthikos = new pruebaEthikos(driver);
		driver = pruebaEthikos.chromeDriverConnection();
	    if (driver == null) {
	        System.out.println("Error: El WebDriver no se inicializó correctamente.");
	        return;
	    }
		System.out.println("Qa2");
		pruebaEthikos.visitGoogle("https://accounts.google.com/");
		Thread.sleep(1000);
		System.out.println("Qa3");
		Thread.sleep(1000);
        System.out.println("Qa4");
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		System.out.println("Qa5");

	}



	@Test
	public void test() throws InterruptedException {

		pruebaEthikos.correoFirts();
		pruebaEthikos.comenzarQa();
		pruebaEthikos.potencialTestStart();
		pruebaEthikos.activarCamara();
		pruebaEthikos.continuarPrueba();
		pruebaEthikos.tomarFotoQa();
		pruebaEthikos.continuarPrueba();

		for (int porcentaje = 13; porcentaje <= 100; porcentaje += 6) {
			pruebaEthikos.seleccionarTodasLasA();
			pruebaEthikos.continuarQaTest();
		}


		pruebaEthikos.finTest();
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		
		
		
	}

}
