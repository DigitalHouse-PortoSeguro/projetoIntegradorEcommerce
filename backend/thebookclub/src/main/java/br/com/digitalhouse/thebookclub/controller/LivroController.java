package br.com.digitalhouse.thebookclub.controller;

import java.util.List;
import java.util.Set;

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

import br.com.digitalhouse.thebookclub.modelo.Livro;
import br.com.digitalhouse.thebookclub.repository.LivroRepository;
import br.com.digitalhouse.thebookclub.service.LivroService;

@RestController
@RequestMapping("/livros")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private LivroService livroService;

	@GetMapping
	public ResponseEntity<List<Livro>> getAll() {
		return ResponseEntity.ok(livroRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> getById(@PathVariable Long id) {
		return livroRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Livro>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(livroRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Livro>> getByCategoria(@PathVariable String categoria) {
		return ResponseEntity.ok(livroRepository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	
	@GetMapping("/categorias")
	public ResponseEntity<Set<String>> getAllCategorias() {
		return ResponseEntity.ok(livroRepository.findAllCategorias());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Livro> cadastrar(@Valid @RequestBody Livro pedido) {
		return livroService.cadastrar(pedido)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.badRequest().build());
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Livro> atualizar(@Valid @RequestBody Livro pedido) {
		return livroService.atualizar(pedido)
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Livro> deletar(@PathVariable Long id) {
		return livroService.deletar(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
}

