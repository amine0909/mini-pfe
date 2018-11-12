package com.mini_pfe.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mini_pfe.entities.enums.WorkType;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("TECH")
public class Technicien extends User {
    @Column(name="TYPE_TRAVAIL")
    @Enumerated(EnumType.STRING)
    private WorkType typeTravail;

    public List<Intervention> getInterventions() {
        return interventions;
    }

    public void setInterventions(List<Intervention> interventions) {
        this.interventions = interventions;
    }

    public Technicien() {}

    public WorkType getTypeTravail() {
        return typeTravail;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "technicien")
    private List<Intervention> interventions;

    public void setTypeTravail(WorkType typeTravail) {
        this.typeTravail = typeTravail;
    }
}
