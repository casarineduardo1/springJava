package br.com.compasso.compasso.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.compasso.compasso.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	List<Cliente> findByNomeCompleto(String cliente);

}
