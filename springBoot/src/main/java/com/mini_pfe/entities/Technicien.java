package com.mini_pfe.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("TECH")
public class Technicien extends User {
    @Column(name="TYPE_TRAVAIL")
    private String typeTravail;

    public List<Intervention> getInterventions() {
        return interventions;
    }

    public void setInterventions(List<Intervention> interventions) {
        this.interventions = interventions;
    }

    public Technicien() {}

    public String getTypeTravail() {
        return typeTravail;
    }

    @OneToMany(mappedBy = "technicien")
    private List<Intervention> interventions;

    public void setTypeTravail(String typeTravail) {
        this.typeTravail = typeTravail;
    }
}
