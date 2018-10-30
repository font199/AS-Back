package domini.model;

//import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the instalacio database table.
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="instalacions")
@NamedQuery(name="Instalacio.findAll", query="SELECT i FROM Instalacio i")
public class Instalacio {

	@Id
	@Column(name = "nomI")
	private String nomI;

	private String adreca;

	//one-to-many association to Soci
	@OneToMany
    @JoinColumn(name = "nomInst")
	private List<Soci> socis;

	public Instalacio() {
	}

	public String getNomI() {
		return this.nomI;
	}

	public void setNomI(String nomi) {
		this.nomI = nomi;
	}

	public String getAdreca() {
		return this.adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public List<Soci> getSocis() {
		return socis;
	}
	
	public void addSoci(Soci soci) {
		socis.add(soci);
	}

	public void removeSoci(Soci soci) {
		socis.remove(soci);
	}

	public int getQuantsSocis() {
		int quants = 0;
		quants = socis.size();
		return quants;
	}
}