package domini.model;

//import java.io.Serializable;
import javax.persistence.*;
import java.util.*;


/**
 * The persistent class for the llibre database table.
 * 
 */
@Entity
@Table(name = "llibres")
//@NamedQuery(name="Llibre.findAll", query="SELECT l FROM Llibre l")
public class Llibre {

	@Id
	private String isbn;

	private String titol;
	
	/* Bidirectional association to Exemplar*/
	@OneToMany(mappedBy = "llibre", fetch = FetchType.EAGER)
	private Set<Exemplar> exemplars = new HashSet<Exemplar>();

	public Llibre() {
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitol() {
		return this.titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public Set<Exemplar> getExemplars() {
		return this.exemplars;
	}
	
	public int obteNumExemplars(){return this.exemplars.size();}

	public void addExemplar(Exemplar exemplar) {
		exemplar.setLlibre(this);
		this.exemplars.add(exemplar);
	}

	public void removeExemplar(Exemplar exemplar) {
		exemplar.setLlibre(null);
		this.exemplars.remove(exemplar);
	}

}