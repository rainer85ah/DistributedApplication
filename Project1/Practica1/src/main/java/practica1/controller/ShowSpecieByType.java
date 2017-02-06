package practica1.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practica1.model.Specie;
import practica1.model.Specie.Type;
import practica1.repository.SpecieRepository;

@Controller
public class ShowSpecieByType {
	@Autowired
	private SpecieRepository specieRepository;
	
	@RequestMapping("/showEspecieByType")
	public String showName(@RequestParam Type type, Model model) {	
		
		Collection<Specie> specie = specieRepository.findByType(type);
    	if (specie!=null){
			model.addAttribute("species", specie);
			return "showEspecie";
		}
		else{
			return "/notFound";
		}
    }
}