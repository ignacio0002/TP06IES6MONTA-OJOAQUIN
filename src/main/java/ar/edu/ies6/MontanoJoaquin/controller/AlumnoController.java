package ar.edu.ies6.MontanoJoaquin.controller;

import ar.edu.ies6.MontanoJoaquin.model.Alumno;
import ar.edu.ies6.MontanoJoaquin.service.AlumnoService;
//import ar.edu.ies6.MontanoJoaquin.util.ListadoAlumnos;

import org.springframework.beans.factory.annotation.Autowired;

//import java.time.LocalDate;

//import java.util.ArrayList;

//import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class AlumnoController {
	
	@Autowired
	Alumno alumno;
	
	@Autowired
	AlumnoService alumnoService;
	
	
	
	@GetMapping({ "/index","/home","/","/principal" })
	public ModelAndView mostrarMenu(){
		
		ModelAndView modelView = new ModelAndView("principal");

		
		return modelView;
	
	}
	
	@GetMapping({ "/alumno" })
	public ModelAndView cargarAlumno(){
		
		Alumno alu = new Alumno();
		
		ModelAndView modelView = new ModelAndView("index");

		modelView.addObject("alumno", alu);
		return modelView;
	
	}
	
	@PostMapping("/cargarAlumno")
	public ModelAndView cargarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		
		//ListadoAlumnos.getListado().add(alumno);
		
		//alumnoService.guardarAlumno(alumno);
		//se guarda en la bd
		
		ModelAndView modelView = new ModelAndView("listadoAlumnos");
		
		
		
		if (alumnoService.existeDni(alumno.getDni())) {
	    	
	        modelView.setViewName("index"); // Nombre de la vista de carga de docentes
	        
	        modelView.addObject("errorDni", "El DNI ya está registrado");
	    } else {
	        alumnoService.guardarAlumno(alumno);
	        
	        modelView.setViewName("listadoAlumnos"); // Nombre de la vista de listado de docentes
	        
	        modelView.addObject("listado", alumnoService.buscarTodosAlumnos());
	        
	    }
		
		//modelView.addObject("listado", ListadoAlumnos.getListado());
		//buscar de la bd
		//modelView.addObject("listado", alumnoService.buscarTodosAlumnos());
		
		return modelView;
	}
	
	//metodo para eliminar un registro
	
	@GetMapping("/eliminarAlumno/{dni}")
	public String eliminarAlumno(@PathVariable Integer dni) throws Exception{
		
		
		alumnoService.eliminarAlumno(dni);
	
		//for(int i=0;i <ListadoAlumnos.getListado().size();i++) {
			//if(ListadoAlumnos.getListado().get(i).getDni().equals(dni)) {
				////ListadoAlumnos.getListado().get(i).setEstado(false);
				//ListadoAlumnos.getListado().remove(i);
			//}
		//}
		//ModelAndView modelView = new ModelAndView("listadoAlumnos");
		//modelView.addObject("listado", ListadoAlumnos.getListado());
		
		//return modelView;
	
		return "redirect:/mostrarListado";
	}
	@GetMapping("/mostrarListado")
	public ModelAndView mostrarAlumnos() {
		
		ModelAndView listado = new ModelAndView("listadoAlumnos");
		listado.addObject("listado", alumnoService.buscarTodosAlumnos());
		
		
		return listado;
	}
	
	//metodo para modificar un registro
	@GetMapping("/modificarAlumno/{dni}")
	public ModelAndView modificarAlumno(@PathVariable Integer dni) throws Exception{
		
		 
	   
		ModelAndView modificaAlumno = new ModelAndView("modificarALumno");
		modificaAlumno.addObject("alumno", alumnoService.encontrarUnAlumno(dni));
		
		
		return modificaAlumno;
	
	}
	
	@PostMapping("/modificarALumno")
	public ModelAndView modificarUnAlumno(@ModelAttribute ("alumno") Alumno alumno){
		
		alumnoService.guardarAlumno(alumno);
		
		ModelAndView modelView = new ModelAndView ("listadoAlumnos");
		
		modelView.addObject("listado", alumnoService.buscarTodosAlumnos());
		
		return modelView;
	
	
	}
	
	@PostMapping("/cargarAlumnoModificado")
	public ModelAndView cargarAlumnoModificado(@ModelAttribute("alumno") Alumno alumno) {
		
		alumnoService.guardarAlumno(alumno);
		
		
		ModelAndView modelView = new ModelAndView ("listadoAlumnos");
		
		
		modelView.addObject("listado", alumnoService.buscarTodosAlumnos());
		
		return modelView;
			
	
	}
	
	
		
}