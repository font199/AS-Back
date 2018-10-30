package domini.interficiesADades;

/* Imports de la classe */
import javax.persistence.EntityManager;

import dades.excepcions.*;
import domini.model.*;

/* Capa de Dades */
public interface IntCtrlSoci {
	
	public Soci obte(EntityManager em, String nomS) throws SociNoExisteix;
	
	public Boolean existeix(EntityManager em, String nomS) throws SociNoExisteix;
	
	/* public Collection<Soci> tots() throws BDException; */

}