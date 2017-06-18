package br.com.sistema.web.controller;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.sistema.web.entity.Cliente;

public class Aplicacao {

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create("/sistema-web/rest/clientes"))
				.header("Authorization", "Basic YWRtaW46YWRtaW4=").build();
		
		ResponseEntity<Cliente[]> response = restTemplate.exchange(request, Cliente[].class);
		
		for(Cliente cli : response.getBody()){
			System.out.println("Cliente: "+cli.getNome());
		}

	}

}
