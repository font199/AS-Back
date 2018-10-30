package domini.controladorsDeDomini;

/* Imports de la classe */
import java.util.List;

import javax.persistence.EntityManager;

import serveisComuns.baseDeDades.*;
import dades.excepcions.*;
import domini.interficiesADades.*;
import domini.model.*;


/* Capa de Domini */
public class TrBibPublicaAmbMesSocis extends Transaccio {
	
	private String nomBlibliotecaAmbMesSocis;
	
	public TrBibPublicaAmbMesSocis() {
		nomBlibliotecaAmbMesSocis = null;
	}
	
	public void execute(Gestor g) throws NoHiHaBiblioPubliques {
		EntityManager em = g.getEntityManager();
		
		int max = 0;
		
		String nomBMax = null;
				
		IntCtrlBiblioteca icb = CtrlFabrica.obteCtrlBiblioteca();
		
		List<Biblioteca> sB = icb.obteTotes(em);
						
		if (sB.isEmpty()) throw new NoHiHaBiblioPubliques();
		
		for (Biblioteca pb: sB) {
			int quantsSocis = pb.getQuantsSocis();
			if (quantsSocis > max) {
				max = quantsSocis;
				String nomB = pb.getNomI();
				nomBMax = nomB;
			}
		}
		nomBlibliotecaAmbMesSocis = nomBMax;
	}
	
	public String donaBibliotecaMesSocis() {
		return nomBlibliotecaAmbMesSocis;
	}
}