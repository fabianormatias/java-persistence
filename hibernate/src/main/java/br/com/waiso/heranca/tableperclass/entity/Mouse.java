package br.com.waiso.heranca.tableperclass.entity;

import java.io.Serializable;

import javax.persistence.Column;
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
 * @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) => É indicado que uma tabela por entidade concreta será utilizado.
 * Não existe mais a necessidade da anotação: @DiscriminatorColumn(name = * “DOG_CLASS_NAME”). Cada classe concreta terá todos os seus dados, com isso não existirá mais uma tabela com dados que não pertençam a ela.
 * Não existe mais a necessidade da anotação: @DiscriminatorValue pelo mesmo motivo explicado acima.
 * 
 * @DiscriminatorColumn(name = “mouse_class_name”) => define qual o nome da coluna que irá conter a descrição de 
 * qual tabela a linha da tabela no banco de dados irá pertencer.
 *
 */
@Entity
@Table(name = "bird")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Mouse implements Serializable {

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