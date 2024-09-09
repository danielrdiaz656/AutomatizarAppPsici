package com.Qa.Automatizacion;

import static org.junit.Assert.*;

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
	public void test() {
		
		ModuloMasivasHistorial.procesoClic();
		ModuloMasivasHistorial.historialClic();
		ModuloMasivasHistorial.checkClic();
		ModuloMasivasHistorial.reenviarCorreos();
		ModuloMasivasHistorial.aceptarEnvios();
		
		ModuloMasivasHistorial.PaginaProcesos();
		ModuloMasivasHistorial.navegarPagina("https://app.psicoalianza.com/");
		ModuloMasivasHistorial.validarRespuestaProcesarMasivo();
	
	
	}

}
