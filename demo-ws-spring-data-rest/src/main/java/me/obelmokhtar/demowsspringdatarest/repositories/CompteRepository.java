package me.obelmokhtar.demowsspringdatarest.repositories;


import me.obelmokhtar.demowsspringdatarest.entities.Compte;

import me.obelmokhtar.demowsspringdatarest.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
    // utiliser le meme nom de mtd/param lors de l acces
    // http://localhost:8083/api-banque/comptes/search/findCptByType?type=EPARGNE
    List<Compte> findCptByType(TypeCompte type);

    // // utiliser des noms de mtd/param personnalises lors de l acces
    // http://localhost:8083/api-banque/comptes/search/cptByNum?id=1
    @RestResource(path = "/cptByNum")
    Optional<Compte> findByCode(@Param("id") Long id);


    Compte save(Compte compte);
    void deleteById(Long id);


}
