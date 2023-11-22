package ar.edu.ies6.MontanoJoaquin.serviceDocente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.ies6.MontanoJoaquin.modelDocente.Docente;
import ar.edu.ies6.MontanoJoaquin.repositoryDocente.DocenteRepository;

@Service
public class DocenteService {

	@Autowired
	DocenteRepository docenteRepository;
	
	public void guardarDocente(Docente docente){
	
		docente.setEstado(true);
		docenteRepository.save(docente);
		
		
	}
	
	public void eliminarDocente(Integer dni) throws Exception {
		
		Docente auxiliar = new Docente();
		auxiliar = encontrarUnDocente(dni);
		auxiliar.setEstado(false);
		docenteRepository.save(auxiliar);
		
		
	}
	
	public  List<Docente> buscarTodosDocentes() {
		
		return (List<Docente>) docenteRepository.findByEstado(true);
	}
	
	public void modificarDocente() {
		
		
	}
	
	
	public Docente encontrarUnDocente(Integer dni) throws Exception {
		return docenteRepository.findById(dni).orElseThrow(() -> new Exception("Docente No Encontrado"));
	}
	
	
	
	public boolean existeDni(Integer dni) {
	    return docenteRepository.existsById(dni);
	}
	
	
}
