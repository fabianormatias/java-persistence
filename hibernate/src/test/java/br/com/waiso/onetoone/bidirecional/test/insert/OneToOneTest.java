package br.com.waiso.onetoone.bidirecional.test.insert;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.onetoone.bidirecional.dao.CelularDAO;
import br.com.waiso.onetoone.bidirecional.dao.CelularDAOImpl;
import br.com.waiso.onetoone.bidirecional.dao.ProprietarioDAO;
import br.com.waiso.onetoone.bidirecional.dao.ProprietarioDAOImpl;
import br.com.waiso.onetoone.bidirecional.entity.Celular;
import br.com.waiso.onetoone.bidirecional.entity.Proprietario;

/**
 * 
 * @author fabianomatias
 * @since 19/06/2015
 *
 */
public class OneToOneTest {
	
	ProprietarioDAO proprietarioDAO = new ProprietarioDAOImpl();
	CelularDAO celularDAO = new CelularDAOImpl();
	
	@Test
	public void test() {
		
		//Cardinalidade mínima --> Condicional
		//Cardinalidade máxima --> Incondicional
		
		//cenario
		//Dominante
		//1,1
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("fabiano");
		proprietarioDAO.insert(proprietario);

		//Dominada
		//1,1
		Celular celular = new Celular();
		celular.setNome("Iphone");
		celular.setProprietario(proprietario);
		celularDAO.insert(celular);
		
		//teste
		Assert.assertTrue("OK", proprietario.getId() != null);
		Assert.assertTrue("OK", celular.getId() != null);
		Assert.assertEquals(proprietario.getId(), proprietarioDAO.findById(proprietario.getId()));
		Assert.assertEquals(celular.getId(), celularDAO.findById(celular.getId()));
		
	}

}
