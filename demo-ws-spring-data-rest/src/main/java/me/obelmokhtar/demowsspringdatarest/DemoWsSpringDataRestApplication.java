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



}
