package com.byoskill.pretimmo.frontend_demo.model;

public class DemandePret {

    private Integer pretId;
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

    public Integer getPretId() {
        return pretId;
    }

    public void setPretId(Integer pretId) {
        this.pretId = pretId;
    }
}
