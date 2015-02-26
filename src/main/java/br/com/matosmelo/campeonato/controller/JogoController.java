package br.com.matosmelo.campeonato.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.matosmelo.campeonato.dao.JogoDAO;
import br.com.matosmelo.campeonato.dao.UsuarioDAO;
import br.com.matosmelo.campeonato.modelo.Jogo;
import br.com.matosmelo.campeonato.modelo.Usuario;
import br.com.matosmelo.campeonato.service.TodosContraTodosService;
import br.com.matosmelo.campeonato.web.UsuarioWeb;

@Resource
public class JogoController {

	private JogoDAO jogoDAO;
	private UsuarioDAO usuarioDAO;
	private UsuarioWeb usuarioWeb;
	private Result result;
	private TodosContraTodosService todosContraTodosService;

	public JogoController(UsuarioWeb usuarioWeb, Result result,
			JogoDAO jogoDAO, UsuarioDAO usuarioDAO,
			TodosContraTodosService todosContraTodosService) {
		this.result = result;
		this.jogoDAO = jogoDAO;
		this.usuarioDAO = usuarioDAO;
		this.usuarioWeb = usuarioWeb;
		this.todosContraTodosService = todosContraTodosService;
	}

	@Get("/novoJogo")
	public List<Usuario> novoJogo() {
		return usuarioDAO.lista();
	}

	@Get("/listaJogo")
	public List<Jogo> listaJogo() {
		return jogoDAO.lista();
	}

	@Post("/adicionaJogo")
	public void adicionaJogo(Jogo jogo, Usuario usuario) {
		jogoDAO.adiciona(jogo);
		result.redirectTo(CompeticaoController.class).competicoesAntigasX1();
	}

	@Delete("/removeJogo/{id}")
	public void removeJovo(Long id) {
		Jogo jogo = jogoDAO.carrega(id);
		jogoDAO.remove(jogo);
		result.redirectTo(JogoController.class).listaJogo();
	}

	@Get("/editaJogo/{id}")
	public void editaJogo(Long id) {
		Jogo jogo = jogoDAO.carrega(id);
		List<Usuario> usuario = usuarioDAO.lista();
		result.include("usuarios", usuario);
		result.include("jogo", jogo);
	}

	@Get("/listaJogoX1")
	public List<Jogo> listaJogoX1() {
		return jogoDAO.listaString(usuarioWeb.getLogin(), (long) 2);
	}

	@Put("/salvaJogo")
	public void salvaJogo(Jogo jogo) {
		jogoDAO.salva(jogo);
		result.redirectTo(JogoController.class).listaJogo();
	}

	@Get("/editaJogoTodosContraTodos/{id}")
	public void editaJogoTodosContraTodos(Long id) {
		Jogo jogo = jogoDAO.carrega(id);
		List<Usuario> usuario = usuarioDAO.lista();
		result.include("usuarios", usuario);
		result.include("jogo", jogo);
	}


	@Put("/salvaJogoTodosContraTodos")
	public void salvaJogoTodosContraTodos(Jogo jogo) {
		jogoDAO.salva(jogo);
		result.redirectTo(ClassificacaoTodosContraTodosController.class)
				.classificacaoTodosContraTodos(jogo.getNomeDaCompeticao());
	}

	@Path("/criaJogo")
	public void criaJogo(Jogo jogo) {
		todosContraTodosService.listaTodosContraTodos(jogo
				.getNomeDaCompeticao());

		result.redirectTo(JogoController.class)
				.jogoDaCompeticaoTodosContraTodos(jogo.getNomeDaCompeticao());
	}

	@Get("/jogoDaCompeticaoTodosContraTodos")
	public List<Jogo> jogoDaCompeticaoTodosContraTodos(String nomeDaCompeticao) {
		return jogoDAO.listaNomeDaCompeticao(nomeDaCompeticao);
	}
}
