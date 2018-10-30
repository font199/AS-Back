package domini.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the exemplar database table.
 * 
 */
@Embeddable
public class ExemplarPK implements Serializable{
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