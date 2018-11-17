package com.mini_pfe.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.lang.annotation.Inherited;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

@Entity
@DiscriminatorValue("CHEF_DEP")
public class ChefDepartement extends  User {

    @OneToOne
    @JoinColumn(name = "DEP_ID")
    @JsonManagedReference
    private Departement departement;

    @JsonBackReference
    @OneToMany(mappedBy = "chefDepartement")
    private Collection<Reclamation> reclamations = new LinkedList<>();

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
