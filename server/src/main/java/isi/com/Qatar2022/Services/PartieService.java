package isi.com.Qatar2022.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.com.Qatar2022.Entities.Partie;
import isi.com.Qatar2022.Repository.PartieRepository;

@Service
public class PartieService implements IPartieService{

	@Autowired
	private PartieRepository partieRepo;
	
	@Override
	public Partie savePartie(Partie partie) {
		// TODO Auto-generated method stub
		return partieRepo.save(partie);
	}

	@Override
	public List<Partie> findAllParties() {
		// TODO Auto-generated method stub
		return partieRepo.findAll();
	}

	@Override
	public void deletePartie(Long id) {
		// TODO Auto-generated method stub
		partieRepo.deleteById(id);
	}

	@Override
	public Partie addPartie(Partie partie) {
		// TODO Auto-generated method stub
		return partieRepo.save(partie);
	}

}
