package gestion.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import gestion.biblioteca.mappers.LibroMappers;
import gestion.biblioteca.model.LibroDTO;
import gestion.biblioteca.persistence.entities.AutorEntity;
import gestion.biblioteca.persistence.entities.LibroEntity;
import gestion.biblioteca.persistence.repositories.AutorRepository;
import gestion.biblioteca.persistence.repositories.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	LibroRepository libroRepository;

	@Autowired
	LibroMappers libroMappers;

	@Autowired
	AutorRepository autorRepository;

	@Override
	public LibroDTO crearLibro(LibroDTO libroDTO) {

		Long Autorid = libroDTO.getAutorId();

		Optional<AutorEntity> autor = autorRepository.findById(Autorid);

		if (autor.isPresent()) {
			LibroEntity libroEntity = libroMappers.libroDTOToLibroEntity(libroDTO);
			libroEntity.setAutor(autor.get());
			libroRepository.save(libroEntity);

			return libroMappers.libroEntityToLibroDTO(libroEntity);
		}

		throw new RuntimeException("El autor no está registrado");

		/*
		 * LibroEntity libro = libroMappers.libroDTOToLibroEntity(libroDTO);
		 * 
		 * AutorEntity autor = autorRepository.findById(libroDTO.getAutorId())
		 * .orElseThrow(() -> new RuntimeException("El autor no está registrado"));
		 * 
		 * libro.setAutor(autor);
		 * 
		 * libro = libroRepository.save(libro); return
		 * libroMappers.libroEntityToLibroDTO(libro);
		 */
	}

}
