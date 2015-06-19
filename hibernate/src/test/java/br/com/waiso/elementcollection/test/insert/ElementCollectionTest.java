package br.com.waiso.elementcollection.test.insert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.elementcollection.dao.PessoaDAO;
import br.com.waiso.elementcollection.dao.PessoaDAOImpl;
import br.com.waiso.elementcollection.entity.CarBrands;
import br.com.waiso.elementcollection.entity.Pessoa;

public class ElementCollectionTest {

	PessoaDAO pessoaDAO = new PessoaDAOImpl();
	
	@Test
	public void test() {
		
		Pessoa pessoa = new Pessoa();
		
		Set<String> emails = new HashSet<String>();
		String email1 = new String("fabiano@gmail.com");
		String email2 = new String("fabiano@hotmail.com");
		emails.add(email1);
		emails.add(email2);
		
		List<CarBrands> brands = new ArrayList<CarBrands>();
		brands.add(CarBrands.FIAT);
		brands.add(CarBrands.FORD);
		brands.add(CarBrands.SUZUKI);
		
		pessoa.setNome("fabiano");
		pessoa.setEmails(emails);
		pessoa.setBrands(brands);
		
		//inserir no BD
		pessoaDAO.insert(pessoa);
		
		//testes
		Assert.assertTrue("OK", pessoa.getId() != null);
		Assert.assertEquals(pessoa.getId(), pessoaDAO.findById(pessoa.getId()));
	}

}
