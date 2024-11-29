package com.byoskill.pretimmobilier;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class PretImmobilier implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label("Montant demandé")
	private java.lang.Integer montantDemande;
	@org.kie.api.definition.type.Label("Nombre d'années")
	private java.lang.Integer nombreAnnees;
	@org.kie.api.definition.type.Label("Revenue demandeur")
	private java.lang.Integer revenuDemandeur;

	@org.kie.api.definition.type.Label(value = "Mensualité calculée")
	private java.lang.Integer mensualite;

	@org.kie.api.definition.type.Label(value = "Interet")
	private java.lang.Float interest;

	public PretImmobilier() {
	}

	public java.lang.Integer getMontantDemande() {
		return this.montantDemande;
	}

	public void setMontantDemande(java.lang.Integer montantDemande) {
		this.montantDemande = montantDemande;
	}

	public java.lang.Integer getNombreAnnees() {
		return this.nombreAnnees;
	}

	public void setNombreAnnees(java.lang.Integer nombreAnnees) {
		this.nombreAnnees = nombreAnnees;
	}

	public java.lang.Integer getRevenuDemandeur() {
		return this.revenuDemandeur;
	}

	public void setRevenuDemandeur(java.lang.Integer revenuDemandeur) {
		this.revenuDemandeur = revenuDemandeur;
	}

	public java.lang.Integer getMensualite() {
		return this.mensualite;
	}

	public void setMensualite(java.lang.Integer mensualite) {
		this.mensualite = mensualite;
	}

	public java.lang.Float getInterest() {
		return this.interest;
	}

	public void setInterest(java.lang.Float interest) {
		this.interest = interest;
	}

	public PretImmobilier(java.lang.Integer montantDemande,
			java.lang.Integer nombreAnnees, java.lang.Integer revenuDemandeur,
			java.lang.Integer mensualite, java.lang.Float interest) {
		this.montantDemande = montantDemande;
		this.nombreAnnees = nombreAnnees;
		this.revenuDemandeur = revenuDemandeur;
		this.mensualite = mensualite;
		this.interest = interest;
	}

}