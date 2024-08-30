package com.Qa.Automatizacion;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testCrearProceso.class,testCrearProceso.class
	,  testEliminar.class
	, testEditar.class
	,testDuplicarProceso.class
	,testAgendarPruebas.class
	,testPruebaPotencial.class })
public class AllTests {

}
  