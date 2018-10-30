package domini.controladorsDeDomini;

/* Imports de la classe */
//import java.util.List;

import javax.persistence.EntityManager;

import serveisComuns.baseDeDades.*;
import dades.excepcions.*;
import domini.interficiesADades.*;
import domini.model.*;
import domini.excepcions.*;


/* Capa de Domini */
public class TrConsultaBiblioteca extends Transaccio {
	
	private String nomB;
	
	private String adreca;
	
	private Boolean publica;
	
	public TrConsultaBiblioteca(String nomB) {
		this.nomB = nomB;
	}
	
	public void execute(Gestor g) throws DOBibliotecaNoExisteix {
		EntityManager em = g.getEntityManager();

		IntCtrlBiblioteca icb = CtrlFabrica.obteCtrlBiblioteca();
		
		Biblioteca b = null;
		
		try {
			b = icb.obte(em,nomB);
		}
		catch (BibliotecaNoExisteix bne)
		{
			throw new DOBibliotecaNoExisteix();
		}
				
		adreca = b.getAdreca();
		
		publica = b.getPublica();
		
		System.out.println(b.getExemplars().size());
	}
	
	public String donaAdreca() {
		return adreca;
	}
	
	public Boolean donaPublica() {
		return publica;
	}
}