package me.obelmokhtar.demowssoapjaxws.repositories;

import me.obelmokhtar.demowssoapjaxws.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
