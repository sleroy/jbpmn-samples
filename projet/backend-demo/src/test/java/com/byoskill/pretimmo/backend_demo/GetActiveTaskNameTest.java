package com.byoskill.pretimmo.backend_demo;

import java.util.HashMap;

import org.junit.Ignore;
import org.junit.Test;

import com.byoskill.pretimmo.backend_demo.service.JBPMConfiguration;
import com.byoskill.pretimmo.backend_demo.service.JBPMService;

public class GetActiveTaskNameTest
{

    @Test
    @Ignore
    public void testGetActiveTaskName() {
        JBPMConfiguration configuration = new JBPMConfiguration();
        configuration.setServer("http://localhost:8080/kie-server/services/rest/server");
        configuration.setUsername("wbadmin");
        configuration.setPassword("wbadmin");
        JBPMService service = new JBPMService(configuration);
        String containerId = "com.byoskill.pretimmo:pretimmo-domain:1.0-SNAPSHOT";
        String processId = "PretImmobilierProcessusSimple";
        Long pid = service.launchProcessus(containerId, processId, new HashMap<>());
        System.out.println(pid);
        System.out.println(service.getActiveTaskName(containerId, pid));

        

    }

}
