package practica1.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practica1.model.Specie;
import practica1.repository.SpecieRepository;

@Controller
public class ShowSpecieByName {
	@Autowired
	private SpecieRepository specieRepository;
	
	@RequestMapping("/showEspecieByName")
	public String showName(@RequestParam String name, Model model) {	
		
		if (!name.isEmpty()){
			Specie specie = specieRepository.findByName(name);
			if (specie!=null){
		    	model.addAttribute("species", specie);
		    	return "showEspecie";
			}
			else{
				return "/notFound";
			}
		}
		return "/notFound";
	}
}

