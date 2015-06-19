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
@Table(name = "huge_bird")
@DiscriminatorValue("huge_bird")
public class HugeBird extends Bird {

	private static final long serialVersionUID = -3112343997761362603L;

	public HugeBird() {
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
