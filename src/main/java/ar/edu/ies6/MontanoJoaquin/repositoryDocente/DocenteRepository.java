package ar.edu.ies6.MontanoJoaquin.repositoryDocente;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.ies6.MontanoJoaquin.modelDocente.Docente;


@Repository

public interface DocenteRepository extends CrudRepository <Docente, Integer> {

	
	public List<Docente> findByEstado(Boolean estado);
	
	
}
