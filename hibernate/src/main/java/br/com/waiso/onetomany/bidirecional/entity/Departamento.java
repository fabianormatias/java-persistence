package br.com.waiso.onetomany.bidirecional.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author fabianomatias
 * 
 * @since 14/06/2015
 * 
 * @type Dominante
 *
 */
@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {

	@Transient
	private static final long serialVersionUID = 1722331376742268013L;

	public Departamento() {
	}

	public Departamento(String nome) {
		this.nome = nome;
	}

	public Departamento(String nome, Collection<Funcionario> funcionarios) {
		this.nome = nome;
		this.funcionarios = funcionarios;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@OneToMany
	@JoinTable(name = "departamento_funcionario", joinColumns = @JoinColumn(name = "id_departamento"), inverseJoinColumns = @JoinColumn(name = "id_funcionario"))
	private Collection<Funcionario> funcionarios = new ArrayList<Funcionario>();

	// @Transient
	// private Funcionario funcionario;

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

	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Collection<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	// public Funcionario getFuncionario() {
	// return funcionario;
	// }
	//
	// public void setFuncionario(Funcionario funcionario) {
	// this.funcionario = funcionario;
	// }

}
