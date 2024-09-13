package com.Qa.Automatizacion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class testFiltroHistorial {

	private WebDriver driver;
	private ModuloFiltroHistorial ModuloFiltroHistorial;
	
	
	@Before
	
	public void setUp() throws Exception {
		
		ModuloFiltroHistorial = new ModuloFiltroHistorial (driver);
		driver = ModuloFiltroHistorial.chromeDriverConnection();
		ModuloFiltroHistorial.visit("https://app.psicoalianza.com/auth/loginvoc?username=Danielproduccion&password=danieleltravieso");
		
	}
	
	
	
	
	
	@Test
	public void test() throws InterruptedException {


		ModuloFiltroHistorial.procesoClic();
		ModuloFiltroHistorial.historialClic();
	
		ModuloFiltroHistorial.filtroId("2593996");
		ModuloFiltroHistorial.validarId("2593996");
		
		ModuloFiltroHistorial.historialClic();
		ModuloFiltroHistorial.filtroName("Linda  Mendez");
		ModuloFiltroHistorial.validarName("Linda Mendez");
		
		ModuloFiltroHistorial.historialClic();
		ModuloFiltroHistorial.filtroDocument("564656");	
		ModuloFiltroHistorial.validaraDocumet("564656");
		
		ModuloFiltroHistorial.historialClic();
		ModuloFiltroHistorial.filtroCorreo("preutest2634548787rodrigo.lar@gmail.com");
		ModuloFiltroHistorial.validaraCorreo("preutest2634548787rodrigo.lar@gmail.com");
		
		ModuloFiltroHistorial.historialClic();
		ModuloFiltroHistorial.filtroProceso("Prueba Automatizada Qa Edit By Daniel");
		ModuloFiltroHistorial.validaraProceso("Prueba Automatizada Qa Edit By Daniel");
		
		ModuloFiltroHistorial.historialClic();
		ModuloFiltroHistorial.filtroPrueba("Ten DISC Plus");
		ModuloFiltroHistorial.validaraPrueba("Ten DISC Plus");
		
		
		ModuloFiltroHistorial.historialClic();
		ModuloFiltroHistorial.finFiltros("2024-07-22");
		ModuloFiltroHistorial.validaraFecha("2024-07-22");
		
		
		ModuloFiltroHistorial.historialClic();
		ModuloFiltroHistorial.filtroEstado("Agendada");
		ModuloFiltroHistorial.validarEstado("Agendada");
		ModuloFiltroHistorial.historialClic();
		ModuloFiltroHistorial.filtroEstado("Iniciada");
		ModuloFiltroHistorial.validarEstado("Iniciada");
		ModuloFiltroHistorial.historialClic();
		ModuloFiltroHistorial.filtroEstado("Finalizada");
		ModuloFiltroHistorial.validarEstado("Finalizada");
		
		ModuloFiltroHistorial.paginadoHistorial("10");
		ModuloFiltroHistorial.validarTextoPaginado(10);
		
		ModuloFiltroHistorial.paginadoHistorial("20");
		ModuloFiltroHistorial.validarTextoPaginado(20);
		
		ModuloFiltroHistorial.paginadoHistorial("50");
		ModuloFiltroHistorial.validarTextoPaginado(50);
		
		ModuloFiltroHistorial.paginadoHistorial("100");
		ModuloFiltroHistorial.validarTextoPaginado(100);
		
		ModuloFiltroHistorial.descargarExcel();
		ModuloFiltroHistorial.downloads();
		ModuloFiltroHistorial.validarExcel("Historial de Agendamientos");
		
		
	}
	
	@After
	public void tearDown() throws Exception {

		Thread.sleep(1000);
		driver.quit();	
		 
	}

}
