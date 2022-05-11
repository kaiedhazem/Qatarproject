package isi.com.Qatar2022.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import isi.com.Qatar2022.Entities.Billet;
import isi.com.Qatar2022.Entities.CapaciteMatch;
import isi.com.Qatar2022.Entities.Partie;
import isi.com.Qatar2022.Entities.TypeChaise;
import isi.com.Qatar2022.Payload.Response.MessageResponse;
import isi.com.Qatar2022.Repository.BilletRepository;
import isi.com.Qatar2022.Repository.CapaciteMatchRepository;
import isi.com.Qatar2022.Repository.PartieRepository;
import isi.com.Qatar2022.Repository.TypeChaiseRepository;
import isi.com.Qatar2022.Services.PartieService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/billets")

public class BilletController {
	
	@Autowired
	private BilletRepository billetRepo;
	
	@Autowired
	private TypeChaiseRepository typeRepo;
	
	@Autowired
	private PartieRepository partieRepo;
	
	@Autowired
	private CapaciteMatchRepository capaciteMatchRepo;
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Billet> getAllBillets()
	{
		List<Billet> liste = billetRepo.findAll();
		return liste;
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public double addBillet(@RequestBody Billet billet)
	{
		double tarif= typeRepo.getById((long) 1).getTarif();
		int nb_place = billet.getNb_place(); 
		System.out.println(billet.getPartie());
		Partie part = partieRepo.findById(billet.getPartie().getId()).get();
		String partie = part.getRef();
		String type_chaise = billet.getType_chaise();
		CapaciteMatch capacite = capaciteMatchRepo.findByPartie(part);
		switch(type_chaise)
		{ 
		  case "pelouse":
		  {
				tarif = typeRepo.getById((long) 1).getTarif();
				capacite.setPelouse(capacite.getPelouse() - nb_place);
				break;
		  }
		  case "virage":
		  {
			  tarif = typeRepo.getById((long) 2).getTarif();
			  capacite.setVirage(capacite.getVirage() - nb_place);
				break;
		  }
		  case "enceinte_sup":
		  {
			  tarif = typeRepo.getById((long) 3).getTarif();
			  capacite.setEnceinte_sup(capacite.getEnceinte_sup()- nb_place);
				break;
		  }
		  case "enceinte_inf":
		  {
			  tarif = typeRepo.getById((long) 4).getTarif();
			  capacite.setEnceinte_inf(capacite.getEnceinte_inf()- nb_place);
				break;
		  }
		  default: { System.out.println("erreur type de chaise invalide!!"); }
			
		}
		
		
		if(billet.isRepas_inclus()) {
			billet.setMontant((nb_place*tarif)+nb_place*20);
		}
		else {
			billet.setMontant(nb_place*tarif);
		}
		billet.setRef(partie+"_"+billet.getNb_place()+"_"+billet.getType_chaise());
		
		billetRepo.save(billet);
		capaciteMatchRepo.save(capacite);
		
		return billet.getMontant();
	}
	
	

}
