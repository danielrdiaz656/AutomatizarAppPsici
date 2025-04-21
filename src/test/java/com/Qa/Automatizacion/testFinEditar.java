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
		//FechaFinEditar.visit("https://demo.psicoalianza.com/auth/loginvoc?username=Daniel_4514304&password=Daniel123-");
		FechaFinEditar.visit("https://app.psicoalianza.com/auth/loginvoc?username=Susana01&password=El amor es uno de los sentimientos más bello");
	}



	@Test
	public void test() throws InterruptedException {
		FechaFinEditar.procesoCreacion();
		FechaFinEditar.gestionarProceso();
		FechaFinEditar.vermasApp();
		FechaFinEditar.editarClic();
		FechaFinEditar.seleccionarFecha(driver, "30-08-2025");
		FechaFinEditar.ubucacionModalQa();
		FechaFinEditar.acpertartCambio();
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		

	}

}
