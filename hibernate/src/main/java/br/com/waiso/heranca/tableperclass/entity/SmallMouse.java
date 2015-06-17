package br.com.waiso.heranca.tableperclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 
 * @author fabianomatias
 * @since 17/06/2015
 * @type Filho
 * 
 * @DiscriminatorValue => Define qual o valor a ser salvo na coluna descrita na
 *                     anotação
 *
 */
//@Entity
public class SmallMouse extends Mouse {

	private static final long serialVersionUID = 5801838238473465154L;

	public SmallMouse() {
	}

	@Column(name = "cor")
	private String cor;

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
