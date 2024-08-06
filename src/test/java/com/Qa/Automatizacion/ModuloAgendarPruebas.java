package com.Qa.Automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModuloAgendarPruebas extends Base {
	
	By procesoSeleccion = By.xpath("//a[span='Procesos de Selección']");
	By gestionarProceso = By.linkText("Gestionar procesos");
	By vermas = By.xpath("//button[contains (@class,'text-morado')]");
	By agendarPruebaBtn = By.xpath("//a[contains(@class,\"dropdown-item\") and contains(text(),'Agendar pruebas')]");
	By indicacionAgendas = By.xpath("//a[@class = 'btn btn-link']");
	By paisAgenda = By.id("pais");
	By tipoDocumento = By.id("tipo_documento");
	By numeroDocumento = By.id("documento");
	By emails = By.id("email");
	By agregarAgendas = By.id("agregar_candidato");
	
	/*Localizadores de carga masiva*/
	By cargaMasiva = By.xpath("//a[@onclick='cargaMasiva()']");
	By archivoDes = By.id("descarga");
	By subirArchivo = By.xpath("//label[@class = 'btn btn-light pb-1 border']");
	By enviarArchivo = By.xpath("//button[contains(@class, 'btn btn-primary pull-center') and contains(@onclick,'enviarArchivo()' )]");
	
	/*Enviar Pruebas*/
	
	By agendarBtn = By.xpath("//button[@onclick='agendar()']");
	By modalEnviado = By.xpath("//div[@class='modal-body']");
	By aceptarBtn = By.id("btn-to-historial");

	public ModuloAgendarPruebas(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void procesoCreacion () throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(procesoSeleccion));
		click(procesoSeleccion);
	}
	
	
	public void gestionarProceso () {
		
		click(gestionarProceso);
	}
	
	public void vermasApp() {
		
		click(vermas);
		
	}
	
	public void agendarPrueba () {
		
		click(agendarPruebaBtn);
		
	}
	
	public String selectPais (String pais) throws InterruptedException {
		
		 //Thread.sleep(1500);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(paisAgenda));
	
        Select selectpefil = new Select(findElement(paisAgenda));
        selectpefil.selectByVisibleText(pais);
        return getText(selectpefil.getFirstSelectedOption());
		
	}
	
	public String tipoDocumentoBtn (String tipo) throws InterruptedException {
	   Thread.sleep(1500);
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(tipoDocumento));		
		
	   Select selectpefil = new Select(findElement(tipoDocumento));
	   selectpefil.selectByVisibleText(tipo);
	   return getText(selectpefil.getFirstSelectedOption());

		
	}
	
	public void documentoAgen() {
		
		type("45011011",numeroDocumento);
		
	}
	
	public void emnailsAgen() {
		
		type("riocardoperez@gmail.com",emails);
		
	}
	
	public void agendarCanditado() {
		
		click(agregarAgendas);
		
	}
	
	public void cargaMasivaBtn() throws InterruptedException {
		Thread.sleep(1500);
		click(cargaMasiva);
		
	}

	
	public void archivoDesQa() throws InterruptedException {
		Thread.sleep(2000);
		click(archivoDes);
	
		
	}
	
	
	public void subirArchivo(String archivo) throws InterruptedException {
	
	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('input01').style.display='block';");
	WebElement fileInput = driver.findElement(By.id("input01"));
	fileInput.sendKeys(archivo);
		
	}
	
	public void enviarBtn () {
		
		click(enviarArchivo);
	}
	
	public void agendarBtnApp() throws InterruptedException {
		Thread.sleep(2000);
		click(agendarBtn);
		
	}
	
	
	public void confirmarAgendamiento() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(modalEnviado));
		
		click(aceptarBtn);
		
	}
	
	
}
