package com.byoskill.pretimmobilier;

import java.io.Serializable;

public class ConditionsFinancieres implements Serializable {

	@org.kie.api.definition.type.Label("montantDemande")
	private Integer montantDemande;
	@org.kie.api.definition.type.Label("nombreAnnees")
	private Integer nombreAnnees;
	@org.kie.api.definition.type.Label("revenuDemandeur")
	private Integer revenuDemandeur;
	@org.kie.api.definition.type.Label("mensualite")
	private Integer mensualite;
	@org.kie.api.definition.type.Label("interest")
	private Float interest;

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

	public ConditionsFinancieres() {
	}

	public ConditionsFinancieres(java.lang.Integer montantDemande,
			java.lang.Integer nombreAnnees, java.lang.Integer revenuDemandeur,
			java.lang.Integer mensualite, java.lang.Float interest) {
		this.montantDemande = montantDemande;
		this.nombreAnnees = nombreAnnees;
		this.revenuDemandeur = revenuDemandeur;
		this.mensualite = mensualite;
		this.interest = interest;
	}
}
