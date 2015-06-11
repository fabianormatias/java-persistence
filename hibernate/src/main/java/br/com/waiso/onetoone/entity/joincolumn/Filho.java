package br.com.waiso.onetoone.entity.joincolumn;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "filho")
public class Filho implements Serializable {

	private static final long serialVersionUID = 55799129927112599L;

	public Filho() {
	}

	public Filho(String nome, Integer idade, Pai pai) {
		this.nome = nome;
		this.idade = idade;
		this.pai = pai;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "idade")
	private Integer idade;

	@OneToOne
	@JoinColumn(name = "id_pai")
	private Pai pai;

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

	public Pai getPai() {
		return pai;
	}

	public void setPai(Pai pai) {
		this.pai = pai;
	}

}
