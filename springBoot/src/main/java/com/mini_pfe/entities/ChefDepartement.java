package com.mini_pfe.entities;



import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@DiscriminatorValue("CHEF_DEP")
public class ChefDepartement extends  User{

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

    @OneToOne

    @JoinColumn(name = "DEP_ID")
    private Departement departement;

    @OneToMany
    @JoinColumn(name = "chefDepartement")
    private Collection<Reclamation> reclamations;

}
