package isi.com.Qatar2022.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Billet {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)  
private Long id;
private String ref;
private int nb_place;
private double montant;
private String type_chaise;
private boolean repas_inclus;
@ManyToOne
@MapsId("partieId")
Partie partie;

@ManyToOne
@MapsId("userId")
User spectateur;

public Billet( String ref, int nb_place, double montant, String type_chaise, boolean repas_inclus) {
	super();
	this.ref = ref;
	this.nb_place = nb_place;
	this.montant = montant;
	this.type_chaise = type_chaise;
	this.repas_inclus = repas_inclus;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getRef() {
	return ref;
}
public void setRef(String ref) {
	this.ref = ref;
}
public int getNb_place() {
	return nb_place;
}
public void setNb_place(int nb_place) {
	this.nb_place = nb_place;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}
public String getType_chaise() {
	return type_chaise;
}
public void setType_chaise(String type_chaise) {
	this.type_chaise = type_chaise;
}
public boolean isRepas_inclus() {
	return repas_inclus;
}
public void setRepas_inclus(boolean repas_inclus) {
	this.repas_inclus = repas_inclus;
}
@Override
public String toString() {
	return "Billet [id=" + id + ", ref=" + ref + ", nb_place=" + nb_place + ", montant=" + montant + ", type_chaise="
			+ type_chaise + ", repas_inclus=" + repas_inclus + "]";
}
}
