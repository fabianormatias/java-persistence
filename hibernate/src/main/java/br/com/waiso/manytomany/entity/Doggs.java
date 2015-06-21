package br.com.waiso.manytomany.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "doggs")
public class Doggs implements Serializable {

	@Transient
	private static final long serialVersionUID = 7601643780174994766L;
	
	public Doggs() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@ManyToMany(mappedBy = "doggs")
	private List<Doggs> dogs;

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

	public List<Doggs> getDogs() {
		return dogs;
	}

	public void setDogs(List<Doggs> dogs) {
		this.dogs = dogs;
	}

}