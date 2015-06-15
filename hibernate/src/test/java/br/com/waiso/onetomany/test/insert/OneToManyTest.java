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
		
		Funcionario fulano = new Funcionario("fulano");
		Funcionario ciclano = new Funcionario("ciclano");
		Funcionario beltrano = new Funcionario("beltrano");
		
		//Filho
		//Lista de Funcionários
		
		funcionarios.add(fulano);
		funcionarios.add(ciclano);
		funcionarios.add(beltrano);
		
		funcionarioDAO.insertAll(funcionarios);
		
		//Pai
		Departamento departamento = new Departamento("TI", funcionarios);

		departamentoDAO.insert(departamento);

		Assert.assertTrue("OK", departamento.getId() != null);
	}

}
