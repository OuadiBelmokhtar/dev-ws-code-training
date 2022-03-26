package me.obelmokhtar.demowsspringdatarest.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="sld", types ={Compte.class} )
public interface CompteProjection1 {
    Double getSolde();
}
