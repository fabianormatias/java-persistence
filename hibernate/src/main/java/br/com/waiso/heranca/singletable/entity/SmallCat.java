package br.com.waiso.heranca.singletable.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
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
@Entity
@DiscriminatorValue("small_cat")
public class SmallCat extends Cat {

	private static final long serialVersionUID = 5801838238473465154L;

	public SmallCat() {
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
