package domini.model;

//import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

/**
 * The persistent class for the biblioteca database table.
 * 
 */
@Entity 
@Table(name = "biblioteques")
//@NamedQuery(name="Biblioteca.findAll", query="SELECT b FROM Biblioteca b")
public class Biblioteca extends Instalacio {
	
	private Boolean publica;
	
	/*Bidirectional association to Exemplar*/
	@OneToMany(mappedBy = "biblioteca", fetch = FetchType.EAGER)
	private Set<Exemplar> exemplars = new HashSet<Exemplar>();
 
	public Biblioteca() {
	}

	public Boolean getPublica() {
		return this.publica;
	}

	public void setPublica(Boolean publica) {
		this.publica = publica;
	}
	
	public Set<Exemplar> getExemplars() {
		return this.exemplars;
	}

	public void addExemplar(Exemplar exemplar) {
		exemplar.setBiblioteca(this);
		this.exemplars.add(exemplar);
	}

	public void removeExemplar(Exemplar exemplar) {
		exemplar.setBiblioteca(null);
		this.exemplars.remove(exemplar);	
	}

}