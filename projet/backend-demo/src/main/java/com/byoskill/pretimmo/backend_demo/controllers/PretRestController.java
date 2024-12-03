package com.byoskill.pretimmo.backend_demo.controllers;

import com.byoskill.pretimmo.backend_demo.controllers.dto.dto.ConditionsFinancieresDTO;
import com.byoskill.pretimmo.backend_demo.controllers.dto.dto.DemandePretDTO;
import com.byoskill.pretimmo.backend_demo.domain.entities.ConditionsFinancieres;
import com.byoskill.pretimmo.backend_demo.domain.entities.DemandePret;
import com.byoskill.pretimmo.backend_demo.domain.repositories.DemandePretRepository;
import com.byoskill.pretimmo.backend_demo.service.JBPMService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pret")
public class PretRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PretRestController.class); // Define the logger
    private final JBPMService jbpmService;
    private final DemandePretRepository demandePretRepository;

    @Value("${jbpm.pret.containerId}")
    private String containerId;
    @Value("${jbpm.pret.processId}")
    private String processId;

    public PretRestController(DemandePretRepository demandePretRepository,
                              JBPMService jbpmService) {
        this.demandePretRepository = demandePretRepository;
        this.jbpmService = jbpmService;
    }

    public JBPMService getJbpmService() {
        return jbpmService;
    }

    public DemandePretRepository getDemandePretRepository() {
        return demandePretRepository;
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @PostMapping("/submit")
    public ResponseEntity<DemandePretDTO> submitPret(@RequestBody DemandePretDTO demandePretDTO) {
        try {
            // Launch the process using JBPM
            return new ResponseEntity<>(demandePretDTO, HttpStatus.CREATED);

        } catch (Exception e) {
            LOGGER.error("Error processing loan request: {}", e.getMessage(), e); // Log the error with stack trace
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<DemandePretDTO>> getAllPrets() {
        try {
            LOGGER.info("Retrieving all loan requests"); // Log the start of retrieval

            List<DemandePret> prets = demandePretRepository.findAll();
            List<DemandePretDTO> demandePretDTOS = prets.stream().map(this::mapToDTO).collect(Collectors.toList());

            LOGGER.info("Retrieved {} loan requests", demandePretDTOS.size());  // Log the number of retrieved requests
            return new ResponseEntity<>(demandePretDTOS, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error retrieving loan requests: {}", e.getMessage(), e); // Log the error with stack trace
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private DemandePretDTO mapToDTO(DemandePret demandePret) {
        DemandePretDTO dto = new DemandePretDTO();
        dto.setPretId(demandePret.getId());

        // Update the status by querying JBPM
        String status = jbpmService.getProcessInstanceStatus(containerId, demandePret.getProcessId());
        demandePret.setStatus(status);

        dto.setStatus(demandePret.getStatus());

        // Map ConditionsFinancieres (assuming you have a ConditionsFinancieresDTO)
        ConditionsFinancieres conditions = demandePret.getConditionsFinancieres();
        if (conditions != null) {
            dto.setConditionsFinancieres(new ConditionsFinancieresDTO(
                    conditions.getMontantDemande(),
                    conditions.getNombreAnnees(),
                    conditions.getRevenuDemandeur(),
                    conditions.getMensualite(),
                    conditions.getInterest()
            ));
        }
        return dto;
    }


}
