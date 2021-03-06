package br.com.waiso.onetoone.unidirecional.test.insert;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.onetoone.unidirecional.dao.EmailDAO;
import br.com.waiso.onetoone.unidirecional.dao.EmailDAOImpl;
import br.com.waiso.onetoone.unidirecional.dao.UsuarioDAO;
import br.com.waiso.onetoone.unidirecional.dao.UsuarioDAOImpl;
import br.com.waiso.onetoone.unidirecional.entity.Email;
import br.com.waiso.onetoone.unidirecional.entity.Usuario;

/**
 * 
 * @author fabianomatias
 * @since 16/06/2015
 *
 */
public class OneToOneTest {
	
	EmailDAO emailDAO = new EmailDAOImpl();
	UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
	
	@Test
	public void test() {
		
		//Cardinalidade mínima --> Condicional
		//Cardinalidade máxima --> Incondicional
		
		//cenario
		//Dominante
		//1,1
		Email email = new Email("fabiano@email.com");
		emailDAO.insert(email);

		//Dominada
		//1,1
		Usuario usuario = new Usuario("Fabiano", "fabiano", email);
		usuarioDAO.insert(usuario);
		
		//teste
		Assert.assertTrue("OK", usuario.getId() != null);
		Assert.assertTrue("OK", email.getId() != null);
		Assert.assertEquals(usuario.getId(), usuarioDAO.findById(usuario.getId()));
		Assert.assertEquals(email.getId(), emailDAO.findById(email.getId()));
		
		//Resultado do script SQL
		//insert into email (email) values('professorwillians@gmail.com2');
		//insert into usuario (senha, usuario, id_email) values('senha', 'usuario',  (select id from email where email='professorwillians@gmail.com2'));
	}

}
