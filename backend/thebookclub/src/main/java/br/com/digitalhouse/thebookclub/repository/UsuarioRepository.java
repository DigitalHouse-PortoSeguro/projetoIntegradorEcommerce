package br.com.digitalhouse.thebookclub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digitalhouse.thebookclub.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  public List<Usuario>findAllByNomeContainingIgnoreCase(String nome);

  public List<Usuario>findAllByUsernameContainingIgnoreCase(String username);
  
  //public Optional<Usuario> findByUsername(String username);
  //public Optional<Usuario> findByEmail(String email);
  //public Optional<Usuario> findByCpf(String cpf);
	
}
