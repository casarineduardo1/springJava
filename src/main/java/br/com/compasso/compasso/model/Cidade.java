package br.com.compasso.compasso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cidade {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String estado;
	
	public Cidade() {
		
	}
	
	public Cidade(String nome, String estado) {
		this.nome = nome;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}