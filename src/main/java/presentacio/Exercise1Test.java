package presentacio;

/* Imports de la classe */
import java.io.*;

import javax.persistence.*;

//import serveisComuns.baseDeDades.JPAUtil;

import dades.excepcions.*;
//import serveisComuns.entradaSortida.*;
import serveisComuns.baseDeDades.*;
//import serveisComuns.objectesAuxiliars.Tuple;
import domini.controladorsDeDomini.*;
import domini.excepcions.*;
import domini.interficiesADades.CtrlFabrica;

/* Capa de presentacio */
class Exercise1Test {
	
	 
	
	public static void main(String[] args) {
		try{
			// Use persistence.xml configuration */
			Gestor g = new Gestor();
			//EntityManagerFactory emf = g.newEMFactory();
			EntityManager em = g.newEntityManager(); // Retrieve an application managed entity manager 
			//EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
						
			/* Prepara la fabrica per obtenir els controladors */
			CtrlFabrica.obteCtrlFabrica();
			
			/* Entrada de dades a traves del teclat */
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			/* Test TxConsultaBiblioteca(nomBiblioteca)*/
			System.out.println();System.out.println("Prova TxConsultaBiblioteca('biblioteca can roses'), prem intro");
			br.readLine();
			
			try{
			em.getTransaction().begin();
	   		String nomB = "biblioteca can roses";
			System.out.println("Consulta bilbioteca '"+nomB+"'");System.out.println();
			TrConsultaBiblioteca trcb = new TrConsultaBiblioteca(nomB);
   			trcb.execute(g);
   			String adreca = trcb.donaAdreca();
   			Boolean publica = trcb.donaPublica();
   			System.out.println("La biblioteca està a "+adreca+ " és pública? "+publica);	
   			System.out.println();
			em.getTransaction().commit();
			}
			catch (DOBibliotecaNoExisteix bne) {
    			System.out.println("La biblioteca no existeix");	
    			em.getTransaction().rollback();
    		}		
			
			System.out.println();System.out.println("Prova TxConsultaBiblioteca('biblioteca borja'), prem intro");
			br.readLine();
			
			try{
			em.getTransaction().begin();	
			String nomB = "biblioteca borja";
			System.out.println("Consulta bilbioteca '"+nomB+"'");System.out.println();
			TrConsultaBiblioteca trcb = new TrConsultaBiblioteca(nomB);
   			trcb.execute(g);
   			String adreca = trcb.donaAdreca();
   			Boolean publica = trcb.donaPublica();
   			System.out.println("La biblioteca està a "+adreca+ " és pública? "+publica);	
   			System.out.println();
			em.getTransaction().commit();
			}
			catch (DOBibliotecaNoExisteix bne) {
    			System.out.println("La biblioteca no existeix");	
    			em.getTransaction().rollback();
    		}		
			
			/* Test TrBibPublicaAmbMesSocis()*/
			System.out.println();System.out.println("Prova TrBibPublicaAmbMesSocis(), prem intro");
			br.readLine();
			
			try{
			em.getTransaction().begin();
			TrBibPublicaAmbMesSocis trcbp = new TrBibPublicaAmbMesSocis();
   			trcbp.execute(g);
   			String nomB = trcbp.donaBibliotecaMesSocis();
   			System.out.println("Biblioteca amb més socis: "+nomB);	
   			System.out.println();
			em.getTransaction().commit();
			}
			catch (NoHiHaBiblioPubliques nbpe) {
    			System.out.println("No existeix cap biblioteca pública");	
    			em.getTransaction().rollback();
    		}	
			
			/* Test TrConsultaExemplars(nomB,isbn)*/
			System.out.println();System.out.println("Prova TrConsultaExemplars(nomB,isbn), prem intro");
			br.readLine();
			
			try {
				em.getTransaction().begin();
				String nomB = "biblioteca jaume fuster";
				String isbn = "333";
    			System.out.println("Consulta exemplars de la '"+nomB+"' del llibre "+isbn);System.out.println();
				TrConsultaExemplars trce = new TrConsultaExemplars(nomB,isbn);
	   			trce.execute(g);
	   			int quants = trce.donaQuantitat();
	   			System.out.println("La "+nomB+ " té "+quants+" exemplars del llibre amb isbn "+isbn);	
	   			System.out.println();
    			em.getTransaction().commit();
	   		}
	   		catch (DOLlibreNoExisteix llne) {
    			System.out.println("El llibre no existeix");	
    			em.getTransaction().rollback();
    		}	
    		catch (DOBibliotecaNoExisteix bne) {
    			System.out.println("La bilbioteca no existeix");
    			em.getTransaction().rollback();
    		}	
			
			System.out.println();System.out.println("Prova TrConsultaExemplars(nomB,isbn), prem intro");
			br.readLine();
			
			try {
				em.getTransaction().begin();
				String nomB = "biblioteca can roses";
				String isbn = "333";
    			System.out.println("Consulta exemplars de la '"+nomB+"' del llibre "+isbn);System.out.println();
				TrConsultaExemplars trce = new TrConsultaExemplars(nomB,isbn);
	   			trce.execute(g);
	   			int quants = trce.donaQuantitat();
	   			System.out.println("La "+nomB+ " té "+quants+" exemplars del llibre amb isbn "+isbn);	
	   			System.out.println();
    			em.getTransaction().commit();
	   		}
	   		catch (DOLlibreNoExisteix llne) {
    			System.out.println("El llibre no existeix");	
    			em.getTransaction().rollback();
    		}	
    		catch (DOBibliotecaNoExisteix bne) {
    			System.out.println("La bilbioteca no existeix");
    			em.getTransaction().rollback();
    		}
						
			/* Test TrCompraLlibres(nomB,isbn,quantitat)*/
			System.out.println();System.out.println("Prova TrCompraLlibres(nomB,isbn,quantitat), prem intro");
			br.readLine();

			try{
				em.getTransaction().begin();
		    	String isbnLl = "333";
			    String nomB = "biblioteca jaume fuster";
			    int q = 2;
			    System.out.println("Increment de "+q+" exemplars del llibre amb isbn "+isbnLl+" a la "+nomB);System.out.println();
			    TrCompraLlibres trcll = new TrCompraLlibres(isbnLl,nomB,q);
			    trcll.execute(g);
				System.out.println();
			    em.getTransaction().commit();
			    }
			 catch (DOLlibreNoExisteix llne) {
				 System.out.println("El llibre no existeix");	
				 em.getTransaction().rollback();
			 }	
			 catch (DOBibliotecaNoExisteix bne) {
				 System.out.println("La bilbioteca no existeix");
				 em.getTransaction().rollback();
			 }	
			 catch (DOCapExemplar cee) {
			 	System.out.println("La quantitat no �s correcta");
			 	em.getTransaction().rollback();
			 }	
			
			System.out.println();System.out.println("Prova TrCompraLlibres(nomB,isbn,quantitat), prem intro");
			br.readLine();
			
			try{
				em.getTransaction().begin();
		    	String isbnLl = "333";
			    String nomB = "biblioteca can roses";
			    int q = 2;
			    System.out.println("Increment de "+q+" exemplars del llibre amb isbn "+isbnLl+" a la "+nomB);System.out.println();
			    TrCompraLlibres trcll = new TrCompraLlibres(isbnLl,nomB,q);
			    trcll.execute(g);
				System.out.println();
			    em.getTransaction().commit();
			    }
			 catch (DOLlibreNoExisteix llne) {
				 System.out.println("El llibre no existeix");	
				 em.getTransaction().rollback();
			 }	
			 catch (DOBibliotecaNoExisteix bne) {
				 System.out.println("La bilbioteca no existeix");
				 em.getTransaction().rollback();
			 }	
			 catch (DOCapExemplar cee) {
			 	System.out.println("La quantitat no és correcta");
			 	em.getTransaction().rollback();
			 }	
			
			/* Test TrConsultaExemplars(nomB,isbn)*/
			System.out.println();System.out.println("Prova TrConsultaExemplars(nomB,isbn), prem intro");
			br.readLine();
			
			try {
				em.getTransaction().begin();
				String nomB = "biblioteca jaume fuster";
				String isbn = "333";
    			System.out.println("Consulta exemplars de la '"+nomB+"' del llibre "+isbn);System.out.println();
				TrConsultaExemplars trce = new TrConsultaExemplars(nomB,isbn);
	   			trce.execute(g);
	   			int quants = trce.donaQuantitat();
	   			System.out.println("La "+nomB+ " té "+quants+" exemplars del llibre amb isbn "+isbn);	
	   			System.out.println();
    			em.getTransaction().commit();
	   		}
	   		catch (DOLlibreNoExisteix llne) {
    			System.out.println("El llibre no existeix");	
    			em.getTransaction().rollback();
    		}	
    		catch (DOBibliotecaNoExisteix bne) {
    			System.out.println("La bilbioteca no existeix");
    			em.getTransaction().rollback();
    		}	
			
			System.out.println();System.out.println("Prova TrConsultaExemplars(nomB,isbn), prem intro");
			br.readLine();
			
			try {
				em.getTransaction().begin();
				String nomB = "biblioteca can roses";
				String isbn = "333";
    			System.out.println("Consulta exemplars de la '"+nomB+"' del llibre "+isbn);System.out.println();
				TrConsultaExemplars trce = new TrConsultaExemplars(nomB,isbn);
	   			trce.execute(g);
	   			int quants = trce.donaQuantitat();
	   			System.out.println("La "+nomB+ " té "+quants+" exemplars del llibre amb isbn "+isbn);	
	   			System.out.println();
    			em.getTransaction().commit();
	   		}
	   		catch (DOLlibreNoExisteix llne) {
    			System.out.println("El llibre no existeix");	
    			em.getTransaction().rollback();
    		}	
    		catch (DOBibliotecaNoExisteix bne) {
    			System.out.println("La bilbioteca no existeix");
    			em.getTransaction().rollback();
    		}		
			
		    /* Desconnectar-se a la base de dades */
			em.close();					
			}
			//catch (IOException bde) {
			//	System.out.println("Error al llegir la opcio seleccionada");
    		//	}
		    catch (Exception e) {
    			/* Qualsevol altre error */
    			System.out.println(e.getMessage());
    			}	
	}
}