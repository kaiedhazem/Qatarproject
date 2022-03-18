package isi.com.Qatar2022.Services;

import java.util.List;

import isi.com.Qatar2022.Entities.Partie;


public interface IPartieService {

	Partie savePartie(Partie partie);
	List<Partie> findAllParties();
	void deletePartie(Long id);
	Partie addPartie(Partie partie);
}
