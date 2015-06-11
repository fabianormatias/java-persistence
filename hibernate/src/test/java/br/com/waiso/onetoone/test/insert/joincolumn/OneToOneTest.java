package br.com.waiso.onetoone.test.insert.joincolumn;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.dao.GenericDAO;
import br.com.waiso.dao.GenericDAOImpl;
import br.com.waiso.onetoone.entity.filhonopai.Usuario;
import br.com.waiso.onetoone.entity.joincolumn.Filho;
import br.com.waiso.onetoone.entity.joincolumn.Pai;

public class OneToOneTest {
	
	GenericDAO dao = new GenericDAOImpl();
	
	@Test
	public void test() {

		Pai pai = new Pai("Silvio", 65);
		
		Filho filho = new Filho("fabiano", 30, pai);
		
		dao.persist(pai);
		dao.persist(filho);
		
		Assert.assertTrue("OK", pai.getId() != null);
		Assert.assertTrue("OK", filho.getId() != null);
		
		Assert.assertEquals(pai.getId(), dao.find(Usuario.class, pai.getId()));
		
	}

}
