package br.com.waiso.onetoone.chavecompostacomplexa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "casa_cachorro")
public class CasaCachorro implements Serializable {

	private static final long serialVersionUID = -6887320119465047156L;

	public CasaCachorro() {
	}

	public CasaCachorro(Cachorro cachorro, String raca) {
		this.cachorro = cachorro;
		this.raca = raca;
	}

	@Id
	@OneToOne
	@JoinColumn(name = "id_cachorro")
	private Cachorro cachorro;

	@Column(name = "raca")
	private String raca;

	public Cachorro getCachorro() {
		return cachorro;
	}

	public void setCachorro(Cachorro cachorro) {
		this.cachorro = cachorro;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

}
