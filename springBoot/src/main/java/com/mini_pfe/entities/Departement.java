package com.mini_pfe.entities;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="DEPARTEMENTS")
public class Departement {
    public ChefDepartement getChef() {
        return chef;
    }

    public void setChef(ChefDepartement chef) {
        this.chef = chef;
    }

    public Collection<Classe> getClasses() {
        return classes;
    }

    public void setClasses(Collection<Classe> classes) {
        this.classes = classes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DEP_ID")

    private Long id;

    @Column(name="NOM",nullable = false)
    private String nom;

    @OneToOne(mappedBy = "departement")
    private ChefDepartement chef;

    @OneToMany(mappedBy = "departement")
    private Collection<Classe> classes;

    public Departement() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
