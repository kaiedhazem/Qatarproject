package isi.com.Qatar2022.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class ChaiseStade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private Long capacite;
	
	@ManyToOne
	@MapsId("stadeId")
	Stade stade;

	@ManyToOne
	@MapsId("typeId")
	TypeChaise type;

	public ChaiseStade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChaiseStade(Long capacite, TypeChaise type) {
		super();
		this.capacite = capacite;
		//this.stade = stade;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCapacite() {
		return capacite;
	}

	public void setCapacite(Long capacite) {
		this.capacite = capacite;
	}

	/*
	 * public Stade getStade() { return stade; }
	 * 
	 * public void setStade(Stade stade) { this.stade = stade; }
	 */

	public TypeChaise getType() {
		return type;
	}

	public void setType(TypeChaise type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ChaiseStade [id=" + id + ", capacite=" + capacite + ", type=" + type + "]";
	}
	
	
}
