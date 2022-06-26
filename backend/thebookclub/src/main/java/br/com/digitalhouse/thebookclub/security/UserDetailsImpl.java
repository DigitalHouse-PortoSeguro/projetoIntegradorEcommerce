package br.com.digitalhouse.thebookclub.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.digitalhouse.thebookclub.enums.TipoUsuario;
import br.com.digitalhouse.thebookclub.modelo.Usuario;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Collection<GrantedAuthority> authorities;
	private String username;
	private String password;

	public UserDetailsImpl(Usuario user) {
		this.username = user.getUsername();
		this.password = user.getSenha();
		
		this.authorities = new HashSet<GrantedAuthority>();
		this.authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		if (user.getTipoUsuario() == TipoUsuario.ADMIN) {
			this.authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
	}

	public UserDetailsImpl() {
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
