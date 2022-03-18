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
  
    @OneToMany(mappedBy="stade",cascade=CascadeType.ALL)
	private List<Partie> parties ;
    @ManyToMany(mappedBy="stades")
    private List<TypeChaise> typechaises;
	public Stade( String nom, int capacite_g) {
		super();
		this.nom = nom;
		this.capacite_g = capacite_g;
	
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
	@Override
	public String toString() {
		return "Stade [id=" + id + ", nom=" + nom + ", capacite_g=" + capacite_g + ", match=" + "]";
	}

    
}
