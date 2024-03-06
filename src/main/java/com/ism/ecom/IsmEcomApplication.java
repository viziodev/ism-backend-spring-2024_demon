package com.ism.ecom;

import com.ism.ecom.data.entities.Client;
import com.ism.ecom.data.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class IsmEcomApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IsmEcomApplication.class, args);
	}

	@Autowired
	private  ClientRepository clientRepository;
	@Override
	public void run(String... args) throws Exception {
		List<Client> all = clientRepository.findAllByActive(false);
		all.stream().forEach(client -> {
			System.out.println(client.getNomComplet()+" ==="+client.getActive());
		});

	}


}
