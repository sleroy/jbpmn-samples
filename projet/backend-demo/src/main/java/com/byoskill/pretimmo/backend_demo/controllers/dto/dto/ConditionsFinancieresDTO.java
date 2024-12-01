package com.byoskill.pretimmo.backend_demo.controllers.dto.dto;

import java.io.Serializable;
import java.util.StringJoiner;

public class ConditionsFinancieresDTO implements Serializable {

    private Integer montantDemande;
    private Integer nombreAnnees;
    private Integer revenuDemandeur;
    private Integer mensualite;
    private Float interest;


    public ConditionsFinancieresDTO() {
    }

    public ConditionsFinancieresDTO(Integer montantDemande,
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

    @Override
    public String toString() {
        return new StringJoiner(", ", ConditionsFinancieresDTO.class.getSimpleName() + "[", "]")
                .add("montantDemande=" + montantDemande)
                .add("nombreAnnees=" + nombreAnnees)
                .add("revenuDemandeur=" + revenuDemandeur)
                .add("mensualite=" + mensualite)
                .add("interest=" + interest)
                .toString();
    }
}
