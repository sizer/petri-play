package models.service.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import models.entity.AbstractTrailEntity;
import play.db.jpa.JPA;

/**
 *
 * @author mrdShinse
 */
public abstract class BaseDao implements Serializable {

	private static final long serialVersionUID = 1L;

	public <T extends AbstractTrailEntity> void insert(T entity) {
		System.out.println("-------------------dao.insert()start-------------------");
		System.out.println("entity:"+entity);
		JPA.em().persist(entity);
		System.out.println("-------------------dao.insert()persist-------------------");
		JPA.em().flush();
	}

	public <T extends AbstractTrailEntity> void update(T entity) {
		try {
			JPA.em().merge(entity);
			JPA.em().flush();

		} catch (OptimisticLockException e) {
			throw new RuntimeException(e);
		}
	}

	public <T extends AbstractTrailEntity> void delete(T entity) {
		try {
			JPA.em().remove(JPA.em().merge(entity));
			JPA.em().flush();
		} catch (OptimisticLockException e) {
			throw new RuntimeException(e);
		}
	}

	public <T extends AbstractTrailEntity> T findByPK(Class<T> entityClass, Object primaryKey) {
		T entity = JPA.em().find(entityClass, primaryKey);
		return entity;
	}

	public <T extends AbstractTrailEntity> List<T> findAll(Class<T> entityClass) {
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> t = cq.from(entityClass);

		cq.select(t);
		cq.orderBy(cb.asc(t.get("id")));

		TypedQuery<T> typeQuery = createQuery(cq);
		List<T> entityList = typeQuery.getResultList();
		return entityList;
	}

	protected <T extends AbstractTrailEntity> TypedQuery<T> getQueryByName(Class<T> entityClass, String QueryName) {
		TypedQuery<T> q = JPA.em().createNamedQuery(QueryName, entityClass);
		return q;
	}

	protected CriteriaBuilder getCriteriaBuilder() {
		CriteriaBuilder b = JPA.em().getCriteriaBuilder();
		return b;
	}

	protected <T extends AbstractTrailEntity> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
		return JPA.em().createQuery(criteriaQuery);
	}

	protected <T extends AbstractTrailEntity> T executeTypedQuery(TypedQuery<T> typedQuery) {
		T entity = null;
		try {
			entity = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			return entity;
		}
		return entity;
	}

	protected <T extends AbstractTrailEntity> List<T> executeTypedQueryList(TypedQuery<T> typedQuery) {
		List<T> entityList = typedQuery.getResultList();
		return entityList;
	}

	protected <T> TypedQuery<T> createOtherTypedQuery(CriteriaQuery<T> criteriaQuery) {
		return JPA.em().createQuery(criteriaQuery);
	}

	protected <T> T executeOtherTypedQuery(TypedQuery<T> typedQuery) {
		T entity = null;
		try {
			entity = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			return entity;
		}
		return entity;
	}

	protected <T> List<T> executeOtherTypedQueryList(TypedQuery<T> typedQuery) {
		List<T> entityList = typedQuery.getResultList();
		return entityList;
	}

}
