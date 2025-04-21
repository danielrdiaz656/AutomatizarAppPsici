package com.Qa.Automatizacion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class testDuplicarProceso {

	private WebDriver driver;
	private ModuloDuplicar ModuloDuplicar;

	@Before
	public void setUp() throws Exception {
		
	ModuloDuplicar = new ModuloDuplicar(driver);
	driver = ModuloDuplicar.chromeDriverConnection();
	//ModuloDuplicar.visit("https://demo.psicoalianza.com/auth/loginvoc?username=Daniel_4514304&password=Daniel123-");
	ModuloDuplicar.visit("https://app.psicoalianza.com/auth/loginvoc?username=Danielproduccion&password=danieleltravieso");
		
	}
	
	@Test
	public void test() throws InterruptedException {

		ModuloDuplicar.procesoCreacion();
		ModuloDuplicar.gestionarProceso();
		ModuloDuplicar.vermasApp();
		ModuloDuplicar.duplictedBtn();
		ModuloDuplicar.nombreDuplicarProceso();
		ModuloDuplicar.changeDate("16/02/2025");
		ModuloDuplicar.enviarDuplicado();
		ModuloDuplicar.enviarDuplicado();
		ModuloDuplicar.enviarText();
	}

	@After
	public void tearDown() throws Exception {
	}



}
