package isi.com.Qatar2022.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.com.Qatar2022.Entities.CapaciteMatch;
import isi.com.Qatar2022.Entities.ChaiseStade;
import isi.com.Qatar2022.Entities.Partie;
import isi.com.Qatar2022.Entities.Stade;
import isi.com.Qatar2022.Entities.TypeChaise;
import isi.com.Qatar2022.Entities.User;
import isi.com.Qatar2022.Repository.CapaciteMatchRepository;
import isi.com.Qatar2022.Repository.ChaiseStadeRepository;
import isi.com.Qatar2022.Repository.StadeRepository;
import isi.com.Qatar2022.Repository.TypeChaiseRepository;
import isi.com.Qatar2022.Services.IPartieService;
import isi.com.Qatar2022.Services.IUserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/parties")
public class PartieController {

	@Autowired
	private IPartieService partieService;
	
	@Autowired
	private StadeRepository stadeRepo;
	
	@Autowired
	private ChaiseStadeRepository chaises;
	
	@Autowired
	private CapaciteMatchRepository capaciteMatch;
	
	@Autowired
	private TypeChaiseRepository typeChaiseRepo;
	
	@GetMapping("/allparties")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Partie> getAllParties()
	{
		List<Partie> liste = partieService.findAllParties();
		return liste;
	}
	
	@PostMapping("/addpartie")
	@PreAuthorize("hasRole('ADMIN')")
	public Partie addPartie(@RequestBody Partie partie)
	{
		return partieService.addPartie(partie);
	}
	
	@GetMapping("/getpartiebyid/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Partie getPartieById(@PathVariable("id") Long id)
	{
		Partie partie = partieService.findById(id);
		return partie ;
	}
	
	@DeleteMapping("/deletepartiebyid/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deletePartieById(@PathVariable("id") Long id)
	{
		partieService.deletePartie(id);
		return "Delete Done" ;
	}
	   
	@PostMapping("/addpartietostade/{partie}/{stade}")
	@PreAuthorize("hasRole('ADMIN')")
	public CapaciteMatch addPartieToStade(@PathVariable("partie") Long partieid, @PathVariable("stade") Long stadeid)
	{
		System.out.println("partie id: "+ partieid + " stade id: "+ stadeid);
		Partie partie = getPartieById(partieid );
		Stade stade = getStadeById(stadeid);
		partie.setStade(stade);
		partieService.savePartie(partie);
		Long pelouse = stade.getChaises().get(0).getCapacite();
		Long virage = stade.getChaises().get(1).getCapacite();
		Long enceinte_sup = stade.getChaises().get(2).getCapacite();
		Long enceinte_inf = stade.getChaises().get(3).getCapacite();
		CapaciteMatch capacite = new CapaciteMatch(partie, pelouse, virage, enceinte_sup, enceinte_inf);
		
		return capaciteMatch.save(capacite);
	}
	
	@GetMapping("/allstades")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Stade> getAllStades()
	{
		List<Stade> liste = stadeRepo.findAll();
		return liste ;
	}
	
	@GetMapping("/getstadebyid/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Stade getStadeById(@PathVariable("id") Long id)
	{
		Stade stade = stadeRepo.findById(id).get();
		return stade ;
	}
	
	@GetMapping("/getchaisesstadebyid/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public List<ChaiseStade> getChaisesStadeById(@PathVariable("id") Long id)
	{
		Stade stade = stadeRepo.findById(id).get();
		return stade.getChaises() ;
	}
	
	@GetMapping("/allchaises")
	@PreAuthorize("hasRole('ADMIN')")
	public List<ChaiseStade> getAllChaises()
	{
		List<ChaiseStade> liste = chaises.findAll();
		return liste ;
	}
	
	@GetMapping("/allcapacites")
	@PreAuthorize("hasRole('ADMIN')")
	public List<CapaciteMatch> getAllCapacites()
	{
		List<CapaciteMatch> liste = capaciteMatch.findAll();
		return liste ;
	}
	
	@GetMapping("/capacitepartie/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public CapaciteMatch getCapacitePartie(@PathVariable("id") Long id)
	{
		Partie partie = partieService.findById(id);
		CapaciteMatch capacite = capaciteMatch.findByPartie(partie);
		return capacite ;
	}
	
	@GetMapping("/alltypes")
	@PreAuthorize("hasRole('ADMIN')")
	public List<TypeChaise> getAllType()
	{
		List<TypeChaise> liste = typeChaiseRepo.findAll();
		return liste ;
	}
	
}
