package domini.model;

//import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the soci database table.
 * 
 */
@Entity
@Table(name = "socis")
//@NamedQuery(name="Soci.findAll", query="SELECT s FROM Soci s")
public class Soci {

	@Id
	private String noms;

	private Integer edat;

	public Soci() {
	}

	public String getNoms() {
		return this.noms;
	}

	public void setNoms(String noms) {
		this.noms = noms;
	}

	public Integer getEdat() {
		return this.edat;
	}

	public void setEdat(Integer edat) {
		this.edat = edat;
	}
}