package com.Qa.Automatizacion;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ModuloMasivasHistorial extends Base{
	


	//private WebDriver driver;
    private BrowserMobProxy proxy;
    // Localizadores de envio masivo de correo
    
	By  procesoSeleccion = By.xpath("//a[span='Procesos de Selección']");
	By buttonHistorial = By.xpath("//a[contains(text(), 'Historial Agendamientos')]");
	By checkid = By.id("selTodos");
	By masivoCorreos = By.xpath("//button[contains(@onclick,'enviarCorreosMasico()' )]");
	By aceptarMasivo = By.xpath("//button[contains(@class,'swal2-confirm btn btn-primary mx-2' )]");
	// Aceptar Masivo
    By locatorEnvio =  By.xpath("//div[@class ='swal2-popup swal2-modal swal2-icon-success swal2-show']");
	By aceptMasivo = By.xpath("//button[@class ='swal2-confirm btn btn-primary mx-2']");
	
	//Localizadores de Procesar pruebas Masivas.
	By clickProcesar = By.xpath("//button[@onclick=\"procesarMasivo()\"]");
	By locatorModalProcess = By.xpath("//div[@class = 'ui-dialog-content ui-widget-content']");
	By cofimarLocator = By.xpath("//button[@class ='btn btn-alianza btn-small']");
	
	//Localizadores de Editar Agendamientos.
	By clickAgendamineto = By.xpath("//button[@onclick=\"reprogramarMasivo()\"]");
	By clickCalendario =  By.xpath("(//button[@class=\"btn btn-outline-secondary\"])[4]");
	
	//Localizador calendario.
	
	By sigueinteMes = By.xpath("(//th[@class = 'next'])[1]");
	By guardarcambios = By.xpath("//button[@class = 'btn btn-alianza btn-small']");
	
	
	//Localizadores para eliminar agendas.
	
	By eliminaragendas = By.xpath("//button[@onclick=\"eliminarMasivo()\"]");
    By idDelete = By.id("textEliminar");
    By buttonDelete = By.xpath("//button[@class=\"btn btn-alianza btn-small\"]");
    
	
	public ModuloMasivasHistorial(WebDriver driver) {
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
	
	public void checkClic() {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkid));	
		
		click(checkid);
	}
	
	public void reenviarCorreos() {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(masivoCorreos));
		
		click(masivoCorreos);	
	}
	
	public void aceptarEnvios() {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(aceptarMasivo));	
		
		click(aceptarMasivo);
	}
/*	
	   // Constructor: Inicia el navegador y el proxy
    public void PaginaProcesos() {
        // Inicia el proxy
        proxy = new BrowserMobProxyServer();
        proxy.start(0);

        // Configura el proxy para Selenium
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        ChromeOptions options = new ChromeOptions();
        options.setProxy(seleniumProxy);

        // Inicia el WebDriver con el proxy configurado
        driver = new ChromeDriver(options);
    }

    // Método para navegar a la página
    public void navegarPagina(String url) {
        driver.get(url);
    }

    // Método para capturar la respuesta de red y validar
    public void validarRespuestaProcesarMasivo() {
        // Capturar la HAR (HTTP Archive) del tráfico de red
        proxy.newHar("procesarmasivo");

        // Filtrar la petición "procesarmasivo" y validar el código de estado
        proxy.getHar().getLog().getEntries().forEach(entry -> {
            if (entry.getRequest().getUrl().contains("procesarmasivo")) {
                int statusCode = entry.getResponse().getStatus();
                System.out.println("Código de estado: " + statusCode);
                
                // Validar que el código de estado sea 200
                if (statusCode != 200) {
                    throw new AssertionError("El código de estado no es 200. Es: " + statusCode);
                }
            }
        });
    }
 */   
    public void testMasivo () {
    	
    	WebDriverWait wait =  new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(locatorEnvio));
    	
    	click(aceptMasivo);
    	
    }
    
    public void testProcesar () {
    	click(clickProcesar);
    	WebDriverWait wait = new WebDriverWait (driver,20);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(locatorModalProcess));
    	
    	click(cofimarLocator);
    }
    
    public void validarProcesar() {
    	
    	
    	
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(locatorEnvio));
    	
    	click(aceptMasivo);
    	
    }
    
    public void selectMes () {
    	
    	WebDriverWait wait =  new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(clickAgendamineto));
    	
    	click(clickAgendamineto);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(clickCalendario));
    	click(clickCalendario);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(sigueinteMes));
    	click(sigueinteMes);
    
    	
    
    
    	
    }
    

    public void seleccionarDia(String dia) {
        // Localizador dinámico para seleccionar el día deseado en el calendario
        By seleccionarDia = By.xpath("//td[@data-action='selectDay' and text()='" + dia + "']");
        
        // Espera hasta que el día esté visible y luego haz clic
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(seleccionarDia));

        // Hacer clic en el día seleccionado
        driver.findElement(seleccionarDia).click();
    }
    
    
    public void guardarFecha() throws InterruptedException {
    	
    	click(guardarcambios);
    	Thread.sleep(3000);
    }
    
    public void eliminarAgendas () {
    	
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(eliminaragendas));
    	
    	click(eliminaragendas);
    }

    
	public void deleteInput (String delete) { 
		
		aplicarFiltroApp(idDelete,delete);
	}
	
	public void eliminar() {
		
	
		click(buttonDelete);
		
	}

	public void aceptarAlert () throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.alertIsPresent());

	    // Cambiar el foco al alert y aceptarlo
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
		
	}


}
