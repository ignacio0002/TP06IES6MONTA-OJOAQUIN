package ar.edu.ies6.MontanoJoaquin.repository;


import ar.edu.ies6.MontanoJoaquin.model.Alumno;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//Hereda los metodos de otra clase
public interface AlumnoRepository extends CrudRepository <Alumno, Integer> {

	
	public List<Alumno> findByEstado(Boolean estado);
	//buscar por un  atributo especial
}
