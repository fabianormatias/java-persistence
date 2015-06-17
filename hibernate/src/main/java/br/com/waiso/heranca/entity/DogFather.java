package br.com.waiso.heranca.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * 
 * @author fabianomatias
 * @since 16/06/2015
 * @type Pai
 * 
 * DogFather não é uma entidade.
 *
 */
/*
 * Com essa anotação toda a classe que herdar da classe DogFather herdará todos seus atributos. 
 * Esses atributos serão refletidos no banco de dados.
 * 
 * A MappedSuperclass pode ser tanto abstrata quanto concreta.
 * 
 * Uma MappedSuperclass não pode ser anotada com @Entity\@Table. Ela não é uma classe que será persistida. 
 * Seus atributos/métodos serão refletidos nas classes filhas.
 * É boa prática sempre defini-la como abstrata. Ela é uma classe que não será consultada diretamente por JPQL ou Queries.
 * 
 */
@MappedSuperclass
public abstract class DogFather implements Serializable {

	private static final long serialVersionUID = 1845158592117829047L;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
