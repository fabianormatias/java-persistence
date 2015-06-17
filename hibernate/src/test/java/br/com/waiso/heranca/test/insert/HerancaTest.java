package br.com.waiso.heranca.test.insert;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.heranca.dao.DogDAO;
import br.com.waiso.heranca.dao.DogDAOImpl;
import br.com.waiso.heranca.entity.Dog;

public class HerancaTest {

	DogDAO dogDAO = new DogDAOImpl();

	@Test
	public void test() {

		Dog dog = new Dog("pinscher");
		dog.setNome("Mel");

		dogDAO.insert(dog);

		Assert.assertTrue("OK", dog.getId() != null);
		Assert.assertEquals(dog.getId(), dogDAO.findById(dog.getId()));

	}

}
