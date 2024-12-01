package com.byoskill.pretimmo;

import org.jbpm.process.instance.impl.humantask.HumanTaskHandler;
import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationTest extends JbpmJUnitBaseTestCase {

    @Test
    public void testPackaging() {
        RuntimeManager runtimeManager = createRuntimeManager("PretImmobilierProcessus.bpmn");

        RuntimeEngine runtimeEngine = runtimeManager.getRuntimeEngine(null);
        KieSession ksession = runtimeEngine.getKieSession();
        ksession.getWorkItemManager().registerWorkItemHandler("Human Task", new HumanTaskHandler());
        ProcessInstance processInstance = ksession.startProcess("demande_pret_immobilier");

        assertTrue(processInstance != null);
    }
}
