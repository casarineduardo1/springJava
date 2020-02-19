package br.com.compasso.compasso.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.compasso.compasso.model.Cidade;

public class CidadeDto {
	private Integer id;
	private String nome;
	private String estado;
	
	public CidadeDto(Cidade cidade) {
		this.id = cidade.getId();
		this.nome = cidade.getNome();
		this.estado = cidade.getEstado();
	}
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEstado() {
		return estado;
	}

	public static List<CidadeDto> converter(List<Cidade> cidades) {
		return cidades.stream().map(CidadeDto::new).collect(Collectors.toList());
	}		
}
