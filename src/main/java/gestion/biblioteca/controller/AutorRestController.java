package gestion.biblioteca.controller;

import java.net.URI;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gestion.biblioteca.model.AutorDTO;
import gestion.biblioteca.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorRestController {

	@Autowired
	AutorService autorService;

	@PostMapping
	ResponseEntity<?> crearAutor(@RequestBody AutorDTO autorDTO) {

		AutorDTO autor = autorService.crearAutor(autorDTO);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + autor.getId())
				.buildAndExpand(autor.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@GetMapping
	ResponseEntity<?> listaDeAutores(){
		
		List<AutorDTO> autores = autorService.listaDeAutores();
		
		if(!autores.isEmpty()) {
			return ResponseEntity.ok(autores);
		}
		
		return ResponseEntity.noContent().build();
	}

}
