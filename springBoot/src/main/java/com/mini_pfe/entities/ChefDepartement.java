package com.mini_pfe.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@DiscriminatorValue("CHEF_DEP")
public class ChefDepartement extends  User{

    @OneToOne
    @JoinColumn(name = "DEP_ID")
    @JsonBackReference
    private Departement departement;

    @OneToMany
    @JoinColumn(name = "chefDepartement")
    @JsonManagedReference
    private Collection<Reclamation> reclamations;

    public ChefDepartement() {}


    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Collection<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(Collection<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }



}
