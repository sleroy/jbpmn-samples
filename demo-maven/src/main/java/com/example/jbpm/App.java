package com.example.jbpm;

import org.jbpm.process.instance.impl.humantask.HumanTaskHandler;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.getWorkItemManager().registerWorkItemHandler("Human Task", new HumanTaskHandler());
        kieSession.startProcess("PretImmmobilier.OrderApproval");
        kieSession.dispose();
    }
}
