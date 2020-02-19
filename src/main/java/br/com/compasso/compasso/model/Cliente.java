package br.com.compasso.compasso.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeCompleto;
	private char sexo;
	private Date dtNascimento;
	private Integer idade;
	@ManyToOne  
	@JoinColumn(name="cidade_id", referencedColumnName="id",nullable=false)  
	private Cidade cidade;
	
	public Cliente() {
		
	}
	
	
	
	public Cliente(String nomeCompleto, char sexo, Date dtNascimento, Integer idade, Cidade cidade) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.dtNascimento = dtNascimento;
		this.idade = idade;
		this.cidade = cidade;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
