package isi.com.Qatar2022.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class TypeChaise implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long id;
	private String nom_type;
	private int capacite;
	private double tarif;
	@ManyToMany
	@JoinTable(name="chaise_stades")
	private List<Stade> stades;
	public TypeChaise( String nom_type, int capacite, double tarif) {
		super();
		this.nom_type = nom_type;
		this.capacite = capacite;
		this.tarif = tarif;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom_type() {
		return nom_type;
	}
	public void setNom_type(String nom_type) {
		this.nom_type = nom_type;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	@Override
	public String toString() {
		return "TypeChaise [id=" + id + ", nom_type=" + nom_type + ", capacite=" + capacite + ", tarif=" + tarif + "]";
	}

}
