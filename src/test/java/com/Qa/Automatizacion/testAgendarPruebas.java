package com.Qa.Automatizacion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class testAgendarPruebas {

    private WebDriver driver;
	private ModuloAgendarPruebas ModuloAgendarPruebas;
	
	@Before
	public void setUp() throws Exception {
		
		ModuloAgendarPruebas = new ModuloAgendarPruebas(driver);
		driver = ModuloAgendarPruebas.chromeDriverConnection();
		ModuloAgendarPruebas.visit("https://app.psicoalianza.com/auth/loginvoc?username=Danielproduccion&password=danieleltravieso");
		
	}

	@Test
	public void test() throws InterruptedException {
		
		ModuloAgendarPruebas.procesoCreacion();
		ModuloAgendarPruebas.gestionarProceso();
		ModuloAgendarPruebas.vermasApp(); 
		ModuloAgendarPruebas.agendarPrueba();
		ModuloAgendarPruebas.selectPais("Colombia");
		ModuloAgendarPruebas.tipoDocumentoBtn("Cédula de Ciudadanía");
		ModuloAgendarPruebas.documentoAgen();
		ModuloAgendarPruebas.emnailsAgen();
		ModuloAgendarPruebas.agendarCanditado();
		ModuloAgendarPruebas.cargaMasivaBtn();
		ModuloAgendarPruebas.archivoDesQa();
		ModuloAgendarPruebas.subirArchivo("C:\\Users\\danie\\eclipse-workspace\\AutomatizacionAppAnterior\\Archivos\\PsicoAlianza_Carga_Masiva_Candidatos.xlsx");
		ModuloAgendarPruebas.enviarBtn();
		ModuloAgendarPruebas.agendarBtnApp();
		ModuloAgendarPruebas.confirmarAgendamiento();
	}
	
	@After
	public void tearDown() throws Exception {
		
	}



}
