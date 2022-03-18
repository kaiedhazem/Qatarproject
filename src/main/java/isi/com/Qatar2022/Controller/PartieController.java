package isi.com.Qatar2022.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.com.Qatar2022.Entities.Partie;
import isi.com.Qatar2022.Entities.User;
import isi.com.Qatar2022.Services.IPartieService;
import isi.com.Qatar2022.Services.IUserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/partie")
public class PartieController {

	
	@Autowired
	private IPartieService partieService;
	 
	@GetMapping("/parties")
	public List<Partie> getAllParties()
	{
		List<Partie> liste = partieService.findAllParties();
		return liste;
	}
	
	@PostMapping("/addpartie")
	public Partie addPartie(@RequestBody Partie partie)
	{
		return partieService.addPartie(partie);
	}
}
