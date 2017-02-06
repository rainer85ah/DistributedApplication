package practica1.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practica1.model.Person;
import practica1.model.Person.Job;
import practica1.repository.PersonRepository;

@Controller
public class ShowPersonByJob {
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping(value = "/showPersonalByJob")
	public String show(@RequestParam Job job, Model model) {	
		
		Collection<Person> persons = personRepository.findByJob(job);
		if (persons!=null){
	    	model.addAttribute("persons", persons);
	    	
			return "showPersonal";
		}
		else
			return "/notFound";
	}
}