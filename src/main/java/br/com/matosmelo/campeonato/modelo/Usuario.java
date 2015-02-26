package br.com.matosmelo.campeonato.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Long id;
	private String login;
	private String nome;
	private String senha;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuarioAmigo", joinColumns = @JoinColumn(name = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "idAmigo"))
	private Collection<Usuario> amigos;

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return this.id;
	}

	public Collection<Usuario> getAmigos() {
		return this.amigos;
	}

	public void setAmigos(Collection<Usuario> amigos) {
		this.amigos = amigos;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
