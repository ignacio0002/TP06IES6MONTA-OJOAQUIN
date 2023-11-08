package ar.edu.ies6.MontanoJoaquin.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.ies6.MontanoJoaquin.model.Alumno;
import ar.edu.ies6.MontanoJoaquin.repository.AlumnoRepository;


@Service
public class AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository;
	
	public void guardarAlumno(Alumno alumno){
		//metodo para guardar
	
		alumno.setEstado(true);
		alumnoRepository.save(alumno);
		
	}
	
	public void eliminarAlumno(Integer dni) {
		//eliminar un objeto por su identificador
		
		
	}
	
	public List<Alumno> buscarTodosAlumnos() {
		
		//algoritmo para buscar alumnos
		
		//List<Alumno> listado = new ArrayList<> ();
		
		//return listado;
		//castear alumnorepository
		return (List<Alumno>) alumnoRepository.findAll();
	}
	
	public void modificarAlumno(Alumno alumno) {
		
		
	}
	
	//Todos los Servicios
}
