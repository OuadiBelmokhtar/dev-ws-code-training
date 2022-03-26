package me.obelmokhtar.demowsspringdatarest;

import lombok.AllArgsConstructor;
import me.obelmokhtar.demowsspringdatarest.entities.Compte;
import me.obelmokhtar.demowsspringdatarest.entities.TypeCompte;
import me.obelmokhtar.demowsspringdatarest.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.stream.DoubleStream;

@AllArgsConstructor
@SpringBootApplication
public class DemoWsSpringDataRestApplication {

    private CompteRepository compteRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoWsSpringDataRestApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.exposeIdsFor(Compte.class);
        return args -> {
            DoubleStream.of(10000, 1500, 3000).forEach(solde -> {
                Compte compte = new Compte();
                compte.setDateCreation(new Date());
                compte.setSolde(solde);
                compte.setType(Math.random() > 0.5 ? TypeCompte.EPARGNE : TypeCompte.COURANT);
                compteRepository.save(compte);
            });
        };
    }

}
