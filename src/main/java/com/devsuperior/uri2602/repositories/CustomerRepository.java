package com.devsuperior.uri2602.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerNameProjection;
import com.devsuperior.uri2602.projections.CustomerNameStateProjection;

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

}
