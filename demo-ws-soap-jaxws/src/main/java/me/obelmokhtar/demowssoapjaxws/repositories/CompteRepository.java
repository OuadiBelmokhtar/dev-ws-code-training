package me.obelmokhtar.demowssoapjaxws.repositories;


import me.obelmokhtar.demowssoapjaxws.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {



}
