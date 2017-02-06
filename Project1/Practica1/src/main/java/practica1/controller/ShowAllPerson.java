package practica1.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import practica1.model.Person;
import practica1.repository.PersonRepository;

@Controller
public class ShowAllPerson {
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping(value = "/showAllPerson")
	public String show(Model model) {	
		
		Collection<Person> persons = personRepository.findAll();
		if (persons!=null){
	    	model.addAttribute("persons", persons);
	    	
			return "showPersonal";
		}
		else
			return "/notFound";
	}
}