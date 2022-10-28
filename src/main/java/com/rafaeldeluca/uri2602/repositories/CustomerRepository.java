package com.rafaeldeluca.uri2602.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rafaeldeluca.uri2602.dto.CustomerNameStateDTO;
import com.rafaeldeluca.uri2602.entities.Customer;
import com.rafaeldeluca.uri2602.projections.CustomerNameProjection;
import com.rafaeldeluca.uri2602.projections.CustomerNameStateProjection;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {
	
	//consulta customizada para retornar apenas os atributos desejados
	//consulta nativa com sql raiz
	@Query(nativeQuery = true, value = "SELECT name "
			+ "FROM customers "
			+ "WHERE state = :state")
	List<CustomerNameProjection> searchName(String state); 
	
	@Query(nativeQuery = true, value = "SELECT name, state "
			+ "FROM customers "
			+ "WHERE UPPER(state) = UPPER(:state)")
	List<CustomerNameStateProjection> searchNameState(String state);
	
	// consulta JPQL
	// necessário dar um apelido para o objeto - "Classe apelido_do_objeto"
	// Pode colocar direto o DTO como arumento
	@Query("SELECT new com.rafaeldeluca.uri2602.dto.CustomerNameStateDTO(objeto.name,objeto.state) "
			+ "FROM Customer objeto "
			+ "WHERE UPPER(objeto.state)=UPPER(:state)")
	List<CustomerNameStateDTO> search3(String state);

}
