package br.com.waiso.dao;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public class TestGenericDAOImpl<T extends Serializable> implements GenericDAO<T> {

	@PersistenceContext
	private EntityManager entityManager;
	private EntityManagerFactory emf;
	private Type type;

	public TestGenericDAOImpl() {
		emf = Persistence.createEntityManagerFactory("hibernate-teste");
		entityManager = getEntityManager();
	}
	
	public TestGenericDAOImpl(Class<T> t) {
		this.type = t;
		emf = Persistence.createEntityManagerFactory("hibernate-teste");
		entityManager = getEntityManager();
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		if (entityManager == null || !(entityManager.isOpen())) {
			return emf.createEntityManager();
		}
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> getGenericClass() {
		return (Class<T>) type;
	}

	public void insert(T entity) {
		entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("ERRO: " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}
	
	public void insertAll(List<T> entities) {
		for (T t : entities) {
			insert(t);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll() {
		entityManager = getEntityManager();
		CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder()
				.createQuery(getGenericClass());
		criteriaQuery.from(getGenericClass());
		List<T> lista = entityManager.createQuery(criteriaQuery)
				.getResultList();
		entityManager.close();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<T> findEspecific(Long id) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		String jpql = "select a from Avaliacao a";

		Query query = entityManager.createQuery(jpql);
		List<T> lista = query.getResultList();
		System.out.println("BUSCANDO :" + id);
		entityManager.getTransaction().commit();
		if (lista.size() > 0) {
			entityManager.close();
			return lista;
		} else {
			entityManager.close();
			return null;
		}
	}

	public void delete(Long primaryKey) {
		entityManager = getEntityManager();
		try {
			T entity = (T) entityManager.find(getGenericClass(), primaryKey);
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">> " + e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	public T findById(Long primaryKey) {
		entityManager = getEntityManager();
		T entity = null;
		try {
			entity = (T) entityManager.find(getGenericClass(), primaryKey);
			return entity;
		} catch (Exception e) {
			System.out.println(">> " + e.getMessage());
			return null;
		} finally {
			entityManager.close();
		}
	}

	public void update(T entity) {
		entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Boolean verificaUsuario(String valor) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		String jpql = "select a from Usuario a where a.usuario= :valorx";

		Query query = entityManager.createQuery(jpql);
		query.setParameter("valorx", valor);

		entityManager.getTransaction().commit();
		List<T> lista = query.getResultList();

		if (lista.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}