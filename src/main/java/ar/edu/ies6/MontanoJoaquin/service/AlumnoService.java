package ar.edu.ies6.MontanoJoaquin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.ies6.MontanoJoaquin.model.Alumno;

@Service
public class AlumnoService {

	public void guardarAlumno(Alumno alumno){
		//metodo para guardar
	
	}
	
	public void eliminarAlumno(Integer dni) {
		//eliminar un objeto por su identificador
		
		
	}
	
	public List<Alumno> buscarTodosAlumnos() {
		//algoritmo para buscar alumnos
		
		List<Alumno> listado = new ArrayList<> ();
		
		return listado;
	}
	
	public void modificarAlumno(Alumno alumno) {
		
		
	}
	
	//Todos los Servicios
}
