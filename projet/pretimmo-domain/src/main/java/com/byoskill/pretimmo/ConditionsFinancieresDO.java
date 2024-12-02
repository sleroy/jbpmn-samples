package com.byoskill.pretimmo;

import javax.xml.bind.annotation.XmlRootElement;
import org.kie.api.remote.Remotable;

@javax.xml.bind.annotation.XmlRootElement
public class ConditionsFinancieresDO implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label("montantDemande")
	private java.lang.Integer montantDemande;
	@org.kie.api.definition.type.Label("nombreAnnees")
	private java.lang.Integer nombreAnnees;
	@org.kie.api.definition.type.Label("revenuDemandeur")
	private java.lang.Integer revenuDemandeur;
	@org.kie.api.definition.type.Label("mensualite")
	private java.lang.Integer mensualite;
	@org.kie.api.definition.type.Label("interest")
	private java.lang.Float interest;

	public ConditionsFinancieresDO() {
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

	public ConditionsFinancieresDO(java.lang.Integer montantDemande,
			java.lang.Integer nombreAnnees, java.lang.Integer revenuDemandeur,
			java.lang.Integer mensualite, java.lang.Float interest) {
		this.montantDemande = montantDemande;
		this.nombreAnnees = nombreAnnees;
		this.revenuDemandeur = revenuDemandeur;
		this.mensualite = mensualite;
		this.interest = interest;
	}

}