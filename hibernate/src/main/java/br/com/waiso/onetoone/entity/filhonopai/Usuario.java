package br.com.waiso.onetoone.entity.filhonopai;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author fabianomatias
 * 
 * @since 09/06/2015
 * 
 * @type Pai
 *
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	@Transient
	private static final long serialVersionUID = -2241492606991331507L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "usuario")
	private String usuario;

	@Column(name = "senha")
	private String senha;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_email")
	private Email email;

	public Usuario() {
	}

	public Usuario(String usuario, String senha, Email email) {
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

}