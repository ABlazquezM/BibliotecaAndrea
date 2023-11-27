package gestion.biblioteca.service;

import java.util.List;
import gestion.biblioteca.model.AutorDTO;
public interface AutorService {

	AutorDTO crearAutor(AutorDTO autorDTO);
	
	List<AutorDTO> listaDeAutores();
	
}
