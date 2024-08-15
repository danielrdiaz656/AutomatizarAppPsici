package com.Qa.Automatizacion;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModuloCreacionProceso extends Base {
	
	By procesoSeleccion = By.xpath("//a[span='Procesos de Selección']");
	By gestionarProceso = By.linkText("Gestionar procesos");
    By crearProcesoButton = By.linkText("Crear proceso");
    
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
    
    
    /*Localizador Pruebas*/
    
    By pruebasLocator = By.xpath("//h6[text()='Pruebas']");
    By seleccionarPrueba = By.id("prueba");
    By seleccionarPerfil = By.id("perfil");
    By porcentualPrueba =  By.cssSelector("input[placeholder='Ingrese el valor de la prueba en porcentaje']");
    By agregarPorcentaje = By.xpath("//button[@onclick='agregarPrueba()']");
    
	By agregarPrueba = By.xpath("//button[contains(@class, 'btn-tertiary') and contains(@onclick,'agregarPrueba()' )]");
   
	By guardarId = By.id("btn_crear");
	By AcptarProceso = By.xpath("//button[contains (@class,'swal2-confirm')]");

	
	
	
	public ModuloCreacionProceso(WebDriver driver) {
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
	
	public void crearProceso () {
		
		click(crearProcesoButton);
	}
	
	/*completarInformacion*/
	public void nombreProceso () throws InterruptedException{
		
		Thread.sleep(1000);
		type("Prueba Automatizada Qa",nameLocator);

		
	}
	
    public void setFechaCierre(String fecha) {
        WebElement fechaCierreInput = driver.findElement(By.id("fecha_cierre"));
        fechaCierreInput.click();
        fechaCierreInput.clear();
        fechaCierreInput.sendKeys(fecha);
        fechaCierreInput.sendKeys("\ue007"); 
    }
    
    public void numeroVacantesApp() {
    	
    	type("1",numeroVacantes);
    	
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
   
   public void selectDropdownpruebas(String test) {
	   
	   /*WebDriverWait wait = new WebDriverWait(driver,10);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(pruebasLocator));
	   
	   Select selectlsit = new Select(findElement(seleccionarPrueba));
	   selectlsit.selectByVisibleText("Ethikos (Rectitud, honra, confidencialidad)");
	   return getText(selectlsit.getFirstSelectedOption());*/
	   
	   selectPruebasApp(test);
	   
   }
   
   
   public void selectPerfil(String prueba) throws InterruptedException {
	   Thread.sleep(1500);
	   perfilApp(prueba);
	   
   }
   
   public void porcentajePruebas (String porcentaje) {
	   WebElement test = findElement(porcentualPrueba);
	   test.clear();
	   type(porcentaje,porcentualPrueba);
      
	   
   
   }
   
   public String obtenerValorPorcentaje() {
       return driver.findElement(porcentualPrueba).getAttribute("value");
   }
   
   
   public void agregarPruebas() {
	   
	   click(agregarPrueba);
	   
   }
   
   public void guardarBtn() {
	   
	   click(guardarId);
	   
   }
   
   public void aceptarBtn () {
	   
		 WebDriverWait wait = new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(AcptarProceso));
		 
	   click(AcptarProceso);
	   
   }
   
   
   
   
   
}

