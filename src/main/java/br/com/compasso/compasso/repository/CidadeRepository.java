package br.com.compasso.compasso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.compasso.compasso.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	List<Cidade> findByNome(String nomeCidade);
	List<Cidade> findByEstado(String siglaEstado);
	
}