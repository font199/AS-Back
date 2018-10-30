package serveisComuns.baseDeDades;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public class Gestor {

  private EntityManagerFactory emFactory;
  private EntityManager eManager;

  public EntityManagerFactory newEMFactory() {

    // ""Exercici1-JPA" was the value of the name attribute of the
    // persistence-unit element.
    emFactory = Persistence.createEntityManagerFactory("Exercici1-JPA");
    return emFactory;
  }
  
  public CriteriaBuilder getBuilder() {

	    // ""Exercici1-JPA" was the value of the name attribute of the
	    // persistence-unit element.
	  CriteriaBuilder builder = emFactory.getCriteriaBuilder();
	  return builder;
	  }  

  public EntityManager newEntityManager() {
	   eManager = JPAUtil.getEntityManagerFactory().createEntityManager();    
	  //eManager =   emFactory.createEntityManager();
      return eManager;
  }
  
  public EntityManager getEntityManager() {
	return eManager;
   }
  
  public void closeEntityManager() {
	eManager.close();
  }

  public void closeEntityManagerFactory() {

    emFactory.close();

  }

}