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
		estado.setCidade(cidade);
		
		dao.persist(cidade);
		
		//TODO Eu pretendo persistir pela classe do pai, pra isso tem que trocar o Cascade para o pai
//		dao.persist(estado);
		
		Assert.assertTrue("OK", estado.getId() != null);
		Assert.assertTrue("OK", cidade.getId() != null);
		
//		Assert.assertEquals(estado.getId(), dao.find(Estado.class, estado.getId()));
		
	}

}
