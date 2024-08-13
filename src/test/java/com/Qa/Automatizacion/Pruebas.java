package com.Qa.Automatizacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Pruebas {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Ruta a tu WebDriver, por ejemplo, ChromeDriver
        System.setProperty("webdriver.chrome.driver", "ruta/a/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://mail.google.com/");
    }

    @Test
    public void testAbrirCorreo() {
        // Iniciar sesión en Gmail (reemplazar con los selectores apropiados)
        WebElement campoCorreo = driver.findElement(By.id("identifierId"));
        campoCorreo.sendKeys("riocardoperez@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        // Agregar una espera o un sleep aquí para que aparezca el campo de la contraseña

        WebElement campoContraseña = driver.findElement(By.name("password"));
        campoContraseña.sendKeys("Daniel123+");
        driver.findElement(By.id("passwordNext")).click();
        // Agregar una espera o un sleep aquí para que el inicio de sesión se complete

        // Buscar el correo por asunto
        WebElement cajaBusqueda = driver.findElement(By.name("q"));
        cajaBusqueda.sendKeys("Agendamiento de Prueba");
        cajaBusqueda.submit();
        // Agregar una espera o un sleep aquí para que los resultados de la búsqueda carguen

        // Abrir el correo
        WebElement correo = driver.findElement(By.xpath("//span[text()='Agendamiento de Prueba']"));
        correo.click();

        // Validar el contenido, por ejemplo, asegurarse de la presencia de texto específico
        WebElement contenidoCorreo = driver.findElement(By.cssSelector("div.clase-del-contenido-del-correo"));
        assert(contenidoCorreo.getText().contains("texto esperado"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
