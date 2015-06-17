package br.com.waiso.heranca.jointable.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * 
 * @author fabianomatias
 * @since 17/06/2015
 * @type Pai
 * 
 * SINGLE_TABLE => essa anotação deve ser utilizada na classe de hierarquia mais alta (classe pai), 
 * também conhecida por “root”. Essa anotação define qual será o padrão de hierarquia a ser utilizado, 
 * sendo que seu valor default é SINGLE_TABLE.
 * 
 * @DiscriminatorColumn(name = “small_dog”) => define qual o nome da coluna que irá conter a descrição de 
 * qual tabela a linha da tabela no banco de dados irá pertencer.
 *
 */
@Entity
@Table(name = "bird")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "bird_class_name")
public abstract class Bird implements Serializable {

	private static final long serialVersionUID = 7616332079062429258L;

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