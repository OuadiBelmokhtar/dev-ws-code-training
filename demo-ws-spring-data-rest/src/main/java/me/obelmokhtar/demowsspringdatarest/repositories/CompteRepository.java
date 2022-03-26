package me.obelmokhtar.demowsspringdatarest.repositories;


import me.obelmokhtar.demowsspringdatarest.entities.Compte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
    Compte save(Compte compte);
    void deleteById(Long id);


}
