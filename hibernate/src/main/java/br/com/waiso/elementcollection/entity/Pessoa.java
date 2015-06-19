package br.com.waiso.elementcollection.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author fabianomatias
 * @since 18/06/2015
 * 
 */
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1000204397175289954L;

	public Pessoa() {
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@ElementCollection
	@CollectionTable(name = "pessoa_emails")
	private Set<String> emails;

	@ElementCollection(targetClass = CarBrands.class)
	@Enumerated(EnumType.STRING)
//	@Column(name = "pessoa_brands") //Não tá funcionando a alteração de nome
	private List<CarBrands> brands;

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

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	public List<CarBrands> getBrands() {
		return brands;
	}

	public void setBrands(List<CarBrands> brands) {
		this.brands = brands;
	}

}
