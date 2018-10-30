package domini.interficiesADades;


/* Imports de la classe */

import dades.controladorsDeDades.*;

/* Capa de Dades */
public class CtrlFabrica {
	
	 private static IntCtrlBiblioteca icb;
	 private static IntCtrlExemplar ice;
	 private static IntCtrlLlibre icll;
	 private static IntCtrlSoci ics;
	
	 /* un constructor privat evita que des de fora se'n crei més d'una instància */
	 /* l'únic objecte es crea des de dins */		
	 private CtrlFabrica() { 
		 icb = new CtrlBiblioteca();
		 ice = new CtrlExemplar();
		 icll = new CtrlLlibre();
		 ics = new CtrlSoci();
	 	}
	
	 public static CtrlFabrica obteCtrlFabrica() {
		 return new CtrlFabrica(); 
	 }
	 
	 public static IntCtrlBiblioteca obteCtrlBiblioteca() {
		 return icb;
	 }
	 
	 public static IntCtrlExemplar obteCtrlExemplar() {
		 return ice;
	 }
	 
	 public static IntCtrlLlibre obteCtrlLlibre() {
		 return icll;
	 }
	 
	 public static IntCtrlSoci obteCtrlSoci() {
		 return ics;
	 }
	
}