package me.obelmokhtar.demowsspringdatarest.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement // ca marche pas
//@JacksonXmlRootElement(localName = "Compte") // pr la serialisation au format XML
@Entity(name = "T_COMPTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @JacksonXmlProperty(isAttribute = true) // serialiser le code comme attribut, non pas elt XML
    private Long code;
    private Double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private TypeCompte type;
}
