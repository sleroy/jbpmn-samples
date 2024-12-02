package com.byoskill.pretimmo.dataobj;

import java.io.Serializable;

public class ConditionsFinancieresDO implements Serializable {

    private Long id; // Database ID

    @org.kie.api.definition.type.Label(value = "Montant demandé")
    private Integer montantDemande;
    @org.kie.api.definition.type.Label(value = "Nombre d'années")
    private Integer nombreAnnees;
    
    @org.kie.api.definition.type.Label(value = "Revenue Demandeur")
    private Integer revenuDemandeur;
    @org.kie.api.definition.type.Label(value = "Mensualité")
    private Integer mensualite;
    @org.kie.api.definition.type.Label(value = "Taux interet")
    private Float interest;

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
