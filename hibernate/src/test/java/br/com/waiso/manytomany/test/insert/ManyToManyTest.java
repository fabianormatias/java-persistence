package br.com.waiso.manytomany.test.insert;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.manytomany.dao.DoggsDAO;
import br.com.waiso.manytomany.dao.DoggsDAOImpl;
import br.com.waiso.manytomany.dao.PerssonDAO;
import br.com.waiso.manytomany.dao.PerssonDAOImpl;
import br.com.waiso.manytomany.entity.Doggs;
import br.com.waiso.manytomany.entity.Persson;

public class ManyToManyTest {
	
	PerssonDAO personDAO = new PerssonDAOImpl();
	DoggsDAO dogsDAO = new DoggsDAOImpl();

	@Test
	public void test() {
		List<Doggs> cachorros = new ArrayList<Doggs>();
		
		Doggs cachorro1 = new Doggs();
		cachorro1.setNome("Rex");
		Doggs cachorro2 = new Doggs();
		cachorro2.setNome("Mel");
		
		cachorros.add(cachorro1);
		cachorros.add(cachorro2);

		Persson pessoa = new Persson();
		pessoa.setNome("Fabiano");
		pessoa.setDogs(cachorros);
		
		personDAO.insert(pessoa);
		
		//Teste
		Assert.assertTrue("OK", pessoa.getId() != null);
		
	}

}
