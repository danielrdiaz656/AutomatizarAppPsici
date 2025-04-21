package com.Qa.Automatizacion;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	testCrearProceso.class,
	testCrearProceso.class,
	testEliminar.class
	 ,testEditar.class
	,testAgendarPruebas.class
	,testDuplicarProceso.class
	,testPruebaPotencial.class
	,testFiltroProceso.class
	,testFiltroHistorial.class
	,testMasivoHistorial.class
	})
public class AllTests {

}
  