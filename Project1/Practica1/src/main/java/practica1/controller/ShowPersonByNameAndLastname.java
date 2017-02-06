package practica1.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practica1.model.Person;
import practica1.repository.PersonRepository;

@Controller
public class ShowPersonByNameAndLastname {
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping("/showPersonalByNameAndLastname")
	public String show(@RequestParam String name, 
					   @RequestParam String lastname, Model model) {
		
		if (!name.isEmpty() && !lastname.isEmpty())
		{
			Person person = personRepository.findByNameAndLastname(name, lastname);
			if (person!=null){
		    	model.addAttribute("persons", person);
			    return "showPersonal";
			}
			else{
				return "/notFound";
			}
		}
		
		if (name.isEmpty() && !lastname.isEmpty())
		{
			Collection<Person> persons = personRepository.findByLastname(lastname);
			if (persons!=null){
		    	model.addAttribute("persons", persons);	
			    return "showPersonal";
			}
			else{
				return "/notFound";
			}
		}
		
		return "/notFound";
	}
	
}