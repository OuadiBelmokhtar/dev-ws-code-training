package me.obelmokhtar.demowssoapjaxws.web;

import me.obelmokhtar.demowssoapjaxws.entities.Compte;
import me.obelmokhtar.demowssoapjaxws.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Component
@WebService(serviceName = "banqueSoapWs")
public class CompteSoapService {

    @Autowired
    private CompteRepository compteRepository;

    @WebMethod
    public List<Compte> compteList() {
        return compteRepository.findAll();
    }

    @WebMethod
    public Compte getOne(@WebParam(name="id") Long id){
        return compteRepository.findById(id).orElse(null);
    }
}
