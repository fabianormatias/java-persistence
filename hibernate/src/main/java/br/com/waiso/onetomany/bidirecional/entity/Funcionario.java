package br.com.waiso.onetomany.bidirecional.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author fabianomatias
 * 
 * @since 14/06/2015
 * 
 * @type Dominada
 *
 */
@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

	@Transient
	private static final long serialVersionUID = -6787758847332432007L;

	public Funcionario() {
	}

	public Funcionario(String nome) {
		this.nome = nome;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

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

}
