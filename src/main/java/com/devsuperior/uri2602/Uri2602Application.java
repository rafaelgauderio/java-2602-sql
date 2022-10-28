package com.devsuperior.uri2602;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.dto.CustomerNameDTO;
import com.devsuperior.uri2602.dto.CustomerNameStateDTO;
import com.devsuperior.uri2602.projections.CustomerNameProjection;
import com.devsuperior.uri2602.projections.CustomerNameStateProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// O que for colocado no método run, vai ser executado no início da aplicação
		
		List<CustomerNameProjection> list = customerRepository.searchName("RS");		
		System.out.println("\nClientes do Rio Grande do Sul");
		
		for (CustomerNameProjection object : list) {
			System.out.println("Nome: " + object.getName());
		}
		
		System.out.println("\nClientes de Minas Gerais usando DTO");
		List<CustomerNameProjection> list2 = customerRepository.searchName("MG");
		List<CustomerNameDTO> result = list2.stream().map(c -> new CustomerNameDTO(c)).collect(Collectors.toList());
		for (CustomerNameDTO object : result) {
			System.out.println(object);
		}
		
		System.out.println("\nListando clientes e estados do Rio de Janeiro usando a entidade");
		List<CustomerNameStateProjection> list3 = customerRepository.searchNameState("rj");
		for(CustomerNameStateProjection object : list3) {
			System.out.println("Nome: " + object.getName() + ", Estado: " + object.getState());
		}	
		System.out.println("\nListando clientes e estados do RJ usando DTO");
		List<CustomerNameStateDTO> result2 = list3.stream().map( c -> new CustomerNameStateDTO(c)).collect(Collectors.toList());
		for (CustomerNameStateDTO objeto : result2) {
			System.out.println(objeto);
		}
		
	}
}
