package br.com.waiso.embedded.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author fabianomatias
 * @since 17/06/2015
 * 
 * A anotação @Embedded (da classe Person) indica que o JPA deve mapear os campos que estão dentro da classe Address 
 * como se os dados pertencessem à classe Person. a anotação @Column dentro da classe ADDRESS para indicar qual o 
 * nome da coluna dentro da tabela person.
 *
 */
@Entity
@Table(name = "person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1445651436222452494L;
	
	public Person() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "idade")
	private Integer idade;
	
	@Embedded
	private Adress endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Adress getEndereco() {
		return endereco;
	}

	public void setEndereco(Adress endereco) {
		this.endereco = endereco;
	}
	
}
