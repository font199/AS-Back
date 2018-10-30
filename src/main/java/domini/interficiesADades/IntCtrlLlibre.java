package domini.interficiesADades;

/* Imports de la classe */
import javax.persistence.EntityManager;

import dades.excepcions.*;
import domini.model.*;

/* Capa de Dades */
public interface IntCtrlLlibre {
	
	public Llibre obte(EntityManager em, String isbnLl) throws LlibreNoExisteix;
	
	public Boolean existeix(EntityManager em, String isbnLl) throws LlibreNoExisteix;
	
	/* public Collection<Llibre> tots() throws BDException; */
}