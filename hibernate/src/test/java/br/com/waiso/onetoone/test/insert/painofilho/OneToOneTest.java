package br.com.waiso.onetoone.test.insert.painofilho;

import org.junit.Test;

import br.com.waiso.onetoone.entity.painofilho.Cidade;
import br.com.waiso.onetoone.entity.painofilho.Estado;

public class OneToOneTest {

	@Test
	public void test() {

		Estado estado = new Estado("MG", "Minas Gerais");
		Cidade cidade = new Cidade("Caetanópolis", estado);
		
		
		
	}

}
