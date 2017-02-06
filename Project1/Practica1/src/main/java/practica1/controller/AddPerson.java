package practica1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practica1.model.Person;
import practica1.model.Person.Job;
import practica1.repository.PersonRepository;

@Controller
public class AddPerson {
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping("/addPerson")
	public String add(@RequestParam String name,
						   @RequestParam String lastname,
						   @RequestParam String email,
						   @RequestParam String telephone,
						   @RequestParam String mobile,
						   @RequestParam Job job,
						   @RequestParam String image_url,
						   Model model) {

        if (name.length()!=0 && lastname.length()!=0){
			Person person =new Person();
	        person.setName(name);
	        person.setLastname(lastname);
	        person.setEmail(email);
	        person.setTelephone(telephone);
	        person.setMobile(mobile);
	        person.setJob(job);   	 
		   	person.setImage_url(image_url);
		   		   		   	
	        personRepository.save(person);
	
			return "addCorrect";
		}
        else{
        	return "/showAddPersonal";
        }
	}
}