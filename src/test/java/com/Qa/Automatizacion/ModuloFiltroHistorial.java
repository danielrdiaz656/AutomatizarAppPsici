package com.Qa.Automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModuloFiltroHistorial extends Base{
	
	By  procesoSeleccion = By.xpath("//a[span='Procesos de Selección']");
	By buttonHistorial = By.xpath("//a[contains(text(), 'Historial Agendamientos')]");
	
	
	/*Localizadores de Filtros*/
	
	By id = By.xpath("//input[contains(@class,'form-control') and contains(@placeholder, 'Buscar ID')]");
	By nombres = By.xpath("//input[contains(@class,'form-control') and contains(@placeholder, 'Buscar Nombres')]");
	By docummento = By.xpath("//input[contains(@class,'form-control') and contains(@placeholder, 'Buscar Documento')]");
	By correo = By.xpath("//input[contains(@class,'form-control') and contains(@placeholder, 'Buscar Correo')]");
	By proceso = By.xpath("//input[contains(@class,'form-control') and contains(@placeholder, 'Buscar Proceso')]");
	By prueba = By.xpath("//input[contains(@class,'form-control') and contains(@placeholder, 'Buscar Prueba')]");
	By fechaHistorial = By.xpath("//input[contains(@class,'form-control') and contains(@placeholder, 'Seleccione Fecha')]");
	
    By estado = By.xpath("//input[contains(@class,'form-control') and contains(@placeholder, 'Buscar Estado')]");
    
    
    /*Validacion de Filtros*/
    
    By validarId = By.xpath("//td[contains(@class, 'column-id_agenda')]//span[contains(@class, 'clipboard')]");
    By validarNombres = By.xpath("//td[@class='column-nombre' and not(descendant::input[@placeholder])]");
    By validarDocumentos = By.xpath("//td[@class='column-documento' and not(descendant::input[@placeholder])]");
    By validarEmail = By.xpath ("//td[@class='column-email' and not(descendant::input[@placeholder])]");
    By validarProceso = By.xpath("//td[@class='column-proceso_nombre' and not(descendant::input[@placeholder])]");
    By validarPrueba = By.xpath("//td[@class='column-prueba_nombre' and not(descendant::input[@placeholder])]");
    By validarFecha = By.xpath("//td[@class='column-created_at' and not(descendant::input[@placeholder])]");
	By de1Fecha = By.xpath("(//input[@class = 'input-mini'])[1]");
	By a1Fecha = By.xpath("(//input[@class = 'input-mini'])[2]");
	By tresBoton = By.xpath("(//button[@class='applyBtn btn btn-small btn-sm btn-primary'])[1]");
	
    By validarEstado = By.xpath("//td[@class='column-estado_nombre' and not(descendant::input[@placeholder])]");
    
    // paginado
    By paginado = By.xpath("//select[@name='Agendamieto[filters][records_per_page]']");
    By paginadoTextoLocator = By.cssSelector("span.showing_records");
    
    //Excel
    
    By excelPort = By.xpath("//button[@onclick = 'abrirModalExportar()']");
    By validarDescarExcel =  By.xpath("//h2[@class='page-header']//strong[contains(text(),'')]");
    By desacargarExcel = By.xpath("//button[@onclick = 'exportarTodas()']");
    
	public ModuloFiltroHistorial(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void procesoClic() {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(procesoSeleccion));
		
		click(procesoSeleccion);	
	}
	
	public void historialClic() {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(buttonHistorial));	
		
		click(buttonHistorial);
	}
	
	/*Validar Filtros Historial de Agendamiento*/
	
	// Id
	
	public void filtroId (String ids) { 
		
		aplicarFiltroApp(id,ids);
	}
	
	public void validarId  (String id) throws InterruptedException {
		
		validarFiltrado(validarId,id);
		
		
	}
	
	//Name
	
	
	public void filtroName (String name) {
		
		aplicarFiltroApp(nombres,name);
		
	}
	
	public void validarName (String name) throws InterruptedException {
		
		validarFiltrado(validarNombres,name);
		
		
	}
	
	//Documet
	
	public void filtroDocument (String document) {
		
		aplicarFiltroApp(docummento,document);
		
	}
	
	
	
	public void validaraDocumet (String documento) throws InterruptedException {
		
		validarFiltrado (validarDocumentos,documento);
		
		
	}
	
	// Correo
	public void filtroCorreo (String email) {
		
		aplicarFiltroApp(correo,email);
		
	}
	
	public void validaraCorreo (String correo) throws InterruptedException {
		
		validarFiltrado (validarEmail,correo);
		
		
	}
	// Proceso
	public void filtroProceso (String load) {
		
		aplicarFiltroApp(proceso,load);
	
	}
	
	
	public void validaraProceso (String proceso) throws InterruptedException {
		
		validarFiltrado (validarProceso,proceso);
		
		
	}
	
	//Prueba
	
	public void filtroPrueba (String test) {
		
		aplicarFiltroApp(prueba,test);
	}
	
	public void validaraPrueba (String prueba) throws InterruptedException {
		
		validarFiltrado (validarPrueba,prueba);
		
		
	}
	
	//Fecha
	
	public void finFiltros(String date) throws InterruptedException {
		
		metodoFechaFiltro(date,fechaHistorial,de1Fecha,a1Fecha,tresBoton);


	}
	
	public void validaraFecha (String fecha) throws InterruptedException {
		
		validarFiltrado (validarFecha,fecha);
		
		
	}
	
	//estado
	public void filtroEstado (String status) {
		
		aplicarFiltroApp(estado,status);
		
	}
	
	public void validarEstado (String estado) throws InterruptedException {
		
		validarFiltrado (validarEstado,estado);
		
		
	}
	
	// Paginado 
	
	public String paginadoHistorial (String paginados) {
		
		return paginadoSele(paginados,paginado);
		
	}
	
	public void validarTextoPaginado(int registrosPorPagina) {
		
		
		   validarPaginado(registrosPorPagina,paginadoTextoLocator);

		}
	
	// Descargar Excel
	
	public void descargarExcel () {
		
		
		click(excelPort);
		
		
	}
	
	public void downloads () {
		
		
		click(desacargarExcel);
		
		
	}
	
	public void validarExcel (String mensaje) throws InterruptedException {
		
		validarFiltrado(validarDescarExcel,mensaje);
		
	}
	

	
	
	
}
