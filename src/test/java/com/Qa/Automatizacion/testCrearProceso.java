package com.Qa.Automatizacion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class testCrearProceso {


	private WebDriver driver;
	private ModuloCreacionProceso ModuloCreacionProceso;

	@Before
	
	public void setUp() throws Exception{
		
		
		ModuloCreacionProceso = new ModuloCreacionProceso(driver);
		driver = ModuloCreacionProceso.chromeDriverConnection();
		ModuloCreacionProceso.visit("https://app.psicoalianza.com/auth/loginvoc?username=Danielproduccion&password=danieleltravieso");
		
	}
 


	@Test
	public void test() throws InterruptedException {
	
		ModuloCreacionProceso.procesoCreacion();
		ModuloCreacionProceso.gestionarProceso();
		ModuloCreacionProceso.crearProceso();
		
		/*Completar informacion*/
		ModuloCreacionProceso.nombreProceso();
		ModuloCreacionProceso.setFechaCierre("31/07/2024");
		assertEquals(ModuloCreacionProceso.estadoDropdown(),"Activo");
		ModuloCreacionProceso.registroFotograficoApp();
		ModuloCreacionProceso.registroVideo();
		ModuloCreacionProceso.numeroVacantesApp();
		ModuloCreacionProceso.preferenciaMovil(true);
		ModuloCreacionProceso.continuarSelect();
		ModuloCreacionProceso.selectDropdownpruebas("Ethikos (Rectitud, honra, confidencialidad)");
		ModuloCreacionProceso.selectPerfil("Riesgos");
		ModuloCreacionProceso.porcentajePruebas("25");
        String valorActual = ModuloCreacionProceso.obtenerValorPorcentaje();
        assertEquals("25", valorActual);
		ModuloCreacionProceso.agregarPruebas();
		
		Thread.sleep(1000);
		/*Ethikos Riegos*/
		
		ModuloCreacionProceso.selectDropdownpruebas("Ethikos - Riesgos (Rectitud, honra, confidencialidad)");
		ModuloCreacionProceso.selectPerfil("Perfil Estandar");
		ModuloCreacionProceso.porcentajePruebas("10");
        String valorActual1 = ModuloCreacionProceso.obtenerValorPorcentaje();
        assertEquals("10", valorActual1);
		ModuloCreacionProceso.agregarPruebas();
		
		
		/*IQ Factorial*/
		ModuloCreacionProceso.selectDropdownpruebas("IQ Factorial (Capacidad intelectual)");
		ModuloCreacionProceso.selectPerfil("Alto");
		ModuloCreacionProceso.porcentajePruebas("10");
        String valorActual2 = ModuloCreacionProceso.obtenerValorPorcentaje();
        assertEquals("10", valorActual2);
		ModuloCreacionProceso.agregarPruebas();
		
		/*Potencial Comercial*/
		
		ModuloCreacionProceso.selectDropdownpruebas("Potencial Comercial (Caracter, Habilidades y Actitud para las ventas.)");
		ModuloCreacionProceso.selectPerfil("Nivel Alto");
		ModuloCreacionProceso.porcentajePruebas("10");
        String valorActual3 = ModuloCreacionProceso.obtenerValorPorcentaje();
        assertEquals("10", valorActual3);
		ModuloCreacionProceso.agregarPruebas();
		
		
		/*Prueba Estatal*/
		ModuloCreacionProceso.selectDropdownpruebas("Prueba Estatal (Competencias laborales generales para los empleos públicos de los distintos niveles jerárquicos.)");
		ModuloCreacionProceso.selectPerfil("Nivel Directivo");
		ModuloCreacionProceso.porcentajePruebas("15");
        String valorActual4 = ModuloCreacionProceso.obtenerValorPorcentaje();
        assertEquals("15", valorActual4);
		ModuloCreacionProceso.agregarPruebas();
		
		/*Ten DISC*/
		
		ModuloCreacionProceso.selectDropdownpruebas("Ten DISC (Personalidad, Competencias y Riesgos Laborales)");
		ModuloCreacionProceso.selectPerfil("Directivo");
		ModuloCreacionProceso.porcentajePruebas("10");
        String valorActual5 = ModuloCreacionProceso.obtenerValorPorcentaje();
        assertEquals("10", valorActual5);
		ModuloCreacionProceso.agregarPruebas();
		
	    /*Ten DISC Plus*/
		Thread.sleep(2000);
		ModuloCreacionProceso.selectDropdownpruebas("Ten DISC Plus (Personalidad, Riesgos, Competencias Transversales y Específicas.)");
		ModuloCreacionProceso.selectPerfil("Todas las competencias");
		ModuloCreacionProceso.porcentajePruebas("10");
        String valorActual6 = ModuloCreacionProceso.obtenerValorPorcentaje();
        assertEquals("10", valorActual6);
		ModuloCreacionProceso.agregarPruebas();
		
	    /*V & P Test*/
		
		ModuloCreacionProceso.selectDropdownpruebas("V&P Test (Precisión y velocidad al digitar)");
		ModuloCreacionProceso.selectPerfil("Perfil Alpha");
		ModuloCreacionProceso.porcentajePruebas("10");
        String valorActual7 = ModuloCreacionProceso.obtenerValorPorcentaje();
        assertEquals("10", valorActual7);
		ModuloCreacionProceso.agregarPruebas();
		ModuloCreacionProceso.guardarBtn();
		ModuloCreacionProceso.aceptarBtn();
		
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	
	

}
