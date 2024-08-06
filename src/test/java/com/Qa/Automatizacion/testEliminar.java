package com.Qa.Automatizacion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class testEliminar {

	private WebDriver driver;
	private ModuloEliminar ModuloEliminar;
	
	
	@Before
	public void setUp() throws Exception {
		
		
		
		ModuloEliminar = new ModuloEliminar(driver);
		driver = ModuloEliminar.chromeDriverConnection();
		ModuloEliminar.visit("https://app.psicoalianza.com/auth/loginvoc?username=Danielproduccion&password=danieleltravieso");
		
	}
	
	@Test
	public void test() throws InterruptedException {
		ModuloEliminar.procesoCreacion();
		ModuloEliminar.gestionarProceso();
		ModuloEliminar.vermasApp();
		ModuloEliminar.editarclickApp();
		ModuloEliminar.alertAceptar();
		ModuloEliminar.aceptarBtn();
		Thread.sleep(1000);
		ModuloEliminar.alertAceptar();
		ModuloEliminar.aceptarBtn();
	}

	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(1000);
		driver.quit();	
		
      
	}



}
