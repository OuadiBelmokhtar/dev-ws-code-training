package me.obelmokhtar.demowsrestspringrestcontroller.repositories;


import me.obelmokhtar.demowsrestspringrestcontroller.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    Compte save(Compte compte);
    void deleteById(Long id);


}
