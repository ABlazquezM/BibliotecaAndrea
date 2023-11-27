package gestion.biblioteca.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import gestion.biblioteca.model.LibroDTO;
import gestion.biblioteca.persistence.entities.AutorEntity;
import gestion.biblioteca.persistence.entities.LibroEntity;

@Mapper(componentModel = "spring")
public interface LibroMappers {
	
	@Mapping(source = "autor", target = "autorId", qualifiedByName = "mapAutorId")
	LibroDTO libroEntityToLibroDTO(LibroEntity libroEntity);
	
	LibroEntity libroDTOToLibroEntity(LibroDTO libroDTO);
	
	@Named("mapAutorId")
	default Long mapAutorId(AutorEntity autorEntity) {
		if(autorEntity != null) {
			return autorEntity.getId();
		}
		
		return null;
	}
}
