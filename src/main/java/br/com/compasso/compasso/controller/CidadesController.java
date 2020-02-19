package br.com.compasso.compasso.controller;

import java.util.List;
import java.net.URI;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.compasso.controller.dto.CidadeDto;
import br.com.compasso.compasso.controller.form.CidadeForm;
import br.com.compasso.compasso.model.Cidade;
import br.com.compasso.compasso.repository.CidadeRepository;

@Controller
@RestController
@RequestMapping("/cidades")
public class CidadesController {
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping
	public List<CidadeDto> listaCidades(String nomeCidade) {
		List<Cidade> cidades;
		System.out.println(nomeCidade);
		if(nomeCidade == null || nomeCidade.isEmpty()) {
			cidades = cidadeRepository.findAll(); 
		}else if(nomeCidade.length() == 2) {
			cidades = cidadeRepository.findByEstado(nomeCidade); 
		} else {
			cidades = cidadeRepository.findByNome(nomeCidade); 
		}
			
		return CidadeDto.converter(cidades);
	}
	
	@PostMapping
	public ResponseEntity<CidadeDto> cadastrarCidade(@RequestBody CidadeForm cidadeForm, UriComponentsBuilder uriBuilder) {
		Cidade cidade = cidadeForm.converter(cidadeForm);
		cidadeRepository.save(cidade);
		URI uri = uriBuilder.path("/cidades/{id}").buildAndExpand(cidade.getId()).toUri();
		return ResponseEntity.created(uri).body(new CidadeDto(cidade));
	}
}