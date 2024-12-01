package com.byoskill.pretimmo.dataobj;

import java.io.Serializable;
import java.util.StringJoiner;

public class DemandePretDO implements Serializable {

    private Long id; // Use Long for database IDs
    private ConditionsFinancieresDO conditionsFinancieresDO;
    private String status;
    private Long processId;

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConditionsFinancieresDO getConditionsFinancieres() {
        return conditionsFinancieresDO;
    }

    public void setConditionsFinancieres(ConditionsFinancieresDO conditionsFinancieresDO) {
        this.conditionsFinancieresDO = conditionsFinancieresDO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DemandePretDO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("conditionsFinancieres=" + conditionsFinancieresDO)
                .add("status='" + status + "'")
                .add("processId=" + processId)
                .toString();
    }
}