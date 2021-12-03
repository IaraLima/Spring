package br.org.generation.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.org.generation.blogpessoal.model.Tema;

import br.org.generation.blogpessoal.repository.TemaRepository;

@RestController //declarar classe como controle
@RequestMapping("/temas") //end-point
@CrossOrigin(origins = "*", allowedHeaders = "*") 

public class TemaController {
	
	@Autowired // implementa o conceito injeção de independencia, ele cria o objeto
	private TemaRepository temaRepository;
	
	@GetMapping
	public ResponseEntity <List<Tema>> getAll(){
		return ResponseEntity.ok(temaRepository.findAll()); // equivalente a select*from tbm_postagens
	}
	@GetMapping("/{id}")
	public ResponseEntity <Tema> getById(@PathVariable Long id){
		return temaRepository.findById(id)
        .map(resp -> ResponseEntity.ok(resp))
		.orElse(ResponseEntity.notFound().build());
	}
	
		
	@GetMapping ("/descricao/{descricao}")
	public ResponseEntity <List<Tema>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(temaRepository.findAllByDescricaoContainingIgnoreCase(descricao));
		// método personalizado, precisou criar na interface
	}

	@PostMapping
	public ResponseEntity <Tema> postTema(@Valid @RequestBody Tema tema){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));

	}
	
	@PutMapping
	public ResponseEntity<Tema>  putTema(@Valid @RequestBody Tema tema){
		//return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
		
		Optional <Tema> altera = temaRepository.findById(tema.getId());
				
		if (altera.isPresent()) 
		{
			return ResponseEntity.status(HttpStatus.OK).body(temaRepository.save(tema));
		} 
		else 
		{

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Tema> deleteTema(@PathVariable Long id) {
		//postagemRepository.deleteById(id);

		Optional<Tema> delete= temaRepository.findById(id);
		
		if(delete.isPresent()) 
		{
            temaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
		else 
        {
         return ResponseEntity.notFound().build();
        } 

	}

}