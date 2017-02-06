package practica1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import practica1.model.Area;
import practica1.repository.AreaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class Map {
	@Autowired
	private AreaRepository areaRepository;
	
	@RequestMapping("/map")
	public String home(Model model) {
		
		List<Area> areas = areaRepository.findAll();				
		model.addAttribute("areas", areas);
		return "map";
	}

}