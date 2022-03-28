package me.obelmokhtar.demowssoapjaxws.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) // indiquer a JAXB que les annotations sont palces sur les attribtus non pas les getters
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @XmlTransient // pr eviter l invocation cyclique causee par l association bidirectionnelle
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Collection<Compte> comptes=new ArrayList<>();
}
