package br.com.waiso.onetoone.entity.painofilho;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author fabianomatias
 * 
 * @since 10/06/2015
 * 
 * @type Pai
 *
 */
@Entity
@Table(name = "estado")
public class Estado implements Serializable {

	private static final long serialVersionUID = 1121345893156268202L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "sigla")
	private String sigla;

	@Column(name = "nome")
	private String nome;

	@OneToOne(mappedBy="estado")
	private Cidade cidade;

	public Estado() {
	}

	public Estado(String sigla, String nome) {
		this.sigla = sigla;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
