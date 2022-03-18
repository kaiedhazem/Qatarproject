package isi.com.Qatar2022.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Partie implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long id;
	private String ref;
	private String tour;
	private String eq_local;
	private String eq_visiteur;
	private Date date_h;

	@ManyToOne()
	private Stade stade;
	@OneToMany(mappedBy = "partie")
	private List<Billet> billets;
	@OneToOne(mappedBy = "partie")
    private CapaciteMatch capacite;
	
	
	public Partie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Partie(String ref, String tour, String eq_local, String eq_visiteur, Date date_h) {
		super();
		this.ref = ref;
		this.tour = tour;
		this.eq_local = eq_local;
		this.eq_visiteur = eq_visiteur;
		this.date_h = date_h;
	}
	/*public Stade getStade() {
		return stade;
	}
	public void setStade(Stade stade) {
		this.stade = stade;
	}*/
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getTour() {
		return tour;
	}
	public void setTour(String tour) {
		this.tour = tour;
	}
	public String getEq_local() {
		return eq_local;
	}
	public void setEq_local(String eq_local) {
		this.eq_local = eq_local;
	}
	public String getEq_visiteur() {
		return eq_visiteur;
	}
	public void setEq_visiteur(String eq_visiteur) {
		this.eq_visiteur = eq_visiteur;
	}
	public Date getDate_h() {
		return date_h;
	}
	public void setDate_h(Date date_h) {
		this.date_h = date_h;
	}
	@Override
	public String toString() {
		return "Match [ref=" + ref + ", tour=" + tour + ", eq_local=" + eq_local + ", eq_visiteur=" + eq_visiteur
				+ ", date_h=" + date_h + "]";
	}
	
	
}
