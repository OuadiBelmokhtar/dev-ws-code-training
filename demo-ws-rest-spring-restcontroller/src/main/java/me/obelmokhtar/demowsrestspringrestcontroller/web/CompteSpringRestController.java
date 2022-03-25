package me.obelmokhtar.demowsrestspringrestcontroller.web;

import lombok.AllArgsConstructor;
import me.obelmokhtar.demowsrestspringrestcontroller.entities.Compte;
import me.obelmokhtar.demowsrestspringrestcontroller.repositories.CompteRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banque-rsctrl")
@AllArgsConstructor
public class CompteSpringRestController {
    private CompteRepository compteRepository;

    @GetMapping(path ="/comptes", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Compte> getAll() {
        return compteRepository.findAll();
    }

    @PostMapping(path="/comptes", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Compte addCompte(@RequestBody Compte compte) { // l arg compte sera recu ds le corps de la requete (en JSON), puis deserialised en objet Compte
        return compteRepository.save(compte);
    }

    @GetMapping(path="/comptes/{id}")
    public Compte getOne(@PathVariable("id") Long id) {
        Compte compte = compteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Compte " + id + " not found!"));
        return compte;
    }

    @PutMapping(path = "/comptes/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Compte updateCompte(@RequestBody Compte updatedCpt, @PathVariable("id") Long idCptToUpdate) {
        Compte compte = compteRepository.findById(idCptToUpdate).orElse(null);
        if (compte == null)
            throw new IllegalArgumentException("Compte introuvable");
        updatedCpt.setCode(compte.getCode());// obligatoire, car lobjet updatedCpt recu ds la req est sans code, par consequent save() va faire INSERT INTO au lieu de UPDATE
        return compteRepository.save(updatedCpt);
    }

    @DeleteMapping(path = "/comptes/{id}")
    public String deleteCompte(@PathVariable("id") Long id) {
        Optional<Compte> optCompte = compteRepository.findById(id);
        if (optCompte.isPresent()) {
            compteRepository.deleteById(id);
            return "Compte code " + id + " successfully deleted";
        }
        return "Compte not found";
    }


}
