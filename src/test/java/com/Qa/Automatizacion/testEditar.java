package com.Qa.Automatizacion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class testEditar {
    
	private WebDriver driver;
	private ModuloEditarProceso ModuloEditarProceso;

	
	@Before
	public void setUp() throws Exception {
		
		ModuloEditarProceso = new ModuloEditarProceso(driver);
		driver = ModuloEditarProceso.chromeDriverConnection();
		ModuloEditarProceso.visit("https://app.psicoalianza.com/auth/loginvoc?username=Danielproduccion&password=danieleltravieso");
		
	}



	@Test
	public void test() throws InterruptedException {
		ModuloEditarProceso.procesoCreacion();
		ModuloEditarProceso.gestionarProceso();
		ModuloEditarProceso.vermasApp();
		ModuloEditarProceso.editarclickApp();
		
		ModuloEditarProceso.nombreProceso();
		ModuloEditarProceso.setFechaCierre("02/08/2024");
		ModuloEditarProceso.numeroVacantesApp();
		ModuloEditarProceso.registroFotograficoApp();
	}

	@After
	public void tearDown() throws Exception {
		
		

		
	}
}
