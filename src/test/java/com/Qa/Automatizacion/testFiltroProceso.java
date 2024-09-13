package com.Qa.Automatizacion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Before;

public class testFiltroProceso {

	private WebDriver driver;
	private ModuloFiltroProceso ModuloFiltroProceso;
	

	
	@Before
	
	public void setUp() throws Exception {
		
		ModuloFiltroProceso =  new ModuloFiltroProceso(driver);
		driver = ModuloFiltroProceso.chromeDriverConnection();
		ModuloFiltroProceso.visit("https://app.psicoalianza.com/auth/loginvoc?username=Danielproduccion&password=danieleltravieso");
		
		
		
	}
	
	@Test
	public void test() throws InterruptedException {

		
		
		ModuloFiltroProceso.procesoClic();
		ModuloFiltroProceso.gestionarClic();
		
		/*Validacion Filtros Seleccion*/
		
		ModuloFiltroProceso.idFiltros("87159");
		ModuloFiltroProceso.validarValorId("87159");
		
		ModuloFiltroProceso.gestionarClic();
		ModuloFiltroProceso.nameFiltros("Prueba Automatizada");
		ModuloFiltroProceso.validarName("Prueba Automatizada Qa Edit By Daniel");
		
		ModuloFiltroProceso.gestionarClic();
		ModuloFiltroProceso.responsableFiltros("Daniel Diaz");
		ModuloFiltroProceso.validarresponsable("Daniel Diaz");
		
		
		ModuloFiltroProceso.gestionarClic();
		ModuloFiltroProceso.creacionFiltros("2024-08-15");
		ModuloFiltroProceso.validarresCreacion("2024-08-15");
		
		
		ModuloFiltroProceso.gestionarClic();
		ModuloFiltroProceso.finFiltros("2024-08-31");
		ModuloFiltroProceso.validarresFin("2024-08-31");
		
		
		ModuloFiltroProceso.gestionarClic();
		ModuloFiltroProceso.vacantesFiltros("3");
		ModuloFiltroProceso.validarVacantes("3");
		
		/*Validar estado*/
		ModuloFiltroProceso.gestionarClic();
		ModuloFiltroProceso.estadosFiltros("Atrasado");
		ModuloFiltroProceso.validarEstados("Atrasado");
		ModuloFiltroProceso.estadosFiltros("Activo");
		ModuloFiltroProceso.validarEstados("Activo");
		ModuloFiltroProceso.estadosFiltros("Finalizado");
		ModuloFiltroProceso.validarEstados("Finalizado");
		/*Valdiar paginado*/
		ModuloFiltroProceso.gestionarClic();
		ModuloFiltroProceso.paginadoSeleccion("100");
		ModuloFiltroProceso.validarTextoPaginado(100);
		
		
		ModuloFiltroProceso.gestionarClic();
		ModuloFiltroProceso.paginadoSeleccion("50");
		ModuloFiltroProceso.validarTextoPaginado(50);
		
		ModuloFiltroProceso.gestionarClic();
		ModuloFiltroProceso.paginadoSeleccion("20");
		ModuloFiltroProceso.validarTextoPaginado(20);
		
		ModuloFiltroProceso.gestionarClic();
		ModuloFiltroProceso.paginadoSeleccion("10");
		ModuloFiltroProceso.validarTextoPaginado(10);
		
		ModuloFiltroProceso.descargarExcel();
		ModuloFiltroProceso.validarExcel("Gestionar procesos");
	}
	
	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(1000);
	    driver.quit();	
		
	}
	

}
