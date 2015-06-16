package br.com.waiso.onetomany.test.insert;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.dao.DepartamentoDAO;
import br.com.waiso.dao.DepartamentoDAOImpl;
import br.com.waiso.dao.FuncionarioDAO;
import br.com.waiso.dao.FuncionarioDAOImpl;
import br.com.waiso.onetomany.entity.Departamento;
import br.com.waiso.onetomany.entity.Funcionario;

public class OneToManyTest {
	
	FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl();
	DepartamentoDAO departamentoDAO = new DepartamentoDAOImpl();

	@Test
	public void test() {

		//Add Funcionários ao BD
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		Funcionario funcionario1 = new Funcionario("fulano");
		Funcionario funcionario2 = new Funcionario("ciclano");
		Funcionario funcionario3 = new Funcionario("beltrano");
		
		funcionarios.add(funcionario1);
		funcionarios.add(funcionario2);
		funcionarios.add(funcionario3);
		
		funcionarioDAO.insertAll(funcionarios);
		
		//Filho
		//Lista de Funcionários
		
		List<Funcionario> funcionariosBd = new ArrayList<Funcionario>();
		
		Funcionario fulano = funcionarioDAO.findById(funcionario1.getId());
		Funcionario ciclano = funcionarioDAO.findById(funcionario2.getId());
		Funcionario beltrano = funcionarioDAO.findById(funcionario3.getId());
				
		funcionariosBd.add(fulano);
		funcionariosBd.add(ciclano);
		funcionariosBd.add(beltrano);
		
		//Pai
		Departamento departamento = new Departamento("TI", funcionariosBd);

		departamentoDAO.insert(departamento);

		Assert.assertTrue("OK", departamento.getId() != null);
	}

}
