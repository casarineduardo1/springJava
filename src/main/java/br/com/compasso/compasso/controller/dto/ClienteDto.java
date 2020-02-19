package br.com.compasso.compasso.controller.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.compasso.compasso.model.Cidade;
import br.com.compasso.compasso.model.Cliente;

public class ClienteDto {
	private String nomeCompleto;
	private char sexo;
	private Date dtNascimento;
	private Integer idade;  
	private Cidade cidade;
	
	public ClienteDto(Cliente cliente) {
		this.nomeCompleto = cliente.getNomeCompleto();
		this.sexo = cliente.getSexo();
		this.dtNascimento = cliente.getDtNascimento();
		this.idade = cliente.getIdade();
		this.cidade = cliente.getCidade();
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public char getSexo() {
		return sexo;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
	
}
