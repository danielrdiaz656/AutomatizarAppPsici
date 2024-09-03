package com.Qa.Automatizacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModuloFiltroProceso extends Base {
	
	By  procesoSeleccion = By.xpath("//a[span='Procesos de Selección']");
	By  gestionarProceso = By.linkText("Gestionar procesos");
	
	/*Campos de Filtro*/

	By idFiltro = By.name("Procesos[filters][id_proceso-like]");
	By nameFiltro = By.name("Procesos[filters][proceso_nombre-like]");
	By responsableFiltro = By.name("Procesos[filters][creador-like]");
	/*Localizadores de Fecha Inicio*/
	By creatFiltro = By.name("Procesos[filters][created_at]");
	By deFecha = By.xpath("(//input[@class = 'input-mini'])[1]");
	By aFecha = By.xpath("(//input[@class = 'input-mini'])[2]");
	By segundoBoton = By.xpath("(//button[@class='applyBtn btn btn-small btn-sm btn-primary'])[1]");
	

	/*Localizadores de Fecha Fin*/
	By finFiltro = By.name("Procesos[filters][fecha_cierre]");
	By de1Fecha = By.xpath("(//input[@class = 'input-mini'])[3]");
	By a1Fecha = By.xpath("(//input[@class = 'input-mini'])[4]");
	By tresBoton = By.xpath("(//button[@class='applyBtn btn btn-small btn-sm btn-primary'])[2]");
	
	
	
	/*Localizador vacante y estado*/
	By vacantesFiltro = By.name("Procesos[filters][numero-like]");
	By estadoFiltro = By.name("Procesos[filters][estado-like]");
	

	/*Validar el filtro*/
	
	By idValidacion = By.xpath("//td[@class='column-id_proceso' and not(descendant::input[@placeholder])]");
	By maneValidacion = By.xpath("//td[@class='column-proceso_nombre' and not(descendant::input[@placeholder])]");
	By responsableValidacion = By.xpath("//td[@class='column-creador' and not(descendant::input[@placeholder])]");
	By creatValidacion = By.xpath("//td[@class='column-created_at' and not(descendant::input[@placeholder])]");
	By finValidacion = By.xpath("//td[@class='column-fecha_cierre' and not(descendant::input[@placeholder])]");
	By vacantesValidacion = By.xpath("//td[@class='column-numero' and not(descendant::input[@placeholder])]");
	By estadoValidacion = By.xpath("//td[@class='column-estado' and not(descendant::input[@placeholder])]");
	
	/*Localizadores paginado*/
	
	By paginadoQa = By.xpath("//select[@name='Procesos[filters][records_per_page]']");
	
	By paginadoTextoLocator = By.cssSelector("span.showing_records");
	
	
	
	/*Localizadores Exportar Excel*/
	By descargarExcel = By.id("label-exportar"); 
	
	
	
	
	public ModuloFiltroProceso(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void procesoClic () {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(procesoSeleccion));
		
		click(procesoSeleccion);
		
	}
	
	public void gestionarClic () {
		
		WebDriverWait wait =  new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(gestionarProceso));
		
		click(gestionarProceso);
		
	}
	
	/*Validacion Filtros Seleccion*/
	
	//Valida ID
	public void idFiltros (String id) {
		
		aplicarFiltroApp(idFiltro,id);
		
	}
	
	public void validarValorId(String idEsperado) throws InterruptedException {

		validarFiltrado(idValidacion,idEsperado);
		
		
	}
	
	//Valida Nombres
	public void nameFiltros(String name) throws InterruptedException {

		aplicarFiltroApp(nameFiltro,name);

	}
	
	
	public void validarName(String nameEsperado) throws InterruptedException {

		validarFiltrado(maneValidacion,nameEsperado);
		
		
	}
	
	// Valida Responsable
	public void responsableFiltros(String name) throws InterruptedException {

		aplicarFiltroApp(responsableFiltro,name);

	}
	
	
	public void validarresponsable(String nameEsperado) throws InterruptedException {

		validarFiltrado(responsableValidacion,nameEsperado);
		
		
	}
	
	// Valida fecha Creacion
	public void creacionFiltros(String creacion) throws InterruptedException {
		
		metodoFechaFiltro(creacion,creatFiltro,deFecha,aFecha,segundoBoton);


	}
	
	
	public void validarresCreacion(String nameEsperado) throws InterruptedException {

		validarFiltrado(creatValidacion,nameEsperado);
		
		
	}
	
	
	// Valida fecha Creacion
	public void finFiltros(String creacion) throws InterruptedException {
		
		metodoFechaFiltro(creacion,finFiltro,de1Fecha,a1Fecha,tresBoton);


	}
	
	
	public void validarresFin(String nameEsperado) throws InterruptedException {

		validarFiltrado(finValidacion,nameEsperado);
		
		
	}
	
	// Validar vacantes
	public void vacantesFiltros(String name) throws InterruptedException {

		aplicarFiltroApp(vacantesFiltro,name);

	}
	
	
	public void validarVacantes(String nameEsperado) throws InterruptedException {

		validarFiltrado(vacantesValidacion,nameEsperado);
		
		
	}
	
	// Validar Estados
	public void estadosFiltros(String name) throws InterruptedException {
			
		aplicarFiltroApp(estadoFiltro,name);
		click(estadoFiltro);
		Thread.sleep(1000);
		WebElement limpiar = driver.findElement(estadoFiltro);
		limpiar.clear();

	}
	
	
	public void validarEstados(String nameEsperado) throws InterruptedException {

		
		validarFiltrado(estadoValidacion,nameEsperado);

		
	}
	
	public String paginadoSeleccion(String paginado) {
		
		return paginadoSele(paginado,paginadoQa);
		
	}
	
	
	public void validarTextoPaginado(int registrosPorPagina) {
		
		
	   validarPaginado(registrosPorPagina,paginadoTextoLocator);

	}
	
	
	
	public void descargarExcel () {
		
		
		click(descargarExcel);
		
		
	}

}
