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
public class EditSpecie {
	@Autowired
	private SpecieRepository specieRepository;
	@Autowired
	private AreaRepository areaRepository;

	@RequestMapping("/editEspecie")
	public String edit(	@RequestParam String name,   
						@RequestParam String scientificName,
						   @RequestParam String image_url,
						   @RequestParam Type type,
						   @RequestParam Set<String> areas,
						   Model model) {

        Specie specie = specieRepository.findByName(name);
        if (!specie.equals(null))
        {
        	if (!scientificName.equals(""))
        		specie.setScientificName(scientificName);
        	if (!image_url.equals(""))
        		specie.setImage_url(image_url);
        	specie.setType(type);
        	if (!areas.isEmpty())
        	{
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
        	}
        	
	        specieRepository.save(specie);
	        model.addAttribute(model);
	        return "editCorrect";
        }
		return "searchEspecie";
	}
}