package br.com.waiso.onetoone.bidirecional.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author fabianomatias
 * 
 * @since 09/06/2015
 * 
 * @type Dominante
 *
 */
@Entity
@Table(name = "proprietario")
public class Proprietario implements Serializable {

	@Transient
	private static final long serialVersionUID = -3689382195454890010L;

	public Proprietario() {
	}

	/**
	 * IDENTITY
	 * 
	 * Quem controla qual será o próximo ID é o próprio banco de dados, sem
	 * atuação do JPA. É necessário que primeiro a entidade seja persistida, e
	 * após a realização o commit, uma consulta ao banco será realizada para
	 * descobrir qual será o ID da entidade em questão. Pode inclusive haver uma
	 * pequena perca de desempenho, mas nada alarmante.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	/*
	 * Com esse atributo e anotação o relacionamento ficará bidirecional Quando
	 * expressamos um relacionamento colocando um atributo em uma das entidades,
	 * pode-mos acessar a outra entidade a partir da primeira.
	 * 
	 * Foi utilizado o atributo “mappedBy” na anotação @OneToOne. Esse atributo indica que a 
	 * entidade Person é a dona do relacionamento; a chave estrangeira deve ficar na tabela Person e 
	 * não na tabela Cellular.
	 */
	@OneToOne(mappedBy = "proprietario")
	private Celular celular;

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

	public Celular getCelular() {
		return celular;
	}

	public void setCelular(Celular celular) {
		this.celular = celular;
	}

}
