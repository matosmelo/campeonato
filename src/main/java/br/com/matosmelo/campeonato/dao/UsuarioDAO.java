package br.com.matosmelo.campeonato.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.Component;
import br.com.matosmelo.campeonato.modelo.Usuario;

@SuppressWarnings("deprecation")
@Component
public class UsuarioDAO {

	public void adiciona(Usuario usuario) {

		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		session.save(usuario);
		transaction.commit();
	}

	public Usuario carrega(Usuario usuario) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		return (Usuario) session.createQuery(
				"from Usuario where login='" + usuario.getLogin()
						+ "' and senha='" + usuario.getSenha() + "'")
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> lista() {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		return session.createQuery(
				"select usuario from Usuario as usuario order by nome asc")
				.list();

	}

	public Usuario carrega(Long id) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		return (Usuario) session.load(Usuario.class, id);

	}

	public void remove(Usuario usuario) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		session.delete(usuario);
		transaction.commit();

	}

	public void salva(Usuario usuario) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		session.merge(usuario);
		transaction.commit();
	}

}
