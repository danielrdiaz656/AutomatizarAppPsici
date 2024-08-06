package com.Qa.Automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModuloEliminar extends Base {
	

	By procesoSeleccion = By.xpath("//a[span='Procesos de Selección']");
	By gestionarProceso = By.linkText("Gestionar procesos");
	By vermas = By.xpath("//button[contains (@class,'text-morado')]");
	
	
	By eliminarBtn = By.xpath("//a[contains(@href, 'javascript:eliminarProceso') and contains(text(), 'Eliminar proceso')]");
	By alertAceptarEliminar = By.xpath("//div[@aria-labelledby = 'swal2-title']");
    By  aceptarEliminar = By.xpath("//button[@class = 'swal2-confirm btn btn-primary mx-2']");

    
	public ModuloEliminar(WebDriver driver) {
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
	
	public void editarclickApp() {
		
		click(eliminarBtn);
		
	}
	
	public void alertAceptar() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(alertAceptarEliminar));
		
		click(alertAceptarEliminar);
		
	}
    
	public void aceptarBtn () {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(aceptarEliminar));
		
		click(aceptarEliminar);
		
	}
	
    
}
