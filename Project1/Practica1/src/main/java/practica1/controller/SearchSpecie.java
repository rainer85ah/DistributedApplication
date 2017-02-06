package practica1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class SearchSpecie {
		
	@RequestMapping("/searchEspecie")
	public String home(Model model) {
		model.addAttribute(model);
		return "searchEspecie";
	}
}