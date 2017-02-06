package practica1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import practica1.model.Person;
import practica1.model.Specie;
import practica1.repository.AreaRepository;
import practica1.repository.SpecieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ShowEditEspecie {
	
	@Autowired
	private SpecieRepository specieRepository;

	@RequestMapping("/showEditEspecie")
	public String home(@RequestParam String name, Model model) {
		
		if (!name.isEmpty()){
			Specie specie = specieRepository.findByName(name);
			if (specie!=null){
		    	model.addAttribute("specie", specie);
		    	return "/showEditEspecie";
			}
			else{
				return "/notFound";
			}
		}
		else   	
			return "/notFound";
	}

}