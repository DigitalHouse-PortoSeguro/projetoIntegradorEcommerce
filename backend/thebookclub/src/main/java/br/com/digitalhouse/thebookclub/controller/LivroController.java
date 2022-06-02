package br.com.digitalhouse.thebookclub.controller;

import java.util.List;

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

import br.com.digitalhouse.thebookclub.modelo.Livro;
import br.com.digitalhouse.thebookclub.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping("/consultar")
	public ResponseEntity<List<Livro>> GetAll(){
		return ResponseEntity.ok(livroRepository.findAll());
	}
	
	@GetMapping("/consultar/{id}")
	public ResponseEntity<Livro> GetById(@PathVariable Long id){
		return livroRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/consultar/{titulo}")
	public ResponseEntity<List<Livro>>GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(livroRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Livro> post (@RequestBody Livro livro){
		return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livro));
	}
	
		@PutMapping("/atualizar")
	public ResponseEntity<Livro> put (@RequestBody Livro livro){
		return ResponseEntity.status(HttpStatus.OK).body(livroRepository.save(livro));
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return livroRepository.findById(id).map(resp -> {
				livroRepository.deleteById(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
	
}