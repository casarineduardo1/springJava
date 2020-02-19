package br.com.compasso.compasso.controller.form;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.compasso.compasso.model.Cidade;

public class CidadeForm {
	@NotNull @NotEmpty 
	private String nome;
	
	@NotNull @NotEmpty 
	private String estado;
	
	
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
	
	
	public Cidade converter(CidadeForm cidadeForm) {
		Cidade cidade = new Cidade(cidadeForm.getNome(), cidadeForm.getEstado());
		return cidade;
	}
}
