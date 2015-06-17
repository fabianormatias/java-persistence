package br.com.waiso.onetoone.chavecompostacomplexa.test.insert;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.onetoone.chavecompostacomplexa.dao.CachorroDAO;
import br.com.waiso.onetoone.chavecompostacomplexa.dao.CachorroDAOImpl;
import br.com.waiso.onetoone.chavecompostacomplexa.dao.CasaCachorroDAO;
import br.com.waiso.onetoone.chavecompostacomplexa.dao.CasaCachorroDAOImpl;
import br.com.waiso.onetoone.chavecompostacomplexa.entity.Cachorro;
import br.com.waiso.onetoone.chavecompostacomplexa.entity.CasaCachorro;

/**
 * 
 * @author fabianomatias
 * @since 16/06/2015
 *
 */
public class OneToOneTest {

	CachorroDAO cachorroDAO = new CachorroDAOImpl();
	CasaCachorroDAO casaCachorroDAO = new CasaCachorroDAOImpl();
	
	@Test
	public void test() {

		//Dominante
		Cachorro cachorro = new Cachorro("Mel");
		cachorroDAO.insert(cachorro);
		
		//Dominada
		CasaCachorro casaCachorro = new CasaCachorro(cachorro, "pinscher");
		casaCachorroDAO.insert(casaCachorro);
		
		//testes
		Assert.assertTrue("OK", cachorro.getId() != null);
		Assert.assertEquals(cachorro.getId(), cachorroDAO.findById(cachorro.getId()));
		
		//Não tem Id
//		Assert.assertTrue("OK", casaCachorro.getId() != null);
//		Assert.assertEquals(casaCachorro.getId(), casaCachorroDAO.findById(casaCachorro.getId()));
		
	}

}
