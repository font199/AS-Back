package dades.controladorsDeDades;

import javax.persistence.EntityManager;

/* Imports de la classe */

import dades.excepcions.*;
import domini.interficiesADades.*;
import domini.model.*;

/* Capa de Dades */
public class CtrlSoci implements IntCtrlSoci{
	
	public Soci obte(EntityManager em, String nomS) throws SociNoExisteix {
		Soci so = (Soci) em.find(Soci.class, nomS);
		if (so == null) throw new SociNoExisteix();
		return so;
	}
	
	public Boolean existeix(EntityManager em, String nomS) throws SociNoExisteix {
		Soci so = (Soci) em.getReference(Soci.class, nomS);
		if (so == null) throw new SociNoExisteix();
			else return true;
	}
	
	/* public Collection<Soci> tots() throws BDException {
		Session se = BaseDeDades.donaSessio();
		List sS = se.createCriteria(Soci.class).list();
		return Arrays.asList(sS);
		Soci[] sS = (Soci[]) se.createCriteria(Soci.class).add(Restrictions.eq("nomI",nomB)).list().toArray(); 
	}*/
}