package com.byoskill.pretimmo.backend_demo;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.byoskill.pretimmo.backend_demo.service.JBPMConfiguration;
import com.byoskill.pretimmo.backend_demo.service.JBPMService;

public class GetActiveTaskNameTest
{

    @Test
    //@Ignore
    public void testGetActiveTaskName() {
        JBPMConfiguration configuration = new JBPMConfiguration();
        configuration.setServer("http://localhost:8080/kie-server/services/rest/server");
        configuration.setUsername("wbadmin");
        configuration.setPassword("wbadmin");
        JBPMService service = new JBPMService(configuration);
        service.init();
        String containerId = "com.byoskill.pretimmo:pretimmo-domain:1.0-SNAPSHOT";
        String processId = "PretImmobilierProcessusSimple";
        Long pid = service.launchProcessus(containerId, processId, new HashMap<>());
        System.out.println(pid);
        System.out.println(service.getActiveTaskName(containerId, pid));
        
        Long pid2 = 11L;
        org.kie.server.api.model.instance.ProcessInstance process  = service.getProcessClient().getProcessInstance(containerId, pid2);
        System.out.println("Correlation key" + process.getCorrelationKey());
        System.out.println("Variables" + process.getVariables());
        System.out.println(service.getProcessServiceClient().findVariablesCurrentState(containerId, pid2));

        

    }

}
