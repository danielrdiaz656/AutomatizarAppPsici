package com.Qa.Automatizacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class testPruebaEstatal {

    private WebDriver driver;
    private pruebaEstatal pruebaEstatal;


    @Before
    public void setUp() throws Exception {
        System.out.println("Qa1");
        pruebaEstatal = new pruebaEstatal(driver);
        driver = pruebaEstatal.chromeDriverConnection();
        if (driver == null) {
            System.out.println("Error: El WebDriver no se inicializó correctamente.");
            return;
        }
        System.out.println("Qa2");
        pruebaEstatal.visitGoogle("https://accounts.google.com/");
        Thread.sleep(1000);
        System.out.println("Qa3");
        Thread.sleep(1000);
        System.out.println("Qa4");
        driver.get("https://mail.google.com/mail/u/0/#inbox");
        System.out.println("Qa5");

    }



    @Test
    public void test() throws InterruptedException {

        pruebaEstatal.correoFirts();
        pruebaEstatal.comenzarQa();
        pruebaEstatal.potencialTestStart();
        pruebaEstatal.activarCamara();
        pruebaEstatal.continuarPrueba();
        pruebaEstatal.tomarFotoQa();
        pruebaEstatal.continuarPrueba();

        for (int porcentaje = 13; porcentaje <= 100; porcentaje += 6) {
            pruebaEstatal.seleccionarTodasLasA();
            pruebaEstatal.continuarQaTest();
        }


        pruebaEstatal.finTest();

    }


    @After
    public void tearDown() throws Exception {



    }


}
