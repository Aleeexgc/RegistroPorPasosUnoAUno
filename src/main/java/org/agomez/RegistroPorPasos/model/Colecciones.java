package org.agomez.RegistroPorPasos.model;

import java.util.LinkedHashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Colecciones {
	
	public static LinkedHashMap<String,String[]> datosNavegacion = new LinkedHashMap<String,String[]>();
	public static SortedMap<String, String> listaGenerosOrdenada = new TreeMap<String, String>();
	public static SortedMap<String, String> nacionalidades = new TreeMap<String, String>();
	public static SortedMap<String, String> departamentos = new TreeMap<String, String>();

	static {
		
		datosNavegacion.put("1", new String[]{"datosPersonales", "Number-1-icon.png", "/registro/datosPersonales"});
		datosNavegacion.put("2", new String[]{"datosProfesionales", "Number-2-icon.png", "/registro/datosProfesionales"});
		datosNavegacion.put("3", new String[]{"datosBancarios", "Number-3-icon.png", "/registro/datosBancarios"});	
		datosNavegacion.put("4", new String[]{"resumen", "checkered-flag-icon.png", "/registro/resumen"});
		
		listaGenerosOrdenada.put("F", "Fluido");
		listaGenerosOrdenada.put("H", "Hombre");
		listaGenerosOrdenada.put("M", "Mujer");
		listaGenerosOrdenada.put("O", "Otro");
		
		nacionalidades.put("AN", "Andorrana");
		nacionalidades.put("ES", "Española");
		nacionalidades.put("FR", "Francesa");
		nacionalidades.put("IT", "Italiana");
		nacionalidades.put("PT", "Portuguesa");
		
		departamentos.put("C", "Compras");
		departamentos.put("F", "Finanzas");
		departamentos.put("M", "Marketing");
		departamentos.put("V", "Ventas");
	}

}
