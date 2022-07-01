package br.com.digitalhouse.thebookclub.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digitalhouse.thebookclub.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findTopByUsernameOrEmailOrCpf(String username, String email, String cpf);
	public Optional<Usuario> findTopByUsernameOrEmail(String username, String email);
	public Optional<Usuario> findByUsername(String username);
	public Optional<Usuario> findByEmail(String email);
	public Optional<Usuario> findByCpf(String cpf);
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
	
}
