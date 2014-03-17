package evanq.game.cardgame.infrastructure.persistence.hibernate.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import evanq.game.cardgame.domain.model.role.RoleInfo;
import evanq.game.cardgame.domain.model.role.RoleRepository;

public class RoleRepositoryHibernateJPA implements RoleRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(RoleInfo roleInfo) {		
		entityManager.persist(roleInfo);
	}

}
