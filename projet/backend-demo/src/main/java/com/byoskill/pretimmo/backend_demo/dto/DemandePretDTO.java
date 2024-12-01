package com.byoskill.pretimmo.backend_demo.dto;

public class DemandePretDTO {

    private Long pretId;
    private ConditionsFinancieresDTO conditionsFinancieres;
    private String status;

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ConditionsFinancieresDTO getConditionsFinancieres() {
        return conditionsFinancieres;
    }

    public void setConditionsFinancieres(ConditionsFinancieresDTO conditionsFinancieres) {
        this.conditionsFinancieres = conditionsFinancieres;
    }

    public Long getPretId() {
        return pretId;
    }

    public void setPretId(Long pretId) {
        this.pretId = pretId;
    }
}
