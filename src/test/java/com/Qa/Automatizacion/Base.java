package com.Qa.Automatizacion;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.springframework.beans.factory.annotation.Value;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


public class Base {

	//private static final Logger LOGGER = LoggerFactory.getLogger(Base.class);

	protected WebDriver driver;
	/// Automatizacion platafoma anterior....................
	
	//@Value("${apiKey}")
	//private String apiKey;
	
	
    // Declaración de los localizadores por defalult. 
	
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By registerBtnLocator = By.xpath("//input[@value='Iniciar sesión']");

    By select2Global = By.xpath("//textarea[@class='select2-search__field' and @role='searchbox']");
    By saveButtun = By.id("boton-guardar");
    
    /*Select para App*/
    
    By selectPrueba = By.id("prueba");
    By selectPerfil = By.id("perfil");
    
    /**/
    
    By usernameLocatorGoo = By.id("identifierId");
    By siguienteButton = By.xpath("//button//span[text()='Siguiente']");

    By passwordLocatorGoo = By.xpath("//input[@type='password' and @name='Passwd']");

    
    
	public Base(WebDriver driver) {
		this.driver = driver;
		
	}

	public WebDriver chromeDriverConnection() throws Exception {
		
        // Establecer la ruta a tu ejecutable de ChromeDriver
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");

        // Configurar ChromeOptions para personalizar ChromeDriver
        ChromeOptions options = new ChromeOptions();

        // Agregar argumentos a ChromeOptions
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-site-isolation-trials");
        options.addArguments("--disable-features=NetworkService,NetworkServiceInProcess");
        options.addArguments("--disable-features=VizDisplayCompositor");
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, como Gecko) Chrome/91.0.4472.124 Safari/537.36");
        options.addArguments("use-fake-ui-for-media-stream");

        // Inicializar ChromeDriver con las opciones configuradas
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
       // return driver;
		return driver;
        
	}
	
	public WebElement findElement(By locator) {
		
		return driver.findElement(locator);
		
	}
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
		
	}
	
	public String getText(WebElement element) {
		return element.getText();
		
	}
	
	
	public String getText(By locator) {
		
		return driver.findElement(locator).getText();
	}
	
	
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
		
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
		
	}
	
	public void click(WebElement element) {
		element.click();
		
	}
	
 // si el elemento esta listo para ser usado
    public Boolean isDisplayed(By locator) {
    	
    	try {
    		return driver.findElement(locator).isDisplayed();
    	} catch (org.openqa.selenium.NoSuchElementException e) {
    		
    		return false;
    		
    	}	 	
    	
    }
    // encargado de resivir la URL y abrir la pagina
    // Método que recibe la URL y abre la página, luego realiza el login si es necesario
    public void visit(String url) {
        driver.get(url);
        loginIfNeeded();
    }

    // Método para realizar el login si se detecta que la página de login está presente
    public void loginIfNeeded() {
        if (isDisplayed(usernameLocator) && isDisplayed(passwordLocator)) {
            type("Danielproduccion", usernameLocator);
            type("danieleltravieso", passwordLocator);
            click(registerBtnLocator);
        }
    }
    
    // Metodo para dar clic en el menu de pruebas
    
    public void pruebasbutton () {
    	
    	 WebElement button = driver.findElement(By.xpath("//a[contains(@class, 'list-primary') and @href='https://ats.psicoalianza.com/pruebas']"));
    	 button.click();
    }
    
    //Medoto para dar clic en Boton Guardar
    
    public void buttonGuardar() {
    	
    	click(saveButtun);
    	
    }
    
    // Metodo para dar clic en el boton de Editar 
    
    public void buttonEdit () throws InterruptedException {
    Thread.sleep(500);	
   	 WebElement button = driver.findElement(By.xpath("(//button[contains(@onclick, 'editar')])[1]"));
   	 button.click();
    	
    }
    
    
    
    // Metodo para dar clic en el boton de Borrar 
    
	
    public void buttonDelete () throws InterruptedException {
    	Thread.sleep(3000);
      	 WebElement button = driver.findElement(By.xpath("(//button[contains(@onclick, 'eliminar')])[1]"));
      	 button.click();
       	
       }
    
    public void DeleteAcepted () throws InterruptedException {
    	Thread.sleep(1000);
     	 WebElement button = driver.findElement(By.cssSelector("button.swal2-confirm.swal2-styled"));
     	 button.click();
      	
      }
    
    // Metodo para el select 2
    
    public void select2Global (String searchText, String optionText) throws InterruptedException {
    	
    	
             	 
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(select2Global));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchField);

        Thread.sleep(1000);      
        searchField.sendKeys(searchText);
        

        String enteredText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", searchField);
        By optionLocator = By.xpath("//li[contains(text(), '" + optionText + "')]");
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
      
        optionElement.click();
        
    	
    	
    }
    
    // Metodo para la lista  desplegable o Dropdown
    
    public void selectOptionFromDropdown(By dropdownLocator, String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));

        Select dropdown = new Select(driver.findElement(dropdownLocator));
        dropdown.selectByVisibleText(optionText);
    }
    
    // Select2 Dropdown.
    
    public void selectFromDropdown(By Select2Locator, String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Select2Locator));
        WebElement dropdown = driver.findElement(Select2Locator);
        dropdown.click(); 

        By optionLocator = By.xpath("//li[text()='" + optionText + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        WebElement option = driver.findElement(optionLocator);
        option.click(); 
        
    
    }
    
    /// Compoente para seleect 2 
    public void selectOptionFromDropdown2(By dropdownLocator, String optionText)  throws InterruptedException {
        System.out.println("Entra aqui...");
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Hacer clic en el dropdown para abrirlo
        WebElement dropdown = driver.findElement(dropdownLocator);
        dropdown.click();
        System.out.println("Dropdown abierto...");

        // Ubicar el campo de búsqueda dentro del dropdown y enviar texto
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='select2-search__field']")));
        searchField.sendKeys(optionText);
        // Esperar a que las opciones filtradas sean visibles y seleccionar la opción deseada
        By optionLocator = By.xpath("//li[contains(text(), '" + optionText + "')]");
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        option.click();
        Thread.sleep(500);
        System.out.println("Opción seleccionada: " + optionText);
    }
	
    
    /* Selecionable App listas desplegables
     */
	
    // Pruebas
    public String selectPruebasApp (String select) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(selectPrueba));
    	
    	Select selectPruebas = new Select(findElement(selectPrueba));
    	selectPruebas.selectByVisibleText(select);
    	return getText(selectPruebas.getFirstSelectedOption());
    	
    	
    	
    }
    
    // Perfiles
    
    public String perfilApp(String perfil) {
    	
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(selectPerfil));
    	
    	Select selectpefil = new Select(findElement(selectPerfil));
    	selectpefil.selectByVisibleText(perfil);
    	return getText(selectpefil.getFirstSelectedOption());
    	
    }

    /*Login Google*/
    
    
    public void visitGoogle(String url) throws InterruptedException {
        driver.get(url);
        loginIfNeededGoogle();
        Thread.sleep(2000);
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocatorGoo));
    	Thread.sleep(2000);
        loginIfNeededGooglepass();
    }

    // Método para realizar el login si se detecta que la página de login está presente

    public void loginIfNeededGoogle() {
        if (isDisplayed(usernameLocatorGoo)) {
            type("preutest2634548787rodrigo.lar@gmail.com", usernameLocatorGoo);
            click(siguienteButton);
        }
    }
    
    public void loginIfNeededGooglepass() {
        if (isDisplayed(passwordLocatorGoo)) {
            type("Daniel1234*", passwordLocatorGoo);
            click(siguienteButton);
        }
    }
    
    // Metodo para buscar localizador y dar clic al elemento al filtrar
    
    public void aplicarFiltroApp (By findLocater , String idFiltros)  {
    	
    	WebElement campofiltro = driver.findElement(findLocater);
    	campofiltro.clear();
    	campofiltro.sendKeys(idFiltros);
    	campofiltro.sendKeys(Keys.ENTER);    
    	
    }
    
    public void validarFiltrado (By valueLocator, String valorEsperado) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait (driver,10);
    	
    	// Espera que el localizaador con el elemento filtrado sea visible
    	WebElement valorFiltrado = wait.until(ExpectedConditions.visibilityOfElementLocated(valueLocator));
    	
    	// obtiene el texto con get y limpa espacios por si algo con trim
    	String valorActual = valorFiltrado.getText().trim();
    	//genera la validacion
    	assertEquals("El valor Filtrado no coincide",valorEsperado,valorActual);
    	
    	
    	
    }
    
    public void metodoFechaFiltro (String creacion, By locaterFiltro, By locater1, By locater2 , By aplicar) throws InterruptedException {
    	
		// Clic en el input de fecha
		click(locaterFiltro);
		
		// fecha de inicio 
		WebElement create1 = driver.findElement(locater1);		
		click(locater1);
		create1.clear();
		create1.sendKeys(creacion);
		// fecha fin
		WebElement create2 = driver.findElement(locater2);
		click(locater2);
		create2.clear();
		create2.sendKeys(creacion);	
		// Aplicar
		click(aplicar);
    	
    	
    }
    
    
    
    
    
}
