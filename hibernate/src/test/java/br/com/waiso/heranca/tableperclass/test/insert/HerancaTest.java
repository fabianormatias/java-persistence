package br.com.waiso.heranca.tableperclass.test.insert;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.heranca.tableperclass.dao.HugeMouseDAO;
import br.com.waiso.heranca.tableperclass.dao.HugeMouseDAOImpl;
import br.com.waiso.heranca.tableperclass.dao.SmallMouseDAO;
import br.com.waiso.heranca.tableperclass.dao.SmallMouseDAOImpl;
import br.com.waiso.heranca.tableperclass.entity.HugeMouse;
import br.com.waiso.heranca.tableperclass.entity.SmallMouse;

/**
 * 
 * @author fabianomatias
 * @since 17/06/2015
 *
 */
public class HerancaTest {

	HugeMouseDAO hugeMouseDAO = new HugeMouseDAOImpl();
	SmallMouseDAO smallMouseDAO = new SmallMouseDAOImpl();
	
	@Test
	public void test() {
		
		//Filho
		HugeMouse hugeMouse = new HugeMouse();
		hugeMouse.setNome("Jerry");
		hugeMouse.setRaca("fedido");
		
		SmallMouse smallMouse = new SmallMouse();
		smallMouse.setNome("Rodela");
		smallMouse.setCor("Amarelo");
		
		//Inserir no BD
		hugeMouseDAO.insert(hugeMouse);
		smallMouseDAO.insert(smallMouse);
		
		//Teste
		Assert.assertTrue("OK", hugeMouse.getId() != null);
		Assert.assertTrue("OK", smallMouse.getId() != null);
		Assert.assertEquals(hugeMouse.getId(), hugeMouseDAO.findById(hugeMouse.getId()));
		Assert.assertEquals(smallMouse.getId(), smallMouseDAO.findById(smallMouse.getId()));
	}

}
