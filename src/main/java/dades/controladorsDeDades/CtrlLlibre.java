package dades.controladorsDeDades;

import javax.persistence.EntityManager;

/* Imports de la classe */

import dades.excepcions.*;
import domini.interficiesADades.*;
import domini.model.*;

/* Capa de Dades */
public class CtrlLlibre implements IntCtrlLlibre{
	
	public Llibre obte(EntityManager em, String isbnLl) throws LlibreNoExisteix {
		Llibre ll = (Llibre) em.find(Llibre.class, isbnLl);
		if (ll == null) throw new LlibreNoExisteix();
		return ll;
	}
	
	public Boolean existeix(EntityManager em, String isbnLl) throws LlibreNoExisteix {
		Llibre ll = (Llibre) em.getReference(Llibre.class, isbnLl);
		if (ll == null) throw new LlibreNoExisteix();
		return true;
	}
	
	/* public static Llibre tots(String isbnLl) throws LlibreNoExisteix, BDException {
		Session se = BaseDeDades.donaSessio();
		Llibre ll = (Llibre) se.get(Llibre.class, isbnLl);
		if (ll == null) throw new LlibreNoExisteix();
		return ll;
	} */
}