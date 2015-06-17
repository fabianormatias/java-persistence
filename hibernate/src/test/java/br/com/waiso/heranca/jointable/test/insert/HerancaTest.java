package br.com.waiso.heranca.jointable.test.insert;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.heranca.jointable.dao.HugeBirdDAO;
import br.com.waiso.heranca.jointable.dao.HugeBirdDAOImpl;
import br.com.waiso.heranca.jointable.dao.SmallBirdDAO;
import br.com.waiso.heranca.jointable.dao.SmallBirdDAOImpl;
import br.com.waiso.heranca.jointable.entity.HugeBird;
import br.com.waiso.heranca.jointable.entity.SmallBird;

/**
 * 
 * @author fabianomatias
 * @since 17/06/2015
 *
 */
public class HerancaTest {

	HugeBirdDAO hugeBirdDAO = new HugeBirdDAOImpl();
	SmallBirdDAO smallBirdDAO = new SmallBirdDAOImpl();
	
	@Test
	public void test() {
		
		//Filho
		HugeBird hugeBird = new HugeBird();
		hugeBird.setNome("Pescoço");
		hugeBird.setRaca("Pássaro-preto");
		
		SmallBird smallBird = new SmallBird();
		smallBird.setNome("Rodela");
		smallBird.setCor("Amarelo");
		
		//Inserir no BD
		hugeBirdDAO.insert(hugeBird);
		smallBirdDAO.insert(smallBird);
		
		//Teste
		Assert.assertTrue("OK", hugeBird.getId() != null);
		Assert.assertTrue("OK", smallBird.getId() != null);
		Assert.assertEquals(hugeBird.getId(), hugeBirdDAO.findById(hugeBird.getId()));
		Assert.assertEquals(smallBird.getId(), smallBirdDAO.findById(smallBird.getId()));
	}

}
