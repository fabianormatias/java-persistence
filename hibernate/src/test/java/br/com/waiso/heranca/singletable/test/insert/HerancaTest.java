package br.com.waiso.heranca.singletable.test.insert;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.heranca.singletable.dao.HugeCatDAO;
import br.com.waiso.heranca.singletable.dao.HugeCatDAOImpl;
import br.com.waiso.heranca.singletable.dao.SmallCatDAO;
import br.com.waiso.heranca.singletable.dao.SmallCatDAOImpl;
import br.com.waiso.heranca.singletable.entity.HugeCat;
import br.com.waiso.heranca.singletable.entity.SmallCat;

/**
 * 
 * @author fabianomatias
 * @since 17/06/2015
 *
 */
public class HerancaTest {

	HugeCatDAO hugeCatDAO = new HugeCatDAOImpl();
	SmallCatDAO smallCatDAO = new SmallCatDAOImpl();
	
	@Test
	public void test() {
		
		//Filho
		HugeCat hugeCat = new HugeCat("pinscher");
		SmallCat smallCat = new SmallCat("au-au");
		
		//Inserir no BD
		hugeCatDAO.insert(hugeCat);
		smallCatDAO.insert(smallCat);
		
		//Teste
		Assert.assertTrue("OK", hugeCat.getId() != null);
		Assert.assertTrue("OK", smallCat.getId() != null);
		Assert.assertEquals(hugeCat.getId(), hugeCatDAO.findById(hugeCat.getId()));
		Assert.assertEquals(smallCat.getId(), smallCatDAO.findById(smallCat.getId()));
	}

}
