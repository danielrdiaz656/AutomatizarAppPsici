package com.Qa.Automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModuloDuplicar extends Base {

	By procesoSeleccion = By.xpath("//a[span='Procesos de Selección']");
	By gestionarProceso = By.linkText("Gestionar procesos");
	By vermas = By.xpath("//button[contains (@class,'text-morado')]");
	
	By modalDuplicar = By.id("ui-id-1");
	By btnDuplicar = By.xpath("//a[contains(text(), 'Duplicar proceso')]");
	By nombreDuplicar = By.id("proceso_nombre");
	By fechaCierre = By.id("fecha_cierre");
	By enviar = By.xpath("//button[contains(text(), 'Enviar')]");
	
	
	By textduplicado = By.id("swal2-content");
	By aceptarDuplicado = By.xpath("//button[@class = 'swal2-confirm btn btn-primary mx-2']");
	
	
	public ModuloDuplicar(WebDriver driver) {
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
	
	public void duplictedBtn () {
		
		click(btnDuplicar);
		
	}
	
	public void nombreDuplicarProceso() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(modalDuplicar));
		
		WebElement nombre = findElement(nombreDuplicar);
		nombre.clear();
		type("Duplicado automatizado By Qa",nombreDuplicar);
		
		
		
	}
	
	
	public void changeDate (String foto) {
		
		WebElement cierre = driver.findElement(fechaCierre);
		cierre.click();
		cierre.clear();
		cierre.sendKeys(foto);
		cierre.sendKeys("\ue007");
		
			
		
	}
	
	
	
	public void enviarDuplicado () {
		
		click(enviar);
	
	}

	
	public void enviarText () {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(textduplicado));
		click(aceptarDuplicado);
	
	}

}
