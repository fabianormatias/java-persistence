package br.com.waiso.onetoone.test.insert.painofilho;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.dao.CidadeDAO;
import br.com.waiso.dao.CidadeDAOImpl;
import br.com.waiso.dao.EstadoDAO;
import br.com.waiso.dao.EstadoDAOImpl;
import br.com.waiso.onetoone.entity.painofilho.Cidade;
import br.com.waiso.onetoone.entity.painofilho.Estado;

public class OneToOneTest {
	
	EstadoDAO estadoDAO = new EstadoDAOImpl();
	CidadeDAO cidadeDAO = new CidadeDAOImpl();

	@Test
	public void test() {

		Estado estado = new Estado("MG", "Minas Gerais");
		Cidade cidade = new Cidade("Caetanópolis", estado);
		
		cidadeDAO.insert(cidade);
		
		//TODO Eu pretendo persistir pela classe do pai, pra isso tem que trocar o Cascade para o pai
//		estadoDAO.insert(estado);
		
		Assert.assertTrue("OK", estado.getId() != null);
		Assert.assertTrue("OK", cidade.getId() != null);
		
	}

}
