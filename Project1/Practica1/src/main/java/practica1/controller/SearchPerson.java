package practica1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class SearchPerson {
		
	@RequestMapping("/searchPersonal")
	public String show(Model model) {
		model.addAttribute(model);
		return "searchPersonal";
	}
}