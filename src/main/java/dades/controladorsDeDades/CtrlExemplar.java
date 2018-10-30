package dades.controladorsDeDades;

import javax.persistence.EntityManager;

/* Imports de la classe */

import dades.excepcions.*;
import domini.interficiesADades.*;
import domini.model.*;

/* Capa de Dades */
public class CtrlExemplar implements IntCtrlExemplar{
	
	public Exemplar obte(EntityManager em, String isbnLl, String nomB) throws ExemplarNoExistBiblio {
		ExemplarPK pePK = new ExemplarPK(isbnLl,nomB);
		Exemplar ex = (Exemplar) em.find(Exemplar.class, pePK);
		if (ex == null) throw new ExemplarNoExistBiblio();
		return ex;
	}
	
	public Boolean existeix(EntityManager em, String isbnLl, String nomB) throws ExemplarNoExistBiblio{
		ExemplarPK pePK = new ExemplarPK(isbnLl,nomB);
		Exemplar ex = (Exemplar) em.getReference(Exemplar.class, pePK);
		if (ex == null) throw new ExemplarNoExistBiblio();
		return true;
	}
	
	/* public Boolean tots() throws BDException {
		
	}*/
}