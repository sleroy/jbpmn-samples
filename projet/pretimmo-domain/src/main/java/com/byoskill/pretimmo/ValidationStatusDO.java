package com.byoskill.pretimmo;

import org.kie.api.remote.Remotable;

@Remotable
public class ValidationStatusDO implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label(value = "notaireValidation")
	private java.lang.Boolean notaireValidation;
	@org.kie.api.definition.type.Label(value = "conseillerValidation")
	private java.lang.Boolean conseillerValidation;
	@org.kie.api.definition.type.Label(value = "directeurValidation")
	private java.lang.Boolean directeurValidation;
	@org.kie.api.definition.type.Label(value = "riskAssessmentValidation")
	private java.lang.Boolean riskAssessmentValidation;
	@org.kie.api.definition.type.Label(value = "serviceFinancierValidation")
	private java.lang.Boolean serviceFinancierValidation;
	@org.kie.api.definition.type.Label(value = "reglesFinanciereValidation")
	private java.lang.Boolean reglesFinanciereValidation;

	public ValidationStatusDO() {
	}

	public java.lang.Boolean getNotaireValidation() {
		return this.notaireValidation;
	}


	public void setNotaireValidation(boolean notaireValidation) {
		this.notaireValidation = notaireValidation;
	}


	public void setNotaireValidation(java.lang.Boolean notaireValidation) {
		this.notaireValidation = notaireValidation;
	}

	public java.lang.Boolean getConseillerValidation() {
		return this.conseillerValidation;
	}

	public void setConseillerValidation(java.lang.Boolean conseillerValidation) {
		this.conseillerValidation = conseillerValidation;
	}

	public java.lang.Boolean getDirecteurValidation() {
		return this.directeurValidation;
	}

	public void setDirecteurValidation(java.lang.Boolean directeurValidation) {
		this.directeurValidation = directeurValidation;
	}

	public java.lang.Boolean getRiskAssessmentValidation() {
		return this.riskAssessmentValidation;
	}

	public void setRiskAssessmentValidation(
			java.lang.Boolean riskAssessmentValidation) {
		this.riskAssessmentValidation = riskAssessmentValidation;
	}

	public java.lang.Boolean getServiceFinancierValidation() {
		return this.serviceFinancierValidation;
	}

	public void setServiceFinancierValidation(
			java.lang.Boolean serviceFinancierValidation) {
		this.serviceFinancierValidation = serviceFinancierValidation;
	}

	public java.lang.Boolean getReglesFinanciereValidation() {
		return this.reglesFinanciereValidation;
	}

	public void setReglesFinanciereValidation(
			java.lang.Boolean reglesFinanciereValidation) {
		this.reglesFinanciereValidation = reglesFinanciereValidation;
	}

	public ValidationStatusDO(java.lang.Boolean notaireValidation,
			java.lang.Boolean conseillerValidation,
			java.lang.Boolean directeurValidation,
			java.lang.Boolean riskAssessmentValidation,
			java.lang.Boolean serviceFinancierValidation,
			java.lang.Boolean reglesFinanciereValidation) {
		this.notaireValidation = notaireValidation;
		this.conseillerValidation = conseillerValidation;
		this.directeurValidation = directeurValidation;
		this.riskAssessmentValidation = riskAssessmentValidation;
		this.serviceFinancierValidation = serviceFinancierValidation;
		this.reglesFinanciereValidation = reglesFinanciereValidation;
	}

}