package br.com.waiso.dao;

import java.io.Serializable;

public interface AdapterDAO {
	
	public <T> T find(String className, Serializable id);
	
//	public <T> T[] find(Class<T> type, Serializable... ids);
//
//	public <T> List<T> findAll(Class<T> type);

//	public <T> T getReference(String className, Serializable id);
//
//	public <T> T[] getReferences(Class<T> type, Serializable... ids);
//
	public void persist(Object entity);
	
	public void persist(Object... entities);
//
//	public <T> T merge(T entity);
//
//	public Object[] merge(Object... entities);
//	
//	public <T> T save(T entity);
//
//	public Object[] save(Object... entities);
//	
//	public boolean remove(Object entity);
//
//	public void remove(Object... entities);
//
//	public boolean removeById(Class<?> type, Serializable id);
//
//	public void removeByIds(Class<?> type, Serializable... ids);
//
//	public List search(ISearch search);
//
//	public Object searchUnique(ISearch search);
//
//	public int count(ISearch search);
//
//	public SearchResult searchAndCount(ISearch search);
//
//	public boolean isAttached(Object entity);
//
//	public void refresh(Object... entities);
//
//	public void flush();
//
//	public Filter getFilterFromExample(Object example);
//
//	public Filter getFilterFromExample(Object example, ExampleOptions options);

}
