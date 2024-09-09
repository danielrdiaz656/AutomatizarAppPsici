package com.Qa.Automatizacion;

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
    
	By  procesoSeleccion = By.xpath("//a[span='Procesos de Selección']");
	By buttonHistorial = By.xpath("//a[contains(text(), 'Historial Agendamientos')]");
	By checkid = By.id("selTodos");
	By masivoCorreos = By.xpath("//button[contains(@onclick,'enviarCorreosMasico()' )]");
	By aceptarMasivo = By.xpath("//button[contains(@class,'swal2-confirm btn btn-primary mx-2' )]");

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
	
	
	

}
