package br.com.matosmelo.campeonato.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.matosmelo.campeonato.dao.JogoDAO;
import br.com.matosmelo.campeonato.dao.UsuarioDAO;
import br.com.matosmelo.campeonato.modelo.Competidor;
import br.com.matosmelo.campeonato.modelo.Jogo;
import br.com.matosmelo.campeonato.modelo.Usuario;
import br.com.matosmelo.campeonato.web.UsuarioWeb;

@Resource
public class CompeticaoController {

	private UsuarioDAO usuarioDAO;
	private JogoDAO jogoDAO;
	private UsuarioWeb usuarioWeb;
	private Result result;

	public CompeticaoController(UsuarioWeb usuarioWeb, UsuarioDAO usuarioDAO,
			JogoDAO jogoDAO, Result result) {
		this.usuarioDAO = usuarioDAO;
		this.jogoDAO = jogoDAO;
		this.usuarioWeb = usuarioWeb;
		this.result = result;
	}
	
	@Get("/competicoes")
	public List<Jogo> competicoes() {
		return jogoDAO.lista();
	}
	
	@Get("/tipoDeCompeticao/{id}")
	public List<Jogo> tipoDeCompeticao(Long id) {
		return jogoDAO.listaValor(id);
	}

	@Path("/selecionaCompeticao")
	public void selecionaCompeticao() {
	}

	@Get("/competicaoTodosContraTodos")
	public List<Usuario> competicaoTodosContraTodos() {
		return usuarioDAO.lista();
	}

	@Get("/competicaoX1")
	public void competicaoX1() {
		List<Jogo> jogo = jogoDAO
				.listaString(usuarioWeb.getLogin(), ((long) 2));
		List<Usuario> usuario = usuarioDAO.lista();
		result.include("jogoList", jogo);
		result.include("usuarioList", usuario);
	}

	@Path("/competicoesAntigas")
	public void competicoesAntigas() {
	}

	@Get("/competicoesAntigasTodosContraTodos")
	public List<String> competicoesAntigasTodosContraTodos() {
		return jogoDAO.listaCompeticoes(usuarioWeb.getLogin(), ((long) 1));
	}
	@Get("/competicoesAntigasX1")
	public List<Jogo> competicoesAntigasX1() {
		return jogoDAO.listaString(usuarioWeb.getLogin(), ((long) 2));
	}

	@Path("/competidores")
	public void competidores(List<Competidor> competidor) {
		for (Competidor usuario : competidor) {
			System.out.println("nome do competidor: " + usuario.toString());

		}
		result.redirectTo(CompeticaoController.class)
				.competicaoTodosContraTodos();
	}
}
