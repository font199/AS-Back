package domini.model;

import java.io.Serializable;

//import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the exemplar database table.
 * 
 */
@Entity(name="Exemplar")
@Table(name = "exemplars")
@NamedQuery(name="Exemplar.findAll", query="SELECT e FROM Exemplar e")
public class Exemplar {
	
	@Embeddable
	public static class ExemplarPK implements Serializable{
		private static final long serialVersionUID = 1L;

		@Column(insertable=false, updatable=false)
		private String isbnId;

		@Column(insertable=false, updatable=false)
		private String nombId;

		public ExemplarPK() {
		}
		
		public ExemplarPK(String isbn, String nomb) {
			this.isbnId = isbn;
			this.nombId = nomb;
		}

		public boolean equals(Object other) {
			if (this == other) {
				return true;
			}
			if (!(other instanceof ExemplarPK)) {
				return false;
			}
			ExemplarPK castOther = (ExemplarPK)other;
			return 
				this.isbnId.equals(castOther.isbnId)
				&& this.nombId.equals(castOther.nombId);
		}

		public int hashCode() {
			final int prime = 31;
			int hash = 17;
			hash = hash * prime + this.isbnId.hashCode();
			hash = hash * prime + this.nombId.hashCode();
			
			return hash;
		}
	}

	@EmbeddedId
	private ExemplarPK id;
	
	//bi-directional many-to-one association to Llibre
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="isbn")
	@MapsId("isbnId")
	private Llibre llibre;

	//bi-directional many-to-one association to Biblioteca
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="nomb")
	@MapsId("nombId")
	private Biblioteca biblioteca;
	
	private Integer quants;
	
	public Exemplar() {
	}

	public Exemplar(Llibre ll, Biblioteca bl, int q) {
		this.llibre = ll;
		this.biblioteca = bl;
		this.quants = q;
		this.id = new ExemplarPK(ll.getIsbn(), bl.getNomI());
				
		// update relationships to assure referential integrity
		ll.getExemplars().add(this);
		bl.getExemplars().add(this);
	}

	public Integer getQuants() {
		return this.quants;
	}

	public void setQuants(Integer quants) {
		this.quants = quants;
	}

	public Biblioteca getBiblioteca() {
		return this.biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	public Llibre getLlibre() {
		return this.llibre;
	}

	public void setLlibre(Llibre llibre) {
		this.llibre = llibre;
	}

}