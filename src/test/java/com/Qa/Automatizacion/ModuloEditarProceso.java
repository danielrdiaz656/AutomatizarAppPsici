package com.Qa.Automatizacion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModuloEditarProceso extends Base {


	By procesoSeleccion = By.xpath("//a[span='Procesos de Selección']");
	By gestionarProceso = By.linkText("Gestionar procesos");
	By vermas = By.xpath("//button[contains (@class,'text-morado')]");
	By editarclick = By.xpath("//a[contains(@href, '/procesos/procesoseleccion/') and contains(text(), 'Editar proceso')]");
	
    /*Localizar y datos basicos de creacion de proceso*/
    
    By locatorProceso = By.linkText("Crear Proceso");
    By nameLocator = By.id("proceso_nombre");
    By fechaCierre = By.id("fecha_cierre");
    By numeroVacantes = By.id("numero_vacantes");
    By estado = By.id("estado");
    
    
    /*Localizadores Solicitud de verificación de identidad para candidatos*/
    
    By registroFotografico = By.id("verificacion_identidad");
    By registroVideo = By.id("grabacion_video");
    By movilLocator = By.xpath("//p[text()='Preferencias en móvil']");
    By opcionMovil = By.xpath("//div[text()='Registro fotográfico']/ancestor::label");
    By opcionVideo = By.xpath("//div[text()='Videograbación']/ancestor::label");
    By continuar = By.xpath("//button[@onclick='continuarOpcionCamara();']");
	
	
	public ModuloEditarProceso(WebDriver driver) {
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
		
		click(editarclick);
		
	}
	
	
	/*completarInformacion*/
	public void nombreProceso () throws InterruptedException{
		
		Thread.sleep(1000);
		type(" Edit By Daniel",nameLocator);

		
	}
	
    public void setFechaCierre(String fecha) {
        WebElement fechaCierreInput = driver.findElement(By.id("fecha_cierre"));
        fechaCierreInput.click();
        fechaCierreInput.clear();
        fechaCierreInput.sendKeys(fecha);
        fechaCierreInput.sendKeys("\ue007"); 
    }
    
    public void numeroVacantesApp() {
    	
    	WebElement vacantes = findElement(numeroVacantes);
    	vacantes.clear();
    	type("2",numeroVacantes);
    	
    }
	
	
	public String estadoDropdown() {
		
		WebElement dropdownList = findElement(estado);
		List<WebElement> options = dropdownList.findElements(By.tagName("option"));
		for (int i = 0; i < options.size(); i++) {
			if(getText(options.get(i)).equals("Activo")) {
			   click(options.get(i));
			}
		}
		
		String selectOption = "";
		for (int i = 0; i < options.size(); i++) {
			if(options.get(i).isSelected())
				selectOption = getText(options.get(i));
			
		}
		
		return selectOption;
	}
	
	public void registroFotograficoApp () {
		WebElement foto = findElement(registroFotografico);
		foto.clear();
		click(registroFotografico);
		
	}
	
	public void registroVideo() {
		
		click(registroVideo);
		
	}
	
   public void preferenciaMovil(boolean select) {
	   
	 WebDriverWait wait = new WebDriverWait(driver,10);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(movilLocator));
	 
	 if(select) {
		 click(opcionMovil);
      }else {
		 click(opcionVideo); 
	 }
	   
   }
	
   public void continuarSelect () {
	   
	   click(continuar);
	   
   }
   
	
}
