package practica1.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import practica1.model.Specie;
import practica1.repository.SpecieRepository;

@Controller
public class ShowAllEspecies {
	@Autowired
	private SpecieRepository specieRepository;
	
	@RequestMapping("/showAllEspecies")
	public String showName(Model model) {	
		
		Collection<Specie> specie = specieRepository.findAll();
    	if (specie!=null){
			model.addAttribute("species", specie);
			return "showEspecie";
		}
		else{
			return "/notFound";
		}
    }
}