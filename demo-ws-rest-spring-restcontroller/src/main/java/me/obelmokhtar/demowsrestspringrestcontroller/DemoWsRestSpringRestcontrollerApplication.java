package me.obelmokhtar.demowsrestspringrestcontroller;

import me.obelmokhtar.demowsrestspringrestcontroller.entities.Compte;
import me.obelmokhtar.demowsrestspringrestcontroller.entities.TypeCompte;
import me.obelmokhtar.demowsrestspringrestcontroller.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DemoWsRestSpringRestcontrollerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWsRestSpringRestcontrollerApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {

        return args -> {
            Compte compte1 = new Compte();
            compte1.setDateCreation(new Date());
            compte1.setSolde(50000.0);
            compte1.setType(TypeCompte.COURANT);
            compteRepository.save(compte1);
            Compte compte2 = new Compte();
            compte2.setDateCreation(new Date());
            compte2.setSolde(10000.0);
            compte2.setType(TypeCompte.EPARGNE);
            compteRepository.save(compte2);
            Compte compte3 = new Compte();
            compte3.setDateCreation(new Date());
            compte3.setSolde(7000.0);
            compte3.setType(TypeCompte.PAYANT);
            compteRepository.save(compte3);
        };
    }
}
