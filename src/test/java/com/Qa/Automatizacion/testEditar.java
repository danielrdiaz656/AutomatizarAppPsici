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
		ModuloEditarProceso.setFechaCierre("02/10/2024");
		ModuloEditarProceso.numeroVacantesApp();
		ModuloEditarProceso.registroVideo();
		ModuloEditarProceso.registroVideo();
		ModuloEditarProceso.preferenciaMovil(true);
		ModuloEditarProceso.continuarSelect();
		
		/**Elimiar elementos de pruebas*/
		Thread.sleep(2000);
		
		ModuloEditarProceso.elimianrTipoPrueba();
		//ModuloEditarProceso.elimianrTipoPrueba();
		
		Thread.sleep(2000);
		
		// Ethikos
		
		ModuloEditarProceso.selectDropdownpruebas("Ethikos (Rectitud, honra, confidencialidad)");
		ModuloEditarProceso.selectPerfil("Riesgos");
		ModuloEditarProceso.porcentajePruebas("25");
        String valorActual = ModuloEditarProceso.obtenerValorPorcentaje();
        assertEquals("25", valorActual);
        ModuloEditarProceso.agregarPruebas();
		
		/*Ethikos Riegos*/
		
		ModuloEditarProceso.selectDropdownpruebas("Ethikos - Riesgos (Rectitud, honra, confidencialidad)");
		ModuloEditarProceso.selectPerfil("Perfil Estandar");
		ModuloEditarProceso.porcentajePruebas("10");
        String valorActual1 = ModuloEditarProceso.obtenerValorPorcentaje();
        assertEquals("10", valorActual1);
        ModuloEditarProceso.agregarPruebas();
		
		
		/*IQ Factorial*/
        ModuloEditarProceso.selectDropdownpruebas("IQ Factorial (Capacidad intelectual)");
        ModuloEditarProceso.selectPerfil("Alto");
        ModuloEditarProceso.porcentajePruebas("10");
        String valorActual2 = ModuloEditarProceso.obtenerValorPorcentaje();
        assertEquals("10", valorActual2);
        ModuloEditarProceso.agregarPruebas();
		
		/*Potencial Comercial*/
		
        ModuloEditarProceso.selectDropdownpruebas("Potencial Comercial (Caracter, Habilidades y Actitud para las ventas.)");
        ModuloEditarProceso.selectPerfil("Nivel Alto");
        ModuloEditarProceso.porcentajePruebas("10");
        String valorActual3 = ModuloEditarProceso.obtenerValorPorcentaje();
        assertEquals("10", valorActual3);
        ModuloEditarProceso.agregarPruebas();
		
		
		/*Prueba Estatal*/
        ModuloEditarProceso.selectDropdownpruebas("Prueba Estatal (Competencias laborales generales para los empleos públicos de los distintos niveles jerárquicos.)");
        ModuloEditarProceso.selectPerfil("Nivel Directivo");
        ModuloEditarProceso.porcentajePruebas("15");
        String valorActual4 = ModuloEditarProceso.obtenerValorPorcentaje();
        assertEquals("15", valorActual4);
        ModuloEditarProceso.agregarPruebas();
		
		/*Ten DISC*/
		
        ModuloEditarProceso.selectDropdownpruebas("Ten DISC (Personalidad, Competencias y Riesgos Laborales)");
        ModuloEditarProceso.selectPerfil("Directivo");
        ModuloEditarProceso.porcentajePruebas("10");
        String valorActual5 = ModuloEditarProceso.obtenerValorPorcentaje();
        assertEquals("10", valorActual5);
        ModuloEditarProceso.agregarPruebas();
		
	    /*Ten DISC Plus*/
		Thread.sleep(2000);
		ModuloEditarProceso.selectDropdownpruebas("Ten DISC Plus (Personalidad, Riesgos, Competencias Transversales y Específicas.)");
		ModuloEditarProceso.selectPerfil("Todas las competencias");
		ModuloEditarProceso.porcentajePruebas("10");
        String valorActual6 = ModuloEditarProceso.obtenerValorPorcentaje();
        assertEquals("10", valorActual6);
        ModuloEditarProceso.agregarPruebas();
		
	    /*V & P Test*/
		
        ModuloEditarProceso.selectDropdownpruebas("V&P Test (Precisión y velocidad al digitar)");
        ModuloEditarProceso.selectPerfil("Perfil Alpha");
		ModuloEditarProceso.porcentajePruebas("10");
        String valorActual7 = ModuloEditarProceso.obtenerValorPorcentaje();
        assertEquals("10", valorActual7);
        ModuloEditarProceso.agregarPruebas();
        ModuloEditarProceso.guardarBtn();
        ModuloEditarProceso.aceptarBtn();	 
	}

	@After
	public void tearDown() throws Exception {

		Thread.sleep(1000);
		driver.quit();	
		 
	}
}
