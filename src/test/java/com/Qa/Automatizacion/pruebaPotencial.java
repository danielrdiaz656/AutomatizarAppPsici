package com.Qa.Automatizacion;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pruebaPotencial extends Base {
	
	
	//By emailLocator = By.xpath("//tr[@jscontroller='ZdOxDb' and @jsmodel='nXDxbd' and @role='row' and @tabindex='-1']");
	By emailLocator = By.xpath("//span[@class=\"bog\"]");
	By comenzarTest = By.xpath("//div[contains(text(), 'Comenzar')]");
	By potencialTest = By.xpath("//tr[.//b[text()='Potencial Comercial']]//button");
	By camara = By.xpath("//button[text()='Activar Cámara ']");
	By continuar = By.id("btnContinuar");
	By tomarFoto = By.xpath("//button[@onclick='tomarFoto()']");
	By continuar1 = By.xpath("//button[@id='botonContinuar' and @onclick='getPaginaSiguiente(3)']");
	By finalizarPrueba = By.xpath("//button[text()='Evaluaciones asignadas']");
	

	public pruebaPotencial(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void correoFirts () throws InterruptedException {
	
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
	    click(emailLocator);
	    


	  /* 
	   WebDriverWait wait = new WebDriverWait(driver, 15);
	    WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(emailLocator)); 
	   * 
	   * 
	   * if (emailElement.isDisplayed() && emailElement.isEnabled()) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", emailElement);
	    } else {
	        System.out.println("El elemento no es interactuable.");
	    }*/
	}
	
	
	public void comenzarQa () {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(comenzarTest));
		click(comenzarTest);
		
	}
	
	public void potencialTestStart () throws InterruptedException {
		
	    Thread.sleep(5000);
	    
	    // Cambia a la nueva pestaña/ventana si se abre una
	    String originalHandle = driver.getWindowHandle();
	    Set<String> handles = driver.getWindowHandles();
	    for (String handle : handles) {
	        if (!handle.equals(originalHandle)) {
	            driver.switchTo().window(handle);
	            break;
	        }
	    }
	    
	    WebDriverWait wait = new WebDriverWait(driver, 20);

	    try {
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(potencialTest));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	        System.out.println("Antes");
	        element.click();
	        System.out.println("DEspues");
	    } catch (Exception e) {
	        System.out.println("Ocurrió un error al intentar hacer clic: " + e.getMessage());
	        e.printStackTrace();
	    }
		
	}


        
    
    public void activarCamara () {
    	
    	click(camara);
    	
    }
    
    
   public void continuarPrueba () throws InterruptedException {
    	Thread.sleep(1500);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(continuar));
    	click(continuar);
    	
    }
    
   public void tomarFotoQa () throws InterruptedException {
   	Thread.sleep(1500);
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(tomarFoto));
   	click(tomarFoto);
   	
   }
   
   public void continuarQaTest () throws InterruptedException {
	   	Thread.sleep(3500);
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    

	    try {
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(continuar1));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	        System.out.println("Antes");
	        element.click();
	        System.out.println("DEspues");
	    } catch (Exception e) {
	        System.out.println("Ocurrió un error al intentar hacer clic: " + e.getMessage());
	        e.printStackTrace();
	    }

	   	
	   }
   
   public void seleccionarTodasLasA() throws InterruptedException {
	   Thread.sleep(1500);
	   WebDriverWait wait = new WebDriverWait(driver, 30);
       // Encuentra todos los elementos que correspondan a la respuesta "A"
       List<WebElement> opcionesA = driver.findElements(By.xpath("//span[@class='letraCuadro' and text()='A']"));

       // Itera sobre cada opción "A" y haz clic en ella
       for (WebElement opcion : opcionesA) {
           opcion.click();
           Thread.sleep(500); 
       }
   }
    
   
   public void finTest () throws InterruptedException {
	   	Thread.sleep(1500);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(finalizarPrueba));
	   	click(finalizarPrueba);
	   	
	   }
	    
}
