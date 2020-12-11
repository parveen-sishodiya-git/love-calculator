package tech.sishodiyology.lovecalculator.dao.login;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tech.sishodiyology.lovecalculator.model.Login;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addLogin(Login login) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(login);
		System.out.println("saved successfully");
	}

	@Override
	@Transactional
	public void deleteLogin(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Login login = (Login) session.get(Login.class, id);
		if (login != null) {
			session.delete(login);
		}
	}

	@Override
	@Transactional
	public void updateLogin(Login login) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(login);
	}

	@Override
	@Transactional
	public Login getLoginById(int id) {
		System.out.println("getting login by id");
		Session session = this.sessionFactory.getCurrentSession();
		Login login = (Login) session.get(Login.class, id);
		return login;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Login> getLogins() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Login> loginList = session.createQuery("from login").list();
		return loginList;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Login getLoginByUsername(String username) {
		System.out.println("getting login by username mm  : "+username);
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("3007: 1");
		String hql = "from login l where l.username='";
		Query query = session.createQuery("from Login l where l.username=:u");
		System.out.println("3007: 2");
		query.setParameter("u", username);
		System.out.println("3007: 3");
		List<Login> login = query.getResultList();
		System.out.println("3007: 4");
		System.out.println("getting result query made");
		
		if(login != null && !login.isEmpty()) {
			return login.get(0);
		}
		System.out.println("list is empty or null");
		return null;
	}

}
