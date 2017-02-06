package practica1.controller;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practica1.model.Area;
import practica1.model.Specie;
import practica1.model.Specie.Type;
import practica1.repository.AreaRepository;
import practica1.repository.SpecieRepository;

@Controller
public class AddSpecie {
	@Autowired
	private SpecieRepository specieRepository;
	@Autowired
	private AreaRepository areaRepository;

	@RequestMapping("/addSpecie")
	public String add(@RequestParam String name,
						   @RequestParam String scientificName,
						   @RequestParam Type type,
						   @RequestParam String image_url,
						   @RequestParam Set<String> areas,
						   Model model) {

		if (name.length()!=0){
			Specie specie =new Specie();
	        specie.setName(name);
	        specie.setScientificName(scientificName);
	        specie.setType(type);
		   	specie.setImage_url(image_url);
		   	
		   	Set<Area> ubicaciones = new HashSet<>();
		   	
		   	for (String s : areas)
		   	{
		   		Area a = areaRepository.findByName(s);
		   		if (!a.equals(null))
		   		{
		   			ubicaciones.add(a);	
		   		}
		   	}
		   	
		    specie.setAreas(ubicaciones);
	        specieRepository.save(specie);
	
			return "addCorrect";
		}
		else{
			return "/showAddEspecie";
		}
	}
}