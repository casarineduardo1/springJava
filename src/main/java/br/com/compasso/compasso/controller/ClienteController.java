package br.com.compasso.compasso.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import br.com.compasso.compasso.controller.dto.ClienteDto;
import br.com.compasso.compasso.controller.form.AtualizaClienteForm;
import br.com.compasso.compasso.controller.form.ClienteForm;
import br.com.compasso.compasso.model.Cliente;
import br.com.compasso.compasso.repository.CidadeRepository;
import br.com.compasso.compasso.repository.ClienteRepository;

@Controller
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping
	public List<ClienteDto> listaClientes(String nome) {
		List<Cliente> clientes = clienteRepository.findByNomeCompleto(nome);  
		return ClienteDto.converter(clientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> listaClienteId(@PathVariable 	Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDto(cliente.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto> CadastraCliente(@RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {
		Cliente cliente = clienteForm.converter(cidadeRepository);
		clienteRepository.save(cliente);
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
		
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizarCliente(@PathVariable Integer id, @RequestBody @Valid AtualizaClienteForm atualizaClienteForm){
		Optional<Cliente> optional = clienteRepository.findById(id);
		if(optional.isPresent()) {
			Cliente cliente = atualizaClienteForm.atualizar(id, clienteRepository);
			return ResponseEntity.ok(new ClienteDto(cliente));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> removerCliente(@PathVariable Integer id){
		Optional<Cliente> optional = clienteRepository.findById(id);
		System.out.println(optional);
		if(optional.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
