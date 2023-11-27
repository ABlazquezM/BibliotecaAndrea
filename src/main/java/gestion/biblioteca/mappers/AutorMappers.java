package gestion.biblioteca.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import gestion.biblioteca.model.AutorDTO;
import gestion.biblioteca.persistence.entities.AutorEntity;

@Mapper(componentModel = "spring", uses = {LibroMappers.class})
public interface AutorMappers {
	
	AutorDTO autorEntityToAutorDTO(AutorEntity autorEntity);
	
	AutorEntity autorDTOToAutorEntity(AutorDTO autorDTO);
	
	List<AutorDTO> listaToDTO(List<AutorEntity> listaEntity);

}
