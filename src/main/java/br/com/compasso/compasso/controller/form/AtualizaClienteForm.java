package br.com.compasso.compasso.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.compasso.compasso.model.Cliente;
import br.com.compasso.compasso.repository.ClienteRepository;

public class AtualizaClienteForm {
	@NotNull @NotEmpty
	private String nomeCompleto;

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Cliente atualizar(Integer id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getOne(id);
		cliente.setNomeCompleto(this.nomeCompleto);
		return cliente;
	}
	
	
}
