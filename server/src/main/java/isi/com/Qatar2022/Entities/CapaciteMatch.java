package isi.com.Qatar2022.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class CapaciteMatch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long id;
	@OneToOne
	@JoinColumn(name = "partie_id", referencedColumnName = "id")
	private Partie partie;
	private Long virage;
	private Long pelouse;
	private Long enceinte_sup;
	private Long enceinte_inf;
	
	public CapaciteMatch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CapaciteMatch(Partie partie, Long virage, Long pelouse, Long enceinte_sup, Long enceinte_inf) {
		super();
		this.partie = partie;
		this.virage = virage;
		this.pelouse = pelouse;
		this.enceinte_sup = enceinte_sup;
		this.enceinte_inf = enceinte_inf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Long getVirage() {
		return virage;
	}

	public void setVirage(Long virage) {
		this.virage = virage;
	}

	public Long getPelouse() {
		return pelouse;
	}

	public void setPelouse(Long pelouse) {
		this.pelouse = pelouse;
	}

	public Long getEnceinte_sup() {
		return enceinte_sup;
	}

	public void setEnceinte_sup(Long enceinte_sup) {
		this.enceinte_sup = enceinte_sup;
	}

	public Long getEnceinte_inf() {
		return enceinte_inf;
	}

	public void setEnceinte_inf(Long enceinte_inf) {
		this.enceinte_inf = enceinte_inf;
	}

	@Override
	public String toString() {
		return "CapaciteMatch [id=" + id + ", partie=" + partie + ", virage=" + virage + ", pelouse=" + pelouse
				+ ", enceinte_sup=" + enceinte_sup + ", enceinte_inf=" + enceinte_inf + "]";
	}
	
	
}
