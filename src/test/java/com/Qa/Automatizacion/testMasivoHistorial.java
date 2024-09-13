package com.Qa.Automatizacion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class testMasivoHistorial {

	private WebDriver driver;
	private ModuloMasivasHistorial ModuloMasivasHistorial;
	
	
	@Before
	
	public void setUp() throws Exception {
	
		ModuloMasivasHistorial = new ModuloMasivasHistorial(driver);
		driver = ModuloMasivasHistorial.chromeDriverConnection();
		ModuloMasivasHistorial.visit("https://app.psicoalianza.com/auth/loginvoc?username=Danielproduccion&password=danieleltravieso");
		
		
		
	}
	
	
	
	@Test
	public void test() throws InterruptedException {
		
		ModuloMasivasHistorial.procesoClic();
		ModuloMasivasHistorial.historialClic();
		ModuloMasivasHistorial.checkClic();
		ModuloMasivasHistorial.reenviarCorreos();
		ModuloMasivasHistorial.aceptarEnvios();
		
		//ModuloMasivasHistorial.PaginaProcesos();
		//ModuloMasivasHistorial.navegarPagina("https://app.psicoalianza.com/");
		//ModuloMasivasHistorial.validarRespuestaProcesarMasivo();
		ModuloMasivasHistorial.historialClic();
		ModuloMasivasHistorial.checkClic();
		ModuloMasivasHistorial.testProcesar();
		ModuloMasivasHistorial.validarProcesar();
		
		ModuloMasivasHistorial.historialClic();
		ModuloMasivasHistorial.checkClic();
		ModuloMasivasHistorial.selectMes();
		ModuloMasivasHistorial.seleccionarDia("20");
		ModuloMasivasHistorial.guardarFecha();
		ModuloMasivasHistorial.testMasivo();
		
		
		ModuloMasivasHistorial.historialClic();
		ModuloMasivasHistorial.checkClic();
		ModuloMasivasHistorial.eliminarAgendas();
		ModuloMasivasHistorial.deleteInput("ELIMINAR");
		ModuloMasivasHistorial.eliminar();
		ModuloMasivasHistorial.aceptarAlert();
	
		
	}
	
	@After
	public void tearDown() throws Exception {

		Thread.sleep(1000);
		driver.quit();	
		 
	}
	
}
