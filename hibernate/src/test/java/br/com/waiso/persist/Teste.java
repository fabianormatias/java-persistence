package br.com.waiso.persist;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.dao.GenericDAO;
import br.com.waiso.dao.GenericDAOImpl;
import br.com.waiso.onetoone.recursivo.Cachorro;

public class Teste {
	
	GenericDAO<Cachorro> dao = new GenericDAOImpl<Cachorro>(Cachorro.class);

	@Test
	public void test() {
		dao.findById(1L);
	}
	
	@Test
	public void updateCachorro() {

		Cachorro cachorro = new Cachorro();
		cachorro.setNome("dudu");
		
		GenericDAO<Cachorro> dao = new GenericDAOImpl<Cachorro>(Cachorro.class);
		dao.insert(cachorro);
		
		Cachorro cachorroBanco = dao.findById(1L);
		Assert.assertNotNull( cachorroBanco );
		
		cachorroBanco.setNome("fabiano");
		dao.update(cachorroBanco);
		
		Assert.assertTrue( dao.findById(1L).getNome().equalsIgnoreCase("fabiano") );
		
		
		
	
	}

}
