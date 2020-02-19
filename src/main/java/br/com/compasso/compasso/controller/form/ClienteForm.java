package br.com.compasso.compasso.controller.form;

import java.util.List;

import java.sql.Date;

import javax.validation.constraints.*;

import br.com.compasso.compasso.model.Cidade;
import br.com.compasso.compasso.model.Cliente;
import br.com.compasso.compasso.repository.CidadeRepository;

public class ClienteForm {
	@NotNull @NotEmpty 
	private String nomeCompleto;
	

	private char sexo;

	private Date dtNascimento;

	@Min(value = 18, message = "Idade não pode ser menor que 18")
    @Max(value = 150, message = "Idade não pode ser maior 150")
	private Integer idade;
	
	@NotNull @NotEmpty 
	private String cidadeNome;

	
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

	public String getCidadeNome() {
		return cidadeNome;
	}

	public void setCidadeNome(String cidadeNome) {
		this.cidadeNome = cidadeNome;
	}

	public Cliente converter(CidadeRepository cidadeRepository) {
		List<Cidade> cidade = cidadeRepository.findByNome(cidadeNome);
		Cliente cliente = new Cliente(nomeCompleto, sexo, dtNascimento, idade, cidade.get(0));
		return cliente;
	}
	
	
}
