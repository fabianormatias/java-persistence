package br.com.waiso.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.googlecode.genericdao.search.ExampleOptions;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.ISearch;
import com.googlecode.genericdao.search.SearchResult;

public class GenericDAOImpl implements GenericDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private EntityManagerFactory entityManagerFactory;
	
	public GenericDAOImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-teste");
		entityManager = getEntityManager();
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		if(entityManager == null || !(entityManager.isOpen())){
			return entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
	
//	public Class<T> getGenericClass() {
//		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//	}
	
	public int count(ISearch search) {
		return 0;
//		return _count(search);
	}

	
	//TODO
//	public void persist(Object entity) {
//		entityManager = getEntityManager();
//		try {
//			entityManager.getTransaction().begin();
//			entityManager.persist(entity);
//			entityManager.getTransaction().commit();
//		} catch (Exception e) {
//			entityManager.getTransaction().rollback();
//			System.out.println("ERRO: " + e.getMessage());
//		}finally{
//			entityManager.close();
//		}
//	}
	
//	@Override
//	public T findById(Integer primaryKey) {
//		entityManager = getEntityManager();
//		T entity = null;
//		try {
//			entity = (T) entityManager.find(getGenericClass(), primaryKey);
//		    return entity;
//		}catch (Exception e) {
//			System.out.println(">> "+e.getMessage());
//			return null;
//		}finally {
//		    entityManager.close();
//		}
//	}
	
	public <T> T find(Class<T> type, Serializable id) {
		entityManager = getEntityManager();
		try {
			return (T) entityManager.find(type, id);
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("ERRO: " + e.getMessage());
			return null;
		}finally{
			entityManager.close();
		}
	}

	public <T> T[] find(Class<T> type, Serializable... ids) {
		return null;
//		return _find(type, ids);
	}

	public <T> List<T> findAll(Class<T> type) {
		return null;
//		return _all(type);
	}

	public void flush() {
//		_flush();
	}

	public <T> T getReference(Class<T> type, Serializable id) {
		return null;
//		return _getReference(type, id);
	}

	public <T> T[] getReferences(Class<T> type, Serializable... ids) {
		return null;
//		return _getReferences(type, ids);
	}

	public boolean isAttached(Object entity) {
		return false;
//		return _contains(entity);
	}

	public void refresh(Object... entities) {
//		_refresh(entities);
	}

	public boolean remove(Object entity) {
		return false;
//		return _removeEntity(entity);
	}

	public void remove(Object... entities) {
//		_removeEntities(entities);
	}

	public boolean removeById(Class<?> type, Serializable id) {
		return false;
//		return _removeById(type, id);
	}

	public void removeByIds(Class<?> type, Serializable... ids) {
//		_removeByIds(type, ids);
	}

	public <T> T merge(T entity) {
		return null;
//		return _merge(entity);
	}

	public Object[] merge(Object... entities) {
		return null;
//		return _merge(Object.class, entities);
	}
	
	public void persist(Object... entities) {
		for (Object entity : entities) {
			if (entity != null)
				persist(entity);
		}
	}
	
	public void persist(Object entity) {
		entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("ERRO: " + e.getMessage());
		}finally{
			entityManager.close();
		}
	}

	public <T> T save(T entity) {
		return null;
//		return _persistOrMerge(entity);
	}

	public Object[] save(Object... entities) {
		return null;
//		return _persistOrMerge(Object.class, entities);
	}

	public List search(ISearch search) {
		return null;
//		return _search(search);
	}

	public SearchResult searchAndCount(ISearch search) {
		return null;
//		return _searchAndCount(search);
	}

	public Object searchUnique(ISearch search) {
		return null;
//		return _searchUnique(search);
	}

	public Filter getFilterFromExample(Object example) {
		return null;
//		return _getFilterFromExample(example);
	}

	public Filter getFilterFromExample(Object example, ExampleOptions options) {
		return null;
//		return _getFilterFromExample(example, options);
	}
}