package me.obelmokhtar.demowssoapjaxws;

import me.obelmokhtar.demowssoapjaxws.entities.Client;
import me.obelmokhtar.demowssoapjaxws.entities.Compte;
import me.obelmokhtar.demowssoapjaxws.entities.TypeCompte;
import me.obelmokhtar.demowssoapjaxws.repositories.ClientRepository;
import me.obelmokhtar.demowssoapjaxws.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

import java.util.Date;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoWsSoapJaxwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWsSoapJaxwsApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(CompteRepository compteRepository,
                                  ClientRepository clientRepository) {

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

    // pr deployer le service web. en utilisant Spring
    @Bean
    SimpleJaxWsServiceExporter jaxWsServiceExporter(){
        SimpleJaxWsServiceExporter serviceExporter=new SimpleJaxWsServiceExporter();
        serviceExporter.setBaseAddress("http://0.0.0.0:8888/");
        return serviceExporter;
    }

}
