package br.com.waiso.embedded.test.insert;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.embedded.dao.AdressDAO;
import br.com.waiso.embedded.dao.AdressDAOImpl;
import br.com.waiso.embedded.dao.PersonDAO;
import br.com.waiso.embedded.dao.PersonDAOImpl;
import br.com.waiso.embedded.entity.Adress;
import br.com.waiso.embedded.entity.Person;

/**
 * 
 * @author fabianomatias
 * @since 17/06/2015
 *
 */
public class EmbeddedTest {

	AdressDAO adressDAO = new AdressDAOImpl();
	PersonDAO personDAO = new PersonDAOImpl();
	
	@Test
	public void test() {
		
		Adress endereco = new Adress();
		endereco.setEnderecoCasa("Lapa");
		endereco.setNumeroCasa(480);
		endereco.setCorCasa("branca");
		
		Person pessoa = new Person();
		pessoa.setIdade(30);
		pessoa.setNome("Fabiano");
		pessoa.setEndereco(endereco);
		
		//inserir no BD
		personDAO.insert(pessoa);
		
		//testes
		Assert.assertTrue("OK", pessoa.getId() != null);
		Assert.assertEquals(pessoa.getId(), personDAO.findById(pessoa.getId()));
	}

}
