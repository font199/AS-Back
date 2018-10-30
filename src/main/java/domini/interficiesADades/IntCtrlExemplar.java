package domini.interficiesADades;

/* Imports de la classe */

import javax.persistence.EntityManager;

import dades.excepcions.*;
import domini.model.*; 

/* Capa de Dades */
public interface IntCtrlExemplar {
	
	public Exemplar obte(EntityManager em, String isbnLl, String nomB) throws ExemplarNoExistBiblio;
	
	public Boolean existeix(EntityManager em, String isbnLl, String nomB) throws ExemplarNoExistBiblio;
	
	/* public Collection<Exemplar> tots() throws BDException; */
}