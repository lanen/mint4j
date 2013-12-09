package evanq.game.database.impl;

import java.io.File;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import evanq.game.database.MintDataBase;


/**
 * 
 * @author Evan
 *
 */
public class HibernateMintDatabase extends MintDataBase {
	
	private SessionFactory sessionFactory;
	
	private ServiceRegistry serviceRegistry;
	
	
	public HibernateMintDatabase(){
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();        
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);

	}
	
	public HibernateMintDatabase(String filename){
		
		Configuration cfg = new Configuration();
		File f = new File(filename);
		cfg.configure(f);
		
		serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();        
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	}
	
	@Override
	public void execute(String sql) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.createQuery(sql);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public <T> void save(T object) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public <T> void update(T object) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public <T> void delete(T object) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz, String where, Object... args){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query createQuery = session.createQuery(" from "+clazz.getSimpleName() + " where "+where);
		for (int i = 0; i < args.length; i++) {
			createQuery.setParameter(i, args[i]);
		}
		
		List<T> list = (List<T>)createQuery.list();
		session.getTransaction().commit();
		session.close();
		return list.isEmpty()? null : list.get(0);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> list(Class<T> clazz, String where, Object... args) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query createQuery = session.createQuery(" from "+clazz.getSimpleName() + " where "+where);
		for (int i = 0; i < args.length; i++) {
			createQuery.setParameter(i, args[i]);
		}
		
		List<T> list =(List<T>)createQuery.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> list(Class<T> clazz) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query createQuery = session.createQuery(" from "+clazz.getSimpleName() );
		List<T> list =(List<T>)createQuery.list();
		session.getTransaction().commit();
		session.close();
		return list;

	}

}
