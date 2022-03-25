package me.obelmokhtar.demowsrestjaxrsjersey.web;

import lombok.AllArgsConstructor;
import me.obelmokhtar.demowsrestjaxrsjersey.entities.Compte;
import me.obelmokhtar.demowsrestjaxrsjersey.repositories.CompteRepository;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import java.awt.*;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Path("/banque-jaxrs")
public class CompteRestJaxRsJersey {

    private CompteRepository compteRepository;

    // TODO: 3/25/22 Tester le retour XML
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) // obligatoire
    public List<Compte> getAll() {
        return compteRepository.findAll();
    }

    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Compte addCompte(Compte compte) { // l arg compte sera recu ds le corps de la requete (en JSON), puis deserialised en objet Compte
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getOne(@PathParam("id") Long id) {
        Compte compte = compteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Compte " + id + " not found!"));
        return compte;
    }

    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Compte updateCompte(Compte updatedCpt, @PathParam("id") Long idCptToUpdate) {
        Compte compte = compteRepository.findById(idCptToUpdate).orElse(null);
        if (compte == null)
            throw new IllegalArgumentException("Compte introuvable");
        updatedCpt.setCode(compte.getCode());// obligatoire, car lobjet updatedCpt recu ds la req est sans code, par consequent save() va faire INSERT INTO au lieu de UPDATE
        return compteRepository.save(updatedCpt);
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public String deleteCompte(@PathParam("id") Long id) {
        Optional<Compte> optCompte = compteRepository.findById(id);
        if (optCompte.isPresent()) {
            compteRepository.deleteById(id);
            return "Compte code " + id + " successfully deleted";
        }
        return "Compte not found";
    }

}
