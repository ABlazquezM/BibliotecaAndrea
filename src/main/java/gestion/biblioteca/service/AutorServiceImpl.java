package gestion.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.biblioteca.mappers.AutorMappers;
import gestion.biblioteca.model.AutorDTO;
import gestion.biblioteca.persistence.entities.AutorEntity;
import gestion.biblioteca.persistence.repositories.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService{
	
	@Autowired
	AutorRepository autorRepository;
	
	@Autowired
	AutorMappers autorMappers;

	@Override
	public AutorDTO crearAutor(AutorDTO autorDTO) {

		AutorEntity autorEntity = autorRepository.save(autorMappers.autorDTOToAutorEntity(autorDTO));
	
		return autorMappers.autorEntityToAutorDTO(autorEntity);
	}

	@Override
	public List<AutorDTO> listaDeAutores() {
		
		List<AutorEntity> listaAutoresEntity = autorRepository.findAll();
		
		List<AutorDTO> listaAutoresDTO = autorMappers.listaToDTO(listaAutoresEntity);
		
		return listaAutoresDTO;
	}
	
	

}
