package br.gov.prodepa.bookmark.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_setor")
	private Setor setor;
	
	@ManyToOne
	@JoinColumn(name = "id_lider")
	private Usuario lider;
	
	@OneToMany
    @JoinTable(name="projeto_desenvs",
        joinColumns=
            @JoinColumn(name="projeto_id", referencedColumnName="id"),
        inverseJoinColumns=
            @JoinColumn(name="desenv_id", referencedColumnName="id")
        )
	private List<Usuario> desenvs;
	
	
	public Projeto() {
		super();
	}


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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Setor getSetor() {
		return setor;
	}


	public void setSetor(Setor setor) {
		this.setor = setor;
	}


	public Usuario getLider() {
		return lider;
	}


	public void setLider(Usuario lider) {
		this.lider = lider;
	}


	public List<Usuario> getDesenvs() {
		return desenvs;
	}


	public void setDesenvs(List<Usuario> desenvs) {
		this.desenvs = desenvs;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
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
		Projeto other = (Projeto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		return true;
	}

}
