package br.com.waiso.onetoone.test.insert.filhonopai;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.dao.GenericDAO;
import br.com.waiso.dao.GenericDAOImpl;
import br.com.waiso.onetoone.entity.filhonopai.Email;
import br.com.waiso.onetoone.entity.filhonopai.Usuario;

public class OneToOneTest {
	
	GenericDAO dao = new GenericDAOImpl();
	
	@Test
	public void test() {

		//Filho
		Email email = new Email("fabiano@email.com");
		
		//Pai
		Usuario usuario = new Usuario("Fabiano", "fabiano", email);
		
		dao.persist(usuario);
		
		Assert.assertTrue("OK", usuario.getId() != null);
		Assert.assertTrue("OK", email.getId() != null);
		
//		Assert.assertTrue(usuario.getId(), dao.f);
	}

}
