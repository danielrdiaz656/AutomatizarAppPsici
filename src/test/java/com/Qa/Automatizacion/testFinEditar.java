package com.Qa.Automatizacion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class testFinEditar {
 
	private WebDriver driver;
	private FechaFinEditar FechaFinEditar;
	

	@Before
	public void setUp() throws Exception {
		
		FechaFinEditar = new FechaFinEditar (driver);
		driver = FechaFinEditar.chromeDriverConnection();
		FechaFinEditar.visit("https://app.psicoalianza.com/auth/loginvoc?username=Danielproduccion&password=danieleltravieso");
		
	}



	@Test
	public void test() throws InterruptedException {
		FechaFinEditar.procesoCreacion();
		FechaFinEditar.gestionarProceso();
		FechaFinEditar.vermasApp();
		FechaFinEditar.editarClic();
		FechaFinEditar.seleccionarFecha(driver, "31-08-2024");
		FechaFinEditar.ubucacionModalQa();
		FechaFinEditar.acpertartCambio();
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		

	}

}
