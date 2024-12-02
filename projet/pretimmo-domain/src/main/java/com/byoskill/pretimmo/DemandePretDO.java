package com.byoskill.pretimmo;

import javax.xml.bind.annotation.XmlRootElement;
import org.kie.api.remote.Remotable;

@org.kie.api.definition.type.Label("DemandePretDO")
@javax.xml.bind.annotation.XmlRootElement
public class DemandePretDO implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label("conditionsFinancieresDO")
	private com.byoskill.pretimmo.ConditionsFinancieresDO conditionsFinancieresDO;
	@org.kie.api.definition.type.Label("status")
	private java.lang.String status;
	@org.kie.api.definition.type.Label("processId")
	private java.lang.Long processId;
	@org.kie.api.definition.type.Label("id")
	private java.lang.Long id;

	public DemandePretDO() {
	}

	public com.byoskill.pretimmo.ConditionsFinancieresDO getConditionsFinancieresDO() {
		return this.conditionsFinancieresDO;
	}

	public void setConditionsFinancieresDO(
			com.byoskill.pretimmo.ConditionsFinancieresDO conditionsFinancieresDO) {
		this.conditionsFinancieresDO = conditionsFinancieresDO;
	}

	public java.lang.String getStatus() {
		return this.status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public java.lang.Long getProcessId() {
		return this.processId;
	}

	public void setProcessId(java.lang.Long processId) {
		this.processId = processId;
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public DemandePretDO(
			com.byoskill.pretimmo.ConditionsFinancieresDO conditionsFinancieresDO,
			java.lang.String status, java.lang.Long processId, java.lang.Long id) {
		this.conditionsFinancieresDO = conditionsFinancieresDO;
		this.status = status;
		this.processId = processId;
		this.id = id;
	}

}