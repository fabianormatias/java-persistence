package br.com.waiso.onetoone.test.insert.joincolumn;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.dao.FilhoDAO;
import br.com.waiso.dao.FilhoDAOImpl;
import br.com.waiso.dao.PaiDAO;
import br.com.waiso.dao.PaiDAOImpl;
import br.com.waiso.onetoone.entity.joincolumn.Filho;
import br.com.waiso.onetoone.entity.joincolumn.Pai;

public class OneToOneTest {
	
	PaiDAO paiDAO = new PaiDAOImpl();
	FilhoDAO filhoDAO = new FilhoDAOImpl();
	
	@Test
	public void test() {

		//Pai
		Pai pai = new Pai("Silvio", 65);
		
		//Filho
		Filho filho = new Filho("fabiano", 30, pai);
		
		paiDAO.insert(pai);
		filhoDAO.insert(filho);
		
		Assert.assertTrue("OK", pai.getId() != null);
		Assert.assertTrue("OK", filho.getId() != null);
		
	}

}
