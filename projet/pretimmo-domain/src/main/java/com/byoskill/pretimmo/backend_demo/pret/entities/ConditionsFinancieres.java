package com.byoskill.pretimmo.backend_demo.pret.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity // This is now a JPA entity
public class ConditionsFinancieres implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Database ID

    private Integer montantDemande;
    private Integer nombreAnnees;
    private Integer revenuDemandeur;
    private Integer mensualite;
    private Float interest;
    // In ConditionsFinancieres.java
    @OneToOne(mappedBy = "conditionsFinancieres")
    private DemandePret demandePret;

    public DemandePret getDemandePret() {
        return demandePret;
    }

    public void setDemandePret(DemandePret demandePret) {
        this.demandePret = demandePret;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMontantDemande() {
        return montantDemande;
    }

    public void setMontantDemande(Integer montantDemande) {
        this.montantDemande = montantDemande;
    }

    public Integer getNombreAnnees() {
        return nombreAnnees;
    }

    public void setNombreAnnees(Integer nombreAnnees) {
        this.nombreAnnees = nombreAnnees;
    }

    public Integer getRevenuDemandeur() {
        return revenuDemandeur;
    }

    public void setRevenuDemandeur(Integer revenuDemandeur) {
        this.revenuDemandeur = revenuDemandeur;
    }

    public Integer getMensualite() {
        return mensualite;
    }

    public void setMensualite(Integer mensualite) {
        this.mensualite = mensualite;
    }

    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
    }
}
