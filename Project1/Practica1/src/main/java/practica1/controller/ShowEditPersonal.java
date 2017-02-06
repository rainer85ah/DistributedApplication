package practica1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import practica1.model.Person;
import practica1.model.Person.Job;
import practica1.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ShowEditPersonal {
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping("/showEditPersonal")
	public String home(@RequestParam String name,
					@RequestParam String lastname,
					Model model) {
		
		if (!name.isEmpty() && !lastname.isEmpty()){
			Person person = personRepository.findByNameAndLastname(name, lastname);
	    	//model.addAttribute("person", person);
	    	if (person!=null){
		    	model.addAttribute("person", person);
		    	return "/showEditPersonal";
			}
			else
				return "/notFound";
		}
	   	
		//model.addAttribute(model);
		return "/notFound";
	}

}