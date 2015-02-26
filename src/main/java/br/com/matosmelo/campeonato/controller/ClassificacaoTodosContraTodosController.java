package br.com.matosmelo.campeonato.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.matosmelo.campeonato.dao.JogoDAO;
import br.com.matosmelo.campeonato.modelo.Classificacao;
import br.com.matosmelo.campeonato.modelo.Jogo;
import br.com.matosmelo.campeonato.service.ClassificacaoTodosContraTodosService;

@Resource
public class ClassificacaoTodosContraTodosController {

	private ClassificacaoTodosContraTodosService classificacaoTodosContraTodosService;
	private JogoDAO jogoDAO;
	private Result result;

	public ClassificacaoTodosContraTodosController(
			ClassificacaoTodosContraTodosService classificacaoTodosContraTodosService,
			JogoDAO jogoDAO, Result result) {
		this.classificacaoTodosContraTodosService = classificacaoTodosContraTodosService;
		this.jogoDAO = jogoDAO;
		this.result = result;
	}

	@Get("/classificacaoTodosContraTodos/{nomeDaCompeticao}")
	public void classificacaoTodosContraTodos(String nomeDaCompeticao) {
		List<Classificacao> classificacaoTodosContraTodos = classificacaoTodosContraTodosService
				.listarClassificacao(nomeDaCompeticao);
		List<Jogo> listaJogo = jogoDAO.listaNomeDaCompeticao(nomeDaCompeticao);

		result.include("classificacaoList", classificacaoTodosContraTodos);
		result.include("jogoList", listaJogo);
		result.include("nomeDaCompeticao", nomeDaCompeticao);
	}
}
