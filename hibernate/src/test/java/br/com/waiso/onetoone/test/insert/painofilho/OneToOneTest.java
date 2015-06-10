package br.com.waiso.onetoone.test.insert.painofilho;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.dao.GenericDAO;
import br.com.waiso.dao.GenericDAOImpl;
import br.com.waiso.onetoone.entity.painofilho.Cidade;
import br.com.waiso.onetoone.entity.painofilho.Estado;

public class OneToOneTest {
	
	GenericDAO dao = new GenericDAOImpl();

	@Test
	public void test() {

		Estado estado = new Estado("MG", "Minas Gerais");
		Cidade cidade = new Cidade("Caetanópolis", estado);
		
		dao.persist(estado);
		
		Assert.assertTrue("OK", estado.getId() != null);
		Assert.assertTrue("OK", cidade.getId() != null);
		
	}

}
