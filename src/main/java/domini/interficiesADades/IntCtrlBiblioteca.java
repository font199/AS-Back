package domini.interficiesADades;

/* Imports de la classe */
import java.util.*;

import javax.persistence.EntityManager;

import dades.excepcions.*;
import domini.model.*;

/* Capa de Dades */
public interface IntCtrlBiblioteca {
	
	 public Biblioteca obte(EntityManager em, String nomB) throws BibliotecaNoExisteix;
	
	 public Boolean existeix(EntityManager em, String nomB) throws BibliotecaNoExisteix;
	
	 public List<Biblioteca> obteTotes(EntityManager em);
	
}