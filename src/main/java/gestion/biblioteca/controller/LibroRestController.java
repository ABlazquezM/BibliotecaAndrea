package gestion.biblioteca.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gestion.biblioteca.model.LibroDTO;
import gestion.biblioteca.service.LibroService;

@RestController
@RequestMapping("/libros")
public class LibroRestController {
	
	@Autowired
	LibroService libroService;
	
	@PostMapping
	ResponseEntity<?> crearLibro(@RequestBody LibroDTO libroDTO){
		
		LibroDTO libro = libroService.crearLibro(libroDTO);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/"+libro.getId()).buildAndExpand(libro.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

}
