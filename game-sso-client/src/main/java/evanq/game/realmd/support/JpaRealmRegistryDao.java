package evanq.game.realmd.support;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import evanq.game.realmd.RealmRegistryDao;
import evanq.game.realmd.entity.Realmdlist;

@Repository
public class JpaRealmRegistryDao implements RealmRegistryDao {

	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public Realmdlist save(Realmdlist entity) {
		
		this.entityManager.persist(entity);
		return entity;
	}
	@Transactional
	@Override
	public Realmdlist delete(Realmdlist entity) {
		
		
		return null;
	}

	@Override
	public List<Realmdlist> getAllRealm() {
		return null;
	}

}
