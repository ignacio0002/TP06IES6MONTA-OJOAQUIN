package ar.edu.ies6.MontanoJoaquin.controllerDocente;


//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.MontanoJoaquin.modelDocente.Docente;
import ar.edu.ies6.MontanoJoaquin.serviceDocente.DocenteService;



@Controller

public class DocenteController {
	
	@Autowired
	Docente docente;
	
	@Autowired
	DocenteService docenteService;

	@GetMapping({ "/docente" })
	public ModelAndView cargarDocente() {
		
		Docente doce = new Docente();
		
		
		ModelAndView modelView = new ModelAndView("cargaDocente");

		modelView.addObject("docente", doce);

		return modelView;
	}
	
	@PostMapping("/cargarDocente")
	public ModelAndView cargarDocente(@ModelAttribute("docente") Docente docente) {
		
		
		ModelAndView modelView = new ModelAndView("listadoDocentes");
		
		 // Verificar si el DNI ya existe en la base de datos
	    if (docenteService.existeDni(docente.getDni())) {
	    	
	        modelView.setViewName("cargaDocente"); // Nombre de la vista de carga de docentes
	        
	        modelView.addObject("errorDni", "El DNI ya está registrado");
	    } else {
	        docenteService.guardarDocente(docente);
	        
	        modelView.setViewName("listadoDocentes"); // Nombre de la vista de listado de docentes
	        
	        modelView.addObject("listado", docenteService.buscarTodosDocentes());
	        
	    }
		
		
	    return modelView;
	}
	
	@GetMapping("/eliminarDocente/{dni}")
	public String eliminarDocente(@PathVariable Integer dni) throws Exception {
		
		docenteService.eliminarDocente(dni);
		
		return "redirect:/mostrarListadoDocente";
	}
	
	@GetMapping("/mostrarListadoDocente")
	public ModelAndView mostrarDocentes() {
		
		ModelAndView listado = new ModelAndView("listadoDocentes");
		
		listado.addObject("listado", docenteService.buscarTodosDocentes());
		
		return listado;
		
	}
	
	@GetMapping("/modificarDocente/{dni}")
	public ModelAndView modificarDocente(@PathVariable Integer dni) throws Exception {
		
		ModelAndView modificaDocente = new ModelAndView ("cargaDocente");
		
		modificaDocente.addObject("docente", docenteService.encontrarUnDocente(dni));
		
		return modificaDocente;
	}
	
	@PostMapping("/modificarDocente")
	public ModelAndView modificarUnDocente(@ModelAttribute ("docente") Docente docente) {
		
		docenteService.guardarDocente(docente);
		
		ModelAndView modelView = new ModelAndView("listadoDocentes");
		
		modelView.addObject("listado", docenteService.buscarTodosDocentes());
		
		return modelView;
		
		
	}
	
	
	
}
