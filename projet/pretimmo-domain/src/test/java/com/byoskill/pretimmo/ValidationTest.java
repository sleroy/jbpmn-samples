package com.byoskill.pretimmo;

import java.util.HashMap;
import java.util.List;

import org.jbpm.process.instance.impl.humantask.HumanTaskHandler;
import org.jbpm.services.task.wih.util.LocalHTWorkItemHandlerUtil;
import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkflowProcessInstance;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.Task;

public class ValidationTest extends JbpmJUnitBaseTestCase {

    public ValidationTest() {
        super(true, true);
    }

    @BeforeEach
    public void setUp5() throws Exception {
        System.out.println("Start");
        this.setUp();
    }

    @AfterEach
    public void tearDown5() throws Exception {
        this.tearDown();
    }

    @Test
    public void testProcessusComplexe() {
        RuntimeManager runtimeManager = createRuntimeManager("PretImmobilierProcessus.bpmn");
        RuntimeEngine runtimeEngine = getRuntimeEngine();
        KieSession ksession = runtimeEngine.getKieSession();

        ksession.getWorkItemManager().registerWorkItemHandler("Human Task", new HumanTaskHandler());
        ProcessInstance processInstance = ksession.startProcess("demande_pret_immobilier");

        assertTrue(processInstance != null);

        disposeRuntimeManager();
    }

    // More details here : https://github.com/kiegroup/jbpm/blob/main/jbpm-test-coverage/src/test/java/org/jbpm/test/functional/task/LocalTaskServiceTest.java
    // https://docs.jbpm.org/6.5.0.Beta1/jbpm-docs/html/ch07.html#jBPMTaskServiceDetails
    @Test
    public void testProcessusSimple() {
        RuntimeManager runtimeManager = createRuntimeManager("PretImmobilierProcessusSimple.bpmn");
        RuntimeEngine runtimeEngine = getRuntimeEngine();
        KieSession ksession = runtimeEngine.getKieSession();
        TaskService taskService = runtimeEngine.getTaskService();
        ksession.getWorkItemManager().registerWorkItemHandler("Human Task", new HumanTaskHandler());
        WorkflowProcessInstance processInstance = (WorkflowProcessInstance) ksession.startProcess("PretImmobilierProcessusSimple");
        long pid = processInstance.getId();

        assertProcessInstanceActive(processInstance.getId(), ksession);
        assertNodeTriggered(processInstance.getId(), "Start");

        List<Long> tasks = taskService.getTasksByProcessInstanceId(pid);

        for (Long taskId : tasks) {
            Task task = taskService.getTaskById(taskId);
            taskService.claim(taskId, "wbadmin");
            HashMap<String, Object> values = new HashMap<>();

            taskService.complete(taskId, "wbadmin", values);
        }
        assertProcessInstanceCompleted(pid);

        disposeRuntimeManager();
    }

}
