package br.com.waiso.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T extends Serializable> {

	public void insert(T entity);
	
	public void insertAll(List<T> entities);
	
	public void update(T entity);
	
	public void delete(Integer primaryKey) throws Exception;
	
	public List<T> findAll();
	
	public List<T> findEspecific(Integer id);
	
	public T findById(Integer primaryKey);
	
}
