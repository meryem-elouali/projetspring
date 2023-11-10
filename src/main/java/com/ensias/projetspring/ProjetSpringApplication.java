package com.ensias.projetspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.ensias.projetspring.modele.Proprietaire;
import com.ensias.projetspring.modele.ProprietaireRepo;
import com.ensias.projetspring.modele.Voiture;
import com.ensias.projetspring.modele.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class ProjetSpringApplication {

	@Autowired
	private VoitureRepo voitureRepo;
	@Autowired
	private ProprietaireRepo proprietaireRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjetSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Proprietaire proprietaire1 = new Proprietaire("Ali", "Hassan");
			Proprietaire proprietaire2 = new Proprietaire("Najat", "Bani");

			proprietaireRepo.save(proprietaire1);
			proprietaireRepo.save(proprietaire2);
			voitureRepo.save(new Voiture("BMW", "Corolla", "Grise", "A-1-9090", 2018, 95000, proprietaire1));
			voitureRepo.save(new Voiture("audi", "Fiesta", "Rouge", "A-2-8090", 2015, 90000, proprietaire1));
			voitureRepo.save(new Voiture("jaguar", "CRV", "Bleu", "A-3-7090", 2016, 140000, proprietaire2));
		};
	}
}