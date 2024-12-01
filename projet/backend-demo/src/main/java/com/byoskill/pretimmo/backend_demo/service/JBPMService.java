package com.byoskill.pretimmo.backend_demo.service;

import jakarta.annotation.PostConstruct;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.KieContainerResource;
import org.kie.server.api.model.KieContainerResourceList;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.ProcessServicesClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This service is responsible for the interactions between the backend and the KIE Server from JBPM
 * <p>
 * https://docs.redhat.com/en/documentation/red_hat_process_automation_manager/7.12/html/deploying_and_managing_red_hat_process_automation_manager_services/kie-server-java-api-con_kie-apis#kie-server-java-api-con_kie-apis
 **/
@Service
public class JBPMService {


    private static final MarshallingFormat FORMAT = MarshallingFormat.JSON;
    private final JBPMConfiguration configuration;
    private KieServicesConfiguration conf;
    private KieServicesClient kieServicesClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(JBPMService.class);

    @Autowired
    public JBPMService(JBPMConfiguration configuration) {

        this.configuration = configuration;
    }

    public KieServicesClient getKieServicesClient() {
        return kieServicesClient;
    }

    @PostConstruct
    public void init() {

        conf = KieServicesFactory.newRestConfiguration(configuration.getServer(), configuration.getUsername(), configuration.getPassword());

        //If you use custom classes, such as Obj.class, add them to the configuration.
        Set<Class<?>> extraClassList = new HashSet<Class<?>>();
        //extraClassList.add(DemandePret.class);
        //extraClassList.add(ConditionsFinancieres.class);
        conf.addExtraClasses(extraClassList);

        conf.setMarshallingFormat(FORMAT);
        kieServicesClient = KieServicesFactory.newKieServicesClient(conf);

        LOGGER.info("Connection to JBPM server established {}", kieServicesClient.getServerInfo());

        KieContainerResourceList containers = kieServicesClient.listContainers().getResult();
        for (KieContainerResource container : containers.getContainers()) {
            LOGGER.info("> Container id='{}', alias={}", container.getContainerId(), container.getContainerAlias(), container.getMessages());
        }


    }

    public ProcessServicesClient getProcessServiceClient() {

        return  kieServicesClient.getServicesClient(ProcessServicesClient.class);
    }

    public Long launchProcessus(String containerId,String processId,  Map<String, Object> parameters) {

        ProcessServicesClient processServiceClient = getProcessServiceClient();
        Long processInstanceId = processServiceClient.startProcess(containerId, processId, parameters);

        LOGGER.info("Process instance started with ID: {}", processInstanceId);
        return processInstanceId;
    }
}
