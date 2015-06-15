package br.com.waiso.onetoone.test.insert.filhonopai;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.dao.EmailDAO;
import br.com.waiso.dao.EmailDAOImpl;
import br.com.waiso.dao.UsuarioDAO;
import br.com.waiso.dao.UsuarioDAOImpl;
import br.com.waiso.onetoone.entity.filhonopai.Email;
import br.com.waiso.onetoone.entity.filhonopai.Usuario;

public class OneToOneTest {
	
	EmailDAO emailDAO = new EmailDAOImpl();
	UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
	
	@Test
	public void test() {

		//Inserir lista de emails no BD
		List<Email> emails = new ArrayList<Email>();
		Email email1 = new Email("fabiano@email.com");
		Email email2 = new Email("willians@email.com");
		
		emails.add(email1);
		emails.add(email2);
		
		emailDAO.insertAll(emails);

		//Filho
		Email email = emailDAO.findById(email1.getId());
		
		//Pai
		Usuario usuario = new Usuario("Fabiano", "fabiano", email);
		
		usuarioDAO.insert(usuario);
		
		Assert.assertTrue("OK", usuario.getId() != null);
		Assert.assertTrue("OK", email.getId() != null);
		
		Assert.assertEquals(usuario.getId(), usuarioDAO.findById(usuario.getId()));
		
	}

}
