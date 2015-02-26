package br.com.matosmelo.campeonato.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.matosmelo.campeonato.modelo.Jogo;

@SuppressWarnings("deprecation")
@Component
public class JogoDAO {

	public void adiciona(Jogo jogo) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		session.save(jogo);
		transaction.commit();

	}

	@SuppressWarnings("unchecked")
	public List<Jogo> lista() {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		return session.createQuery("select jogo from Jogo as jogo").list();

	}

	// Lista competicoes do usuario
	@SuppressWarnings("unchecked")
	public List<String> listaCompeticoes(String login, Long id) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		List<String> competicoes = new ArrayList<String>();

		List<Jogo> jogos = session.createQuery(
				"select jogo from Jogo as jogo where jogo.visitante.login = '"
						+ login + "'and jogo.tipoDeCompeticao = '" + id
						+ "' or jogo.mandante.login = '" + login
						+ "' and jogo.tipoDeCompeticao = '" + id + "' ").list();
		for (Jogo jogo : jogos) {
			if (!competicoes.contains(jogo.getNomeDaCompeticao())) {
				competicoes.add(jogo.getNomeDaCompeticao());
			}
		}
		return competicoes;

	}

	// Lista por tipo de competicao
	@SuppressWarnings("unchecked")
	public List<Jogo> listaValor(Long id) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		return session.createQuery(
				"select jogo from Jogo as jogo where jogo.tipoDeCompeticao ='"
						+ id + "'").list();

	}

	@SuppressWarnings("unchecked")
	public List<Jogo> listaNomeDaCompeticao(String nomeDaCompeticao) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		return session.createQuery(
				"select jogo from Jogo as jogo where jogo.nomeDaCompeticao = '"
						+ nomeDaCompeticao + "'").list();

	}

	// Lista jogos do usuario por tipo de competicao
	@SuppressWarnings("unchecked")
	public List<Jogo> listaString(String login, Long id) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		return session.createQuery(
				"select jogo from Jogo as jogo where jogo.visitante.login = '"
						+ login + "'and jogo.tipoDeCompeticao = '" + id
						+ "' or jogo.mandante.login = '" + login
						+ "' and jogo.tipoDeCompeticao = '" + id
						+ "' order by id asc").list();

	}

	public Jogo carrega(Long jogo) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		return (Jogo) session.load(Jogo.class, jogo);
	}

	public void remove(Jogo jogo) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		session.delete(jogo);
		transaction.commit();

	}

	public void salva(Jogo jogo) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		session.merge(jogo);
		transaction.commit();

	}

}
