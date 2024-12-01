package com.byoskill.pretimmo.dataobj;

public class ValidationStatusDO implements java.io.Serializable {

	private boolean notaireValidation = false;
	private boolean conseillerValidation = false;
	private boolean directeurValidation = false;
	private boolean riskAssessmentValidation = false;
	private boolean serviceFinancierValidation = false;
	private Boolean reglesFinanciereValidation;

	public boolean isNotaireValidation() {
		return notaireValidation;
	}

	public void setNotaireValidation(boolean notaireValidation) {
		this.notaireValidation = notaireValidation;
	}

	public boolean isConseillerValidation() {
		return conseillerValidation;
	}

	public void setConseillerValidation(boolean conseillerValidation) {
		this.conseillerValidation = conseillerValidation;
	}

	public boolean isDirecteurValidation() {
		return directeurValidation;
	}

	public void setDirecteurValidation(boolean directeurValidation) {
		this.directeurValidation = directeurValidation;
	}

	public boolean isRiskAssessmentValidation() {
		return riskAssessmentValidation;
	}

	public void setRiskAssessmentValidation(boolean riskAssessmentValidation) {
		this.riskAssessmentValidation = riskAssessmentValidation;
	}

	public boolean isServiceFinancierValidation() {
		return serviceFinancierValidation;
	}

	public void setServiceFinancierValidation(boolean serviceFinancierValidation) {
		this.serviceFinancierValidation = serviceFinancierValidation;
	}

	public boolean isValidationComplete() {
		return notaireValidation && conseillerValidation && directeurValidation
				&& riskAssessmentValidation && serviceFinancierValidation;
	}

	public ValidationStatusDO() {
	}

	public Boolean getReglesFinanciereValidation() {
		return this.reglesFinanciereValidation;
	}

	public Boolean isReglesFinanciereValidation() {
		return this.reglesFinanciereValidation;
	}

	public void setReglesFinanciereValidation(
			Boolean reglesFinanciereValidation) {
		this.reglesFinanciereValidation = reglesFinanciereValidation;
	}

	public ValidationStatusDO(boolean notaireValidation,
			boolean conseillerValidation, boolean directeurValidation,
			boolean riskAssessmentValidation,
			boolean serviceFinancierValidation,
			Boolean reglesFinanciereValidation) {
		this.notaireValidation = notaireValidation;
		this.conseillerValidation = conseillerValidation;
		this.directeurValidation = directeurValidation;
		this.riskAssessmentValidation = riskAssessmentValidation;
		this.serviceFinancierValidation = serviceFinancierValidation;
		this.reglesFinanciereValidation = reglesFinanciereValidation;
	}
}
