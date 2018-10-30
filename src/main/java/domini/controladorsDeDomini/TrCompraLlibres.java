package domini.controladorsDeDomini;

import java.util.*;

import javax.persistence.EntityManager;

/* Imports de la classe */
import dades.excepcions.*;
import domini.excepcions.DOBibliotecaNoExisteix;
import domini.excepcions.DOCapExemplar;
import domini.excepcions.DOLlibreNoExisteix;
import domini.interficiesADades.*;
import domini.model.*;
import serveisComuns.baseDeDades.Gestor;


/* Capa de Domini */
public class TrCompraLlibres extends Transaccio {
	
	private String isbnLlibre;
	
	private String nomBiblioteca;
	
	private int quantitat;
	
	public TrCompraLlibres(String isbnLl, String nomB, int q) {
	    isbnLlibre = isbnLl;
	    nomBiblioteca = nomB;
	    quantitat = q;
	}
	
	public void execute(Gestor g) throws DOLlibreNoExisteix, DOBibliotecaNoExisteix, DOCapExemplar {

		EntityManager em = g.getEntityManager();
		
		int quants = 0;
		
		Boolean exemplarExisteix = false;
		
		if (quantitat<1) throw new DOCapExemplar();
		
		IntCtrlExemplar ice = CtrlFabrica.obteCtrlExemplar();
		
		IntCtrlLlibre icll = CtrlFabrica.obteCtrlLlibre();
		try {
		icll.obte(em,isbnLlibre);
		}
		catch(LlibreNoExisteix lne)
		{
			throw new DOLlibreNoExisteix();
		}
		
		IntCtrlBiblioteca icb = CtrlFabrica.obteCtrlBiblioteca();
		try {
		icb.obte(em,nomBiblioteca);
		}
		catch(BibliotecaNoExisteix lne)
		{
			throw new DOBibliotecaNoExisteix();
		}
		
		try 
		{
		Exemplar pE = ice.obte(em,isbnLlibre,nomBiblioteca);
		int qAbans = pE.getQuants();
		pE.setQuants(qAbans+quantitat);
		}
		catch (ExemplarNoExistBiblio eneb)
		{
			Biblioteca pB = icb.obte(em,nomBiblioteca);
							
			Llibre pLl  = icll.obte(em,isbnLlibre);
			
			Exemplar pE = new Exemplar(pLl,pB,quantitat);
			
			em.persist(pE);
		}
	}
}