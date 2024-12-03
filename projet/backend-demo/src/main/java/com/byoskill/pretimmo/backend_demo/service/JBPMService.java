package com.byoskill.pretimmo.backend_demo.service;

import org.springframework.stereotype.Service;

/**
 * This service is responsible for the interactions between the backend and the
 * KIE Server from JBPM
 * <p>
 * https://docs.redhat.com/en/documentation/red_hat_process_automation_manager/7.12/html/deploying_and_managing_red_hat_process_automation_manager_services/kie-server-java-api-con_kie-apis#kie-server-java-api-con_kie-apis
 *
 */
@Service
public class JBPMService {


    public String getProcessInstanceStatus(String containerId, Long processId) {
        // TODO
        return null;
    }
}
