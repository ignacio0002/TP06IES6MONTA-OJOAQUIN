package ar.edu.ies6.MontanoJoaquin.controller;

import ar.edu.ies6.MontanoJoaquin.model.Alumno;
import ar.edu.ies6.MontanoJoaquin.util.ListadoAlumnos;

import java.time.LocalDate;

import java.util.ArrayList;

//import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class AlumnoController {
	
	@GetMapping({ "/index", "/", "/home", "/alumno" })
	public ModelAndView cargarAlumno(){
		
		Alumno alu = new Alumno();
		
		alu.setFechaNac(LocalDate.parse("1990-10-27"));
		System.out.println("Edad: "+alu.getEdad());

		ModelAndView modelView = new ModelAndView("index");

		modelView.addObject("alumno", alu);
		return modelView;
	
	}
	
	@PostMapping("/cargarAlumno")
	public ModelAndView cargarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		
		ListadoAlumnos.getListado().add(alumno);
		
		ModelAndView modelView = new ModelAndView("listadoAlumnos");
		
		modelView.addObject("listado", ListadoAlumnos.getListado());
		
		return modelView;
	}
	
}