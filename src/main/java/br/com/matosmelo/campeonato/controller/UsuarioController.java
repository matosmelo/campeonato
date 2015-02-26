package br.com.matosmelo.campeonato.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.matosmelo.campeonato.dao.UsuarioDAO;
import br.com.matosmelo.campeonato.modelo.Usuario;
import br.com.matosmelo.campeonato.web.UsuarioWeb;

@Resource
public class UsuarioController {
	private final UsuarioDAO usuarioDAO;
	private final UsuarioWeb usuarioWeb;
	private final Result result;

	public UsuarioController(UsuarioDAO usuarioDAO, Result result,
			UsuarioWeb usuarioWeb) {
		this.usuarioDAO = usuarioDAO;
		this.usuarioWeb = usuarioWeb;
		this.result = result;

	}

	@Get("/loginUsuario")
	public void usuarioForm() {
	}

	@Post("/login")
	public void login(Usuario usuario) {
		Usuario carregado = usuarioDAO.carrega(usuario);
		usuarioWeb.login(carregado);
		result.redirectTo(IndexController.class).index();
	}

	@Get("/novoUsuario")
	public void novoUsuario() {
	}

	@Post("/adicionaUsuario")
	public void adicionaUsuario(Usuario usuario) {
		usuarioDAO.adiciona(usuario);
		result.redirectTo(UsuarioController.class).usuarioForm();
	}

	@Get("/listaUsuario")
	public List<Usuario> listaUsuario() {
		return usuarioDAO.lista();
	}

	@Get("/minhaConta")
	public Usuario minhaConta() {
		return usuarioDAO.carrega(usuarioWeb.getId());
	}

	@Delete("/removeUsuario/{id}")
	public void removeUsuario(Long id) {
		Usuario usuario = usuarioDAO.carrega(id);
		usuarioDAO.remove(usuario);
		result.redirectTo(UsuarioController.class).listaUsuario();
	}

	@Get("/editaUsuario/{id}")
	public Usuario editaUsuario(Long id) {
		Usuario usuario = usuarioDAO.carrega(id);
		return usuario;
	}

	@Put("/salvaUsuario")
	public void salvaUsuario(Usuario usuario) {
		usuarioDAO.salva(usuario);
		result.redirectTo(UsuarioController.class).listaUsuario();

	}

	// Amigos
	@Get("/novoAmigo/{id}")
	public void novoAmigo(Long id) {
		Usuario usuario = usuarioDAO.carrega(id);
		List<Usuario> usuarios = usuarioDAO.lista();
		result.include("usuario", usuario);
		result.include("usuarios", usuarios);
	}

	@Path("/adicionaAmigo/{id}")
	public void adicionaAmigo(Long id) {
		Usuario usuario = usuarioDAO.carrega(usuarioWeb.getId());
		usuario.getAmigos().add(usuarioDAO.carrega(id));
		usuarioDAO.salva(usuario);
		result.redirectTo(UsuarioController.class).minhaConta();
	}

}
