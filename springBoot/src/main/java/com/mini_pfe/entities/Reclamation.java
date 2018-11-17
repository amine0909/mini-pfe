package com.mini_pfe.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

@Entity
@Table(name="RECLAMATIONS")
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="REC_ID")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CREATION")
    private Date dateCreation;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "MAT_ID")
    private Materiel materiel;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "CHEF_DEP_ID")
    private ChefDepartement chefDepartement;


    @JsonManagedReference
    @OneToMany(mappedBy = "reclamation")
    private Collection<Intervention> interventions = new LinkedList<>();;


    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    public ChefDepartement getChefDepartement() {
        return chefDepartement;
    }

    public void setChefDepartement(ChefDepartement chefDepartement) {
        this.chefDepartement = chefDepartement;
    }

    public Collection<Intervention> getInterventions() {
        return interventions;
    }

    public void setInterventions(Collection<Intervention> interventions) {
        this.interventions = interventions;
    }




    public Reclamation() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
