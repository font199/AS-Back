package domini.controladorsDeDomini;

import java.util.Set;

/* Imports de la classe */
//import java.util.List;

import javax.persistence.EntityManager;

import serveisComuns.baseDeDades.*;
import dades.excepcions.*;
import domini.interficiesADades.*;
import domini.model.*;
import domini.excepcions.*;


/* Capa de Domini */
public class TrConsultaExemplars extends Transaccio {
	
	private String nomBiblioteca;
	
	private String isbnLlibre;
	
	private int quantitat;
	
	public TrConsultaExemplars(String nomB, String isbn) {
		this.nomBiblioteca = nomB;
		this.isbnLlibre = isbn;
	}
	
	public void execute(Gestor g) throws DOLlibreNoExisteix, DOBibliotecaNoExisteix, DOCapExemplar {
		EntityManager em = g.getEntityManager();
					
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
		
		IntCtrlExemplar ice = CtrlFabrica.obteCtrlExemplar();
		try {
		Exemplar pE = ice.obte(em,isbnLlibre,nomBiblioteca);
		quantitat = pE.getQuants();
		}
		catch(ExemplarNoExistBiblio ene)
		{ throw new DOCapExemplar();}
	}
	
	public int donaQuantitat() {
		return quantitat;
	}
	
}