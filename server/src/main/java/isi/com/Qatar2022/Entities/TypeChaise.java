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
import javax.persistence.OneToMany;
@Entity
public class TypeChaise implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long id;
	private String nom_type;
	private double tarif;
	@OneToMany(mappedBy = "type")
	private List<ChaiseStade> chaises;
	public TypeChaise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeChaise(String nom_type, double tarif, List<ChaiseStade> chaises) {
		super();
		this.nom_type = nom_type;
		this.tarif = tarif;
		this.chaises = chaises;
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
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	public List<ChaiseStade> getChaises() {
		return chaises;
	}
	public void setChaises(List<ChaiseStade> chaises) {
		this.chaises = chaises;
	}
	@Override
	public String toString() {
		return "TypeChaise [id=" + id + ", nom_type=" + nom_type + ", tarif=" + tarif + ", chaises=" + chaises + "]";
	}
	
	

}
