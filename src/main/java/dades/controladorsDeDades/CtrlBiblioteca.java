package dades.controladorsDeDades;

/* Imports de la classe */
import java.util.*;

import javax.persistence.*;
import javax.persistence.criteria.*;

import dades.excepcions.*;
import domini.interficiesADades.*;
import domini.model.Biblioteca;
import domini.model.Instalacio;
//import serveisComuns.baseDeDades.*;

/* Capa de Dades */
public class CtrlBiblioteca implements IntCtrlBiblioteca {
	
	public Biblioteca obte(EntityManager em, String nomB) throws BibliotecaNoExisteix {
			Biblioteca bib = (Biblioteca) em.find(Biblioteca.class, nomB);
			if (bib == null) throw new BibliotecaNoExisteix();
			return bib;
	}
	
	public Boolean existeix(EntityManager em, String nomB) throws BibliotecaNoExisteix{
		Biblioteca bib = (Biblioteca) em.getReference(Biblioteca.class, nomB);
		if (bib == null) throw new BibliotecaNoExisteix();
		return true;
	}
	
	public List<Biblioteca> obteTotes(EntityManager em) {
		List<Biblioteca> bibs = em.createQuery("select b from Biblioteca b", Biblioteca.class).getResultList();
		return bibs;
	}
	
	/* M�tode que s'hauria d'usar SENSE operacions arbitr�ries de consultes en els controladors*/
	/*public List<Biblioteca> tots(Gestor g, EntityManager em) {
		List<Biblioteca> sBibs;	
		System.out.println("111");
		CriteriaBuilder builder = g.getBuilder();
		System.out.println("222");
		CriteriaQuery criteriaQuery = builder.createQuery();
		System.out.println("333");
		Root<Biblioteca> bib = criteriaQuery.from(Biblioteca.class);
		System.out.println("444");
		criteriaQuery.select(bib);
		System.out.println("555");
		criteriaQuery.where(builder.equal(bib.get("publica"),true));
		System.out.println("666");
		Query query = em.createQuery(criteriaQuery);
		System.out.println("777");
		sBibs = query.getResultList();
		System.out.println("888");
		if(sBibs.size() > 0) return sBibs;
		return null;
	} */
	
	/* M�tode que s'hauria d'usar AMB operacions arbitr�ries de consultes en els controladors*/
	/* public Set<Biblioteca> obteQuantsSocis(EntityManager em) throws BDException {
		HashSet<Biblioteca> totesLesBiblioteques;
		totesLesBiblioteques = (<Biblioteca>) em.createQuery("SELECT i.nomI as nomInst, i.adreca as adrecaInst, "+
				" b.publica as publica "+
				" FROM instalacio i, biblioteca b "+
				" WHERE b.nomB = nomI ").addEntity(Instalacio.class).addEntity(Biblioteca.class);
		if(totesLesBiblioteques.size() > 0) return totesLesBiblioteques;
		return null;
	} */
	
}