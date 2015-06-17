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
@DiscriminatorValue("huge_dog")
public class HugeCat extends Cat {

	private static final long serialVersionUID = -3112343997761362603L;

	public HugeCat() {
	}

	public HugeCat(String raca) {
		this.raca = raca;
	}

	@Column(name = "raca")
	private String raca;

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

}
