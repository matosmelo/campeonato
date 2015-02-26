package br.com.matosmelo.campeonato.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.matosmelo.campeonato.dao.JogoDAO;
import br.com.matosmelo.campeonato.modelo.Jogo;
import br.com.matosmelo.campeonato.modelo.Usuario;

@SuppressWarnings("deprecation")
@Component
public class TodosContraTodosService {

	@SuppressWarnings("unchecked")
	public List<Jogo> listaTodosContraTodos(String nomeDaCompeticao) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		List<Usuario> listaUsuarios = session.createQuery(
				"select usuario from Usuario as usuario order by nome asc")
				.list();

		// So funciona com numero par
		for (int j = 1; j <= (listaUsuarios.size() - 1); j++) {

			for (int i = 0; i < (listaUsuarios.size() / 2); i++) {
				JogoDAO jogoDAO = new JogoDAO();
				Jogo jogo = new Jogo();
				Usuario mandante = listaUsuarios.get(i);
				Usuario visitante = listaUsuarios
						.get((listaUsuarios.size() - 1) - i);

				jogo.setMandante(mandante);
				jogo.setVisitante(visitante);
				jogo.setTipoDeCompeticao(1);
				jogo.setNomeDaCompeticao(nomeDaCompeticao);
				jogoDAO.adiciona(jogo);

			}
			Usuario ultimo = listaUsuarios.remove(listaUsuarios.size() - 1);
			listaUsuarios.add(1, ultimo);
		}

		List<Jogo> jogos = session.createQuery("select jogo from Jogo as jogo")
				.list();
		return jogos;
	}
}
