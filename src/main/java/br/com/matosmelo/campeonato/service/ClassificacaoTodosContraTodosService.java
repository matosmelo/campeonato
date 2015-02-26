package br.com.matosmelo.campeonato.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.matosmelo.campeonato.modelo.Classificacao;
import br.com.matosmelo.campeonato.modelo.Jogo;

@SuppressWarnings("deprecation")
@Component
public class ClassificacaoTodosContraTodosService {

	// Gera classificação
	@SuppressWarnings("unchecked")
	public List<Classificacao> listarClassificacao(String nomeDaCompeticao) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		// Busca no banco os jogos
		List<Jogo> jogos = session.createQuery(
				"select jogo from Jogo jogo where jogo.nomeDaCompeticao='"
						+ nomeDaCompeticao + "' ").list();

		// Map K = nome do time, V = time na tabela de classificação
		Map<String, Classificacao> tabelaClassificacao = new HashMap<String, Classificacao>();

		Classificacao usuarioMandanteNaTabela = new Classificacao();
		Classificacao usuarioVisitanteNaTabela = new Classificacao();

		// Itera os jogos
		for (Jogo jogo : jogos) {
			usuarioMandanteNaTabela = new Classificacao();
			usuarioVisitanteNaTabela = new Classificacao();

			// Verifica se o time já existe na tabela, caso contrário, adiciona
			if (!tabelaClassificacao.containsKey(jogo.getMandante().getNome())
					|| !tabelaClassificacao.containsKey(jogo.getVisitante()
							.getNome())) {

				// Set clube mandadate e adiciona no Map
				usuarioMandanteNaTabela.setUsuario(jogo.getMandante());
				tabelaClassificacao.put(jogo.getMandante().getNome(),
						usuarioMandanteNaTabela);

				// Set clube Visitante e adiciona no Map
				usuarioVisitanteNaTabela.setUsuario(jogo.getVisitante());
				tabelaClassificacao.put(jogo.getVisitante().getNome(),
						usuarioVisitanteNaTabela);
			}

			// verifica se o numero de gols não são nulos antes de fazer os
			// calculos
			if (jogo.getGolsMandante() != null
					&& jogo.getGolsVisitante() != null) {

				// Pega o nome dos clubes
				usuarioMandanteNaTabela = tabelaClassificacao.get(jogo
						.getMandante().getNome());
				usuarioVisitanteNaTabela = tabelaClassificacao.get(jogo
						.getVisitante().getNome());

				// Set aos clubes a quantidade de jogos
				usuarioMandanteNaTabela.setJogos(usuarioMandanteNaTabela
						.getJogos() + 1);
				usuarioVisitanteNaTabela.setJogos(usuarioVisitanteNaTabela
						.getJogos() + 1);

				// Set vitoria para mandante, derrota para visitante e pontos
				if (jogo.getGolsMandante() > jogo.getGolsVisitante()) {
					usuarioMandanteNaTabela.setPontos(usuarioMandanteNaTabela
							.getPontos() + 3);
					usuarioMandanteNaTabela.setVitorias(usuarioMandanteNaTabela
							.getVitorias() + 1);
					usuarioVisitanteNaTabela
							.setDerrotas(usuarioVisitanteNaTabela.getDerrotas() + 1);
				}

				// Set vitoria visitante, derrota para mandante e pontos
				else if (jogo.getGolsMandante() < jogo.getGolsVisitante()) {
					usuarioVisitanteNaTabela.setPontos(usuarioVisitanteNaTabela
							.getPontos() + 3);
					usuarioVisitanteNaTabela
							.setVitorias(usuarioVisitanteNaTabela.getVitorias() + 1);
					usuarioMandanteNaTabela.setDerrotas(usuarioMandanteNaTabela
							.getDerrotas() + 1);
				}

				// Set empate e pontos
				else {
					usuarioMandanteNaTabela.setPontos(usuarioMandanteNaTabela
							.getPontos() + 1);
					usuarioVisitanteNaTabela.setPontos(usuarioVisitanteNaTabela
							.getPontos() + 1);
					usuarioMandanteNaTabela.setEmpates(usuarioMandanteNaTabela
							.getEmpates() + 1);
					usuarioVisitanteNaTabela
							.setEmpates(usuarioVisitanteNaTabela.getEmpates() + 1);
				}

				// Set quantidade de gols pros e contras para mandante e
				// visitante
				usuarioMandanteNaTabela.setGolsPro(usuarioMandanteNaTabela
						.getGolsPro() + jogo.getGolsMandante());
				usuarioMandanteNaTabela.setGolsContra(usuarioMandanteNaTabela
						.getGolsContra() + jogo.getGolsVisitante());
				usuarioVisitanteNaTabela.setGolsPro(usuarioVisitanteNaTabela
						.getGolsPro() + jogo.getGolsVisitante());
				usuarioVisitanteNaTabela.setGolsContra(usuarioVisitanteNaTabela
						.getGolsContra() + jogo.getGolsMandante());

				// Set saldo de gols para mandante e visitante
				usuarioMandanteNaTabela
						.setSaldoDeGols(usuarioMandanteNaTabela.getGolsPro()
								- usuarioMandanteNaTabela.getGolsContra());
				usuarioVisitanteNaTabela
						.setSaldoDeGols(usuarioVisitanteNaTabela.getGolsPro()
								- usuarioVisitanteNaTabela.getGolsContra());
			}

		}

		// Tansforma Map em List
		List<Classificacao> listaDeClassificacao = new ArrayList<Classificacao>(
				tabelaClassificacao.values());

		// Ordena a Lista
		Collections.sort(listaDeClassificacao);

		return listaDeClassificacao;
	}

}
