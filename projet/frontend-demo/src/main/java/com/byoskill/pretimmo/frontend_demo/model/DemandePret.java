package com.byoskill.pretimmo.frontend_demo.model;

public class DemandePret {

    private Long pretId;
    private ConditionsFinancieres conditionsFinancieres;
    private String status;

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ConditionsFinancieres getConditionsFinancieres() {
        return conditionsFinancieres;
    }

    public void setConditionsFinancieres(ConditionsFinancieres conditionsFinancieres) {
        this.conditionsFinancieres = conditionsFinancieres;
    }

    public Long getPretId() {
        return pretId;
    }

    public void setPretId(Long pretId) {
        this.pretId = pretId;
    }
}
