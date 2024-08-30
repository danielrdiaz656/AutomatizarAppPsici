package com.Qa.Automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FechaFinEditar extends Base {
	
	By procesoSeleccion = By.xpath("//a[span='Procesos de Selección']");
	By historialAgenda = By.linkText("Historial Agendamientos");
	
	By verMasButton = By.xpath ("//button[contains(@class,'btn btn-link text-dark')]");
	By verEditar = By.xpath("//a[@class='dropdown-item' and starts-with(@href, 'javascript:verEditarAgendamiento')]");
	By ubucacionModal = By.xpath("//div[@class='modal-header header-ver-editar']");
	// By editarFecha = By.id("fecha_final");
	By buttonFecha = By.xpath("//button[@class='btn btn-outline-secondary' and @title='Fecha Final']");
	By calendario = By.cssSelector("div.bootstrap-datetimepicker-widget.dropdown-menu.usetwentyfour.bottom");

	By editarFecha = By.id("fecha_final");
	By aceptarBurron = By.linkText("Aceptar");
	// = By.xpath("//button[@onclick= \"guardarVerEditar()\" and  @type= \"button\"]");
	
	public FechaFinEditar(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void procesoCreacion () throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(procesoSeleccion));
		click(procesoSeleccion);
	}
	
	public void gestionarProceso () {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(historialAgenda));
		click(historialAgenda);
	}
	
	public void vermasApp() {
		
		click(verMasButton);
		
	}
	
	public void editarClic() {
		
		click(verEditar);
		
	}
	
	public void seleccionarFecha(WebDriver driver, String fechaCompleta) throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, 10);

	    // Paso 1: Hacer clic en el botón del calendario para abrir el widget
	    wait.until(ExpectedConditions.elementToBeClickable(buttonFecha));
	    driver.findElement(buttonFecha).click();

	    // Paso 2: Esperar a que el calendario esté visible usando el nuevo localizador
	    wait.until(ExpectedConditions.visibilityOfElementLocated(calendario));

	    // Paso 3: Dividir la fecha en día, mes y año
	    String[] partesFecha = fechaCompleta.split("-");
	    String dia = partesFecha[2];  // Obtener el día de la fecha

	    // Paso 4: Seleccionar el día en el calendario visible
	    WebElement fecha = driver.findElement(By.xpath("//div[contains(@class,'bootstrap-datetimepicker-widget')]//td[@class='day' and text()='" + dia + "']"));
	    fecha.click();

	    // Verificar si la fecha se ha seleccionado correctamente
	    WebElement inputFechaFinal = driver.findElement(editarFecha);
	    String fechaSeleccionada = inputFechaFinal.getAttribute("value");
	    System.out.println("Fecha seleccionada: " + fechaSeleccionada);
	}

	
	public void ubucacionModalQa () {
		
		click(ubucacionModal);
		
	}
	
	
	public void acpertartCambio() {
		
		click(aceptarBurron);
		
	}
	
	
}
