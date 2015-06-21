package br.com.waiso.manytomany.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@IdClass(PersonDog.class)
public class PersonDog implements Serializable {

	@Transient
	private static final long serialVersionUID = 5830982254037899610L;

	@Id
	@ManyToOne
	@JoinColumn(name = "pessoa")
	private Persson pessoa;

	@Id
	@ManyToOne
	@JoinColumn(name = "cachorro")
	private Doggs cachorro;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	public Persson getPessoa() {
		return pessoa;
	}

	public void setPessoa(Persson pessoa) {
		this.pessoa = pessoa;
	}

	public Doggs getCachorro() {
		return cachorro;
	}

	public void setCachorro(Doggs cachorro) {
		this.cachorro = cachorro;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cachorro == null) ? 0 : cachorro.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonDog other = (PersonDog) obj;
		if (cachorro == null) {
			if (other.cachorro != null)
				return false;
		} else if (!cachorro.equals(other.cachorro))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}
	
}
