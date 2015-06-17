package br.com.waiso.embedded.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author fabianomatias
 * @since 17/06/2015
 * 
 * A anotação @Embeddable (class Address) indica que essa classe será utilizada dentro de uma entidade, 
 * note que Address não é uma entidade. É apenas uma classe java que irá refletir dados do banco de dados de um 
 * modo organizado.

 * Foi utilizada a anotação @Column dentro da classe ADDRESS para indicar qual o nome da coluna dentro da tabela person.
 *
 */
@Embeddable
public class Adress implements Serializable {

	private static final long serialVersionUID = 4416976350653482727L;

	public Adress() {
	}

	@Column(name = "endereco_casa")
	private String enderecoCasa;

	@Column(name = "cor_casa")
	private String corCasa;

	@Column(name = "numero_casa")
	private int numeroCasa;

	public String getEnderecoCasa() {
		return enderecoCasa;
	}

	public void setEnderecoCasa(String enderecoCasa) {
		this.enderecoCasa = enderecoCasa;
	}

	public String getCorCasa() {
		return corCasa;
	}

	public void setCorCasa(String corCasa) {
		this.corCasa = corCasa;
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

}
