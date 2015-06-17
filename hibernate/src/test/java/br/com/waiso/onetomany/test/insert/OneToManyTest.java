package br.com.waiso.onetomany.test.insert;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.onetomany.dao.DepartamentoDAO;
import br.com.waiso.onetomany.dao.DepartamentoDAOImpl;
import br.com.waiso.onetomany.dao.FuncionarioDAO;
import br.com.waiso.onetomany.dao.FuncionarioDAOImpl;
import br.com.waiso.onetomany.entity.Departamento;
import br.com.waiso.onetomany.entity.Funcionario;

/**
 * 
 * @author fabianomatias
 * @since 16/06/2015
 *
 */
public class OneToManyTest {
	
	FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl();
	DepartamentoDAO departamentoDAO = new DepartamentoDAOImpl();

	@Test
	public void test() {

		//Add Funcionários ao BD
		//Dominante
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		Funcionario funcionario1 = new Funcionario("fulano");
		Funcionario funcionario2 = new Funcionario("ciclano");
		Funcionario funcionario3 = new Funcionario("beltrano");
		
		funcionarios.add(funcionario1);
		funcionarios.add(funcionario2);
		funcionarios.add(funcionario3);
		
		funcionarioDAO.insertAll(funcionarios);
		
		//Add Departamentos ao BD
		//Dominada
//		List<Departamento> departamentos = new ArrayList<Departamento>();
//				
//		Departamento departamento1 = new Departamento("TI");
//		Departamento departamento2 = new Departamento("RH");
//		Departamento departamento3 = new Departamento("Compras");
//				
//		departamentos.add(departamento1);
//		departamentos.add(departamento2);
//		departamentos.add(departamento3);
//				
//		departamentoDAO.insertAll(departamentos);
		
		//Dominante
		//Departamento
		
//		Departamento departamentoTI = departamentoDAO.findById(departamento1.getId());
		
		//Dominada
		//Lista de Funcionários
		
		List<Funcionario> funcionariosBd = new ArrayList<Funcionario>();
		
		Funcionario fulano = funcionarioDAO.findById(funcionario1.getId());
		Funcionario ciclano = funcionarioDAO.findById(funcionario2.getId());
		Funcionario beltrano = funcionarioDAO.findById(funcionario3.getId());
				
		funcionariosBd.add(fulano);
		funcionariosBd.add(ciclano);
		funcionariosBd.add(beltrano);
		
		Departamento departamento = new Departamento("TI", funcionariosBd);

		departamentoDAO.insert(departamento);

		Assert.assertTrue("OK", departamento.getId() != null);
	}

}
