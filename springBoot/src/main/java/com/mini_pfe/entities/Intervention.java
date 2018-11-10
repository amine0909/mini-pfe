package com.mini_pfe.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="INTERVENTIONS")
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INTER_ID")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_EXECUTION")
    private Date dateExecution;

    @Column(name = "RESULTAT",nullable = false)
    private boolean resultat;

    public Reclamation getReclamation() {
        return reclamation;
    }

    public void setReclamation(Reclamation reclamation) {
        this.reclamation = reclamation;
    }

    public Technicien getTechnicien() {
        return technicien;
    }

    public void setTechnicien(Technicien technicien) {
        this.technicien = technicien;
    }

    @ManyToOne
    @JoinColumn(name = "REC_ID")
    private Reclamation reclamation;


    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Technicien technicien;

    public Intervention() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateExecution() {
        return dateExecution;
    }

    public void setDateExecution(Date dateExecution) {
        this.dateExecution = dateExecution;
    }

    public boolean isResultat() {
        return resultat;
    }

    public void setResultat(boolean resultat) {
        this.resultat = resultat;
    }
}
