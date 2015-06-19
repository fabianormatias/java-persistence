package br.com.waiso.heranca.jointable.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "small_bird")
@DiscriminatorValue("small_bird")
public class SmallBird extends Bird {

	private static final long serialVersionUID = 5801838238473465154L;

	public SmallBird() {
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
