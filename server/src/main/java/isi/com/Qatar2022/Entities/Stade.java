package isi.com.Qatar2022.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Stade implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long id;
	private String nom;
    private int capacite_g;
  
    @OneToMany(mappedBy="stade", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Partie> parties ;
    
    @OneToMany(mappedBy = "stade")
	private List<ChaiseStade> chaises;
    
	public Stade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stade(String nom, int capacite_g,List<ChaiseStade> chaises) {
		super();
		this.nom = nom;
		this.capacite_g = capacite_g;
		//this.parties = parties;
		this.chaises = chaises;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCapacite_g() {
		return capacite_g;
	}

	public void setCapacite_g(int capacite_g) {
		this.capacite_g = capacite_g;
	}

//	public List<Partie> getParties() {
//		return parties;
//	}
//
//	public void setParties(List<Partie> parties) {
//		this.parties = parties;
//	}

	 public List<ChaiseStade> getChaises() { return chaises; }
	  
	 public void setChaises(List<ChaiseStade> chaises) { this.chaises = chaises; }
	 

	@Override
	public String toString() {
		return "Stade [id=" + id + ", nom=" + nom + ", capacite_g=" + capacite_g  + "]";
	}
	
	
    
}
