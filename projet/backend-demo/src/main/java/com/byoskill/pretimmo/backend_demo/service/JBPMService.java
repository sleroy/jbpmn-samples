package com.byoskill.pretimmo.backend_demo.service;

import jakarta.annotation.PostConstruct;

import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.KieContainerResource;
import org.kie.server.api.model.KieContainerResourceList;
import org.kie.server.api.model.instance.ProcessInstance;
import org.kie.server.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.kie.server.api.model.instance.NodeInstance;

/**
 * This service is responsible for the interactions between the backend and the
 * KIE Server from JBPM
 * <p>
 * https://docs.redhat.com/en/documentation/red_hat_process_automation_manager/7.12/html/deploying_and_managing_red_hat_process_automation_manager_services/kie-server-java-api-con_kie-apis#kie-server-java-api-con_kie-apis
 *
 */
@Service
public class JBPMService {

    public static final int STATE_ABORTED = 3;
    public static final int STATE_ACTIVE = 1;
    public static final int STATE_COMPLETED = 2;
    public static final int STATE_PENDING = 0;
    public static final int STATE_SUSPENDED = 4;
    //
    private static final MarshallingFormat FORMAT = MarshallingFormat.JSON;
    private static final Logger LOGGER = LoggerFactory.getLogger(JBPMService.class);
    private final JBPMConfiguration configuration;
    private KieServicesConfiguration conf;
    private KieServicesClient kieServicesClient;

    // Rules client
    private RuleServicesClient ruleClient;

    // Process automation clients
    private CaseServicesClient caseClient;
    private DocumentServicesClient documentClient;
    private JobServicesClient jobClient;
    private ProcessServicesClient processClient;
    private QueryServicesClient queryClient;
    private UIServicesClient uiClient;
    private UserTaskServicesClient userTaskClient;

    // DMN client
    private DMNServicesClient dmnClient;

    // Planning client
    private  SolverServicesClient solverClient;

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
        initializeDroolsServiceClients();
        initializeJbpmServiceClients();
        initializeSolverServiceClients();


        LOGGER.info("Connection to JBPM server established {}", kieServicesClient.getServerInfo());

        KieContainerResourceList containers = kieServicesClient.listContainers().getResult();
        for (KieContainerResource container : containers.getContainers()) {
            LOGGER.info("> Container id='{}', alias={}", container.getContainerId(), container.getContainerAlias(), container.getMessages());
        }

    }

    public void initializeDroolsServiceClients() {
        ruleClient = kieServicesClient.getServicesClient(RuleServicesClient.class);
        dmnClient = kieServicesClient.getServicesClient(DMNServicesClient.class);
    }

    public void initializeJbpmServiceClients() {
        caseClient = kieServicesClient.getServicesClient(CaseServicesClient.class);
        documentClient = kieServicesClient.getServicesClient(DocumentServicesClient.class);
        jobClient = kieServicesClient.getServicesClient(JobServicesClient.class);
        processClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);
        queryClient = kieServicesClient.getServicesClient(QueryServicesClient.class);
        uiClient = kieServicesClient.getServicesClient(UIServicesClient.class);
        userTaskClient = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
    }

    public void initializeSolverServiceClients() {
        solverClient = kieServicesClient.getServicesClient(SolverServicesClient.class);
    }

    public ProcessServicesClient getProcessServiceClient() {

        return kieServicesClient.getServicesClient(ProcessServicesClient.class);
    }

    public UserTaskServicesClient getUserTaskServicesClient() {

        return kieServicesClient.getServicesClient(UserTaskServicesClient.class);
    }

    public Long launchProcessus(String containerId, String processId, Map<String, Object> parameters) {

        ProcessServicesClient processServiceClient = getProcessServiceClient();
        Long processInstanceId = processServiceClient.startProcess(containerId, processId, parameters);

        LOGGER.info("Process instance started with ID: {}", processInstanceId);
        return processInstanceId;
    }

    public String getProcessInstanceStatus(String containerId, Long processId) {
        if (processId == null) {
            return "Inconnu";
        }
        ProcessInstance processInstance = getProcessServiceClient().getProcessInstance(containerId, processId);
        if (processInstance == null) {
            return "Completed";
        }
        return getProcessusInstanceStatus(processInstance) + " - " + getActiveTaskName(containerId, processId);
    }

    private static String getProcessusInstanceStatus(ProcessInstance processInstance) {
        Integer processInstanceState = processInstance.getState();
        return switch (processInstanceState) {
            case STATE_COMPLETED ->
                "Completed";
            case STATE_ABORTED ->
                "Aborted";
            case STATE_SUSPENDED ->
                "Suspended";
            case STATE_PENDING ->
                "Pending";
            case STATE_ACTIVE ->
                "Active";
            default ->
                "Unknown state " + processInstanceState;
        };
    }

    public String getActiveTaskName(String containerId, Long processId) {
        if (processId == null) {
            return "Inconnu";
        }
        List<NodeInstance> nodes = getProcessClient().findActiveNodeInstances(containerId, processId, 0, 2);
        return nodes.stream().map(node -> node.getName()).collect(Collectors.joining(","));

    }

    public RuleServicesClient getRuleClient() {
        return ruleClient;
    }

    public CaseServicesClient getCaseClient() {
        return caseClient;
    }

    public DocumentServicesClient getDocumentClient() {
        return documentClient;
    }

    public ProcessServicesClient getProcessClient() {
        return processClient;
    }

    public QueryServicesClient getQueryClient() {
        return queryClient;
    }

    public UIServicesClient getUiClient() {
        return uiClient;
    }

    public UserTaskServicesClient getUserTaskClient() {
        return userTaskClient;
    }

    public SolverServicesClient getSolverClient() {
        return solverClient;
    }

    public DMNServicesClient getDmnClient() {
        return dmnClient;
    }

    public JobServicesClient getJobClient() {
        return jobClient;
    }
}
