package me.obelmokhtar.demowsspringdatarest.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "sldtype", types=Compte.class)
public interface CompteProjection2 {

    Double getSolde();
    String getType();
}
