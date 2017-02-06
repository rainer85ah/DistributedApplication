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
public class EditPerson {
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping("/editPersonal")
	public String edit(@RequestParam String name,
						   @RequestParam String lastname,
						   @RequestParam String email,
						   @RequestParam String telephone,
						   @RequestParam String mobile,
						   @RequestParam Job job,
						   @RequestParam String image_url,
						   Model model) {

        Person person = personRepository.findByNameAndLastname(name, lastname);
        if (!person.equals(null))
        {
        	if (!email.equals(""))
        		person.setEmail(email);
        	if (!telephone.equals(""))
        		person.setTelephone(telephone);
        	if (!mobile.equals(""))
        		person.setMobile(mobile);
        	if (0 <= job.ordinal() && job.ordinal() <= 3)
        		person.setJob(job);  
        	if (!image_url.equals(""))
        		person.setImage_url(image_url);
	        
	        personRepository.save(person);
			return "editCorrect";
        }
        return "searchPersonal";	
	}
}