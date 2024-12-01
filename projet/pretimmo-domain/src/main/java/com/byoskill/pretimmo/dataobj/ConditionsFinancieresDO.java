package com.byoskill.pretimmo.dataobj;

import java.io.Serializable;

public class ConditionsFinancieresDO implements Serializable {

    private Long id; // Database ID

    private Integer montantDemande;
    private Integer nombreAnnees;
    private Integer revenuDemandeur;
    private Integer mensualite;
    private Float interest;
    private DemandePretDO demandePretDO;

    public DemandePretDO getDemandePret() {
        return demandePretDO;
    }

    public void setDemandePret(DemandePretDO demandePretDO) {
        this.demandePretDO = demandePretDO;
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
