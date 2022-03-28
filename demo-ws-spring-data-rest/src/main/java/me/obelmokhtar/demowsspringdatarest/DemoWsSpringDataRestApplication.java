package me.obelmokhtar.demowsspringdatarest;

import lombok.AllArgsConstructor;
import me.obelmokhtar.demowsspringdatarest.entities.Client;
import me.obelmokhtar.demowsspringdatarest.entities.Compte;
import me.obelmokhtar.demowsspringdatarest.entities.TypeCompte;
import me.obelmokhtar.demowsspringdatarest.repositories.ClientRepository;
import me.obelmokhtar.demowsspringdatarest.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

@AllArgsConstructor
@SpringBootApplication
public class DemoWsSpringDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWsSpringDataRestApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(CompteRepository compteRepository,
                                  ClientRepository clientRepository,
                                  RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.exposeIdsFor(Compte.class);
        return args -> {

            Stream.of("Ahmed", "Taha").forEach(name -> {
                Client client = new Client();
                client.setName(name);
                clientRepository.save(client);
            });
            Client client = clientRepository.findById(1L).orElse(null);

            DoubleStream.of(10000, 1500, 3000).forEach(solde -> {
                Compte compte = new Compte();
                compte.setDateCreation(new Date());
                compte.setSolde(solde);
                compte.setType(Math.random() > 0.5 ? TypeCompte.EPARGNE : TypeCompte.COURANT);
                compte.setClient(client);
                compteRepository.save(compte);
                client.getComptes().add(compte);

            });
        };
    }

}
