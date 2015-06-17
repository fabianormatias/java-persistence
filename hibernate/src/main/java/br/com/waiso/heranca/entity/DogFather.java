package br.com.waiso.heranca.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

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
