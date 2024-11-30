package com.byoskill.pretimmobilier;

import java.util.HashMap;
import java.util.Map;

public class PretImmobilier {

    private ConditionsFinancieres conditionsFinancieres;
    private ValidationStatus validationStatus;

    public PretImmobilier() {
        this.conditionsFinancieres = new ConditionsFinancieres();
        this.validationStatus = new ValidationStatus();
    }

    public ConditionsFinancieres getConditionsFinancieres() {
        return conditionsFinancieres;
    }

    public void setConditionsFinancieres(ConditionsFinancieres conditionsFinancieres) {
        this.conditionsFinancieres = conditionsFinancieres;
    }

    public ValidationStatus getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(ValidationStatus validationStatus) {
        this.validationStatus = validationStatus;
    }
}
