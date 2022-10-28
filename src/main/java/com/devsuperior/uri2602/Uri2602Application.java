package com.devsuperior.uri2602;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.projections.CustomerNameProjection;
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
		List<CustomerNameProjection> list2 = customerRepository.searchName("MG");
		
		System.out.println("\nClientes do Rio Grande do Sul");
		
		for (CustomerNameProjection object : list) {
			System.out.println("Nome:" + object.getName());
		}
		
		System.out.println("\nClientes de Minas Gerais");
		
		for (CustomerNameProjection object : list2) {
			System.out.println("Nome:" + object.getName());
		}
		
		
	}
}
