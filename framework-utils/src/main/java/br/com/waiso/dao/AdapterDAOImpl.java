package br.com.waiso.dao;

import java.io.Serializable;

public class AdapterDAOImpl extends GenericDAOImpl implements AdapterDAO {

//	private GenericDAOImpl dao;
//
//	public void setDao(GenericDAOImpl dao) {
//		this.dao = dao;
//	}
	
	public <T> T find(String className, Serializable id) {
		try {
			Class<?> type = Class.forName(className);
			return (T) super.find(type, id);
		} catch (ClassNotFoundException e) {
			System.out.println("ERRO: " + e.getMessage());
			return null;
		}
	}

	public void persist(Object entity) {
		super.persist(entity);
	}

	public void persist(Object... entities) {
		super.persist(entities);
	}

}
