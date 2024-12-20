package com.byoskill.pretimmo.frontend_demo.model;

import java.io.Serializable;

public class ConditionsFinancieres implements Serializable {

    private Integer montantDemande = 0;
    private Integer nombreAnnees = 20;
    private Integer revenuDemandeur = 2000;
    private Integer mensualite = 700;
    private Float interest = 0.2f;

    public ConditionsFinancieres() {
    }

    public ConditionsFinancieres(Integer montantDemande,
                                 Integer nombreAnnees, Integer revenuDemandeur,
                                 Integer mensualite, Float interest) {
        this.montantDemande = montantDemande;
        this.nombreAnnees = nombreAnnees;
        this.revenuDemandeur = revenuDemandeur;
        this.mensualite = mensualite;
        this.interest = interest;
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

    // Méthodes utilitaires
    public boolean isMensualiteExcessive() {
        return mensualite != null && revenuDemandeur != null
                && mensualite > (revenuDemandeur * 0.3);
    }

    public double getRatioEndettement() {
        return (mensualite != null && revenuDemandeur != null)
                ? (double) (mensualite * 12) / revenuDemandeur
                : 0;
    }
}
