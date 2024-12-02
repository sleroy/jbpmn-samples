package com.byoskill.pretimmo.backend_demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.byoskill.pretimmo.ConditionsFinancieresDO;
import com.byoskill.pretimmo.DemandePretDO;
import com.byoskill.pretimmo.ValidationStatusDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byoskill.pretimmo.backend_demo.controllers.dto.dto.ConditionsFinancieresDTO;
import com.byoskill.pretimmo.backend_demo.controllers.dto.dto.DemandePretDTO;
import com.byoskill.pretimmo.backend_demo.domain.entities.ConditionsFinancieres;
import com.byoskill.pretimmo.backend_demo.domain.entities.DemandePret;
import com.byoskill.pretimmo.backend_demo.domain.repositories.DemandePretRepository;
import com.byoskill.pretimmo.backend_demo.service.JBPMService;

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
            LOGGER.info("Received loan request: {}", demandePretDTO); // Log the incoming request

            DemandePret demandePret = mapToEntity(demandePretDTO);

            LOGGER.info("Invoking JBPM to launch a new process instance");
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("pret", mapToDO(demandePret));
            parameters.put("validation", new ValidationStatusDO());
            Long processInstanceId = jbpmService.launchProcessus(containerId, processId, parameters);
            demandePret.setProcessId(processInstanceId);

            demandePret = demandePretRepository.save(demandePret); // Save to database
            LOGGER.info("Saved loan request with ID: {}", demandePret.getId()); // Log the saved entity

            demandePretDTO.setPretId(demandePret.getId());
            return new ResponseEntity<>(demandePretDTO, HttpStatus.CREATED);

        } catch (Exception e) {
            LOGGER.error("Error processing loan request: {}", e.getMessage(), e); // Log the error with stack trace
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private DemandePretDO mapToDO(DemandePret demandePret) {
        DemandePretDO demandePretDO = new DemandePretDO();
        demandePretDO.setStatus(demandePret.getStatus());

        // Assuming ConditionsFinancieres and ConditionsFinancieresDO have the same fields.
        ConditionsFinancieres conditions = demandePret.getConditionsFinancieres();
        if (conditions != null) {

            ConditionsFinancieresDO conditionsFinancieresDO = new ConditionsFinancieresDO();
            conditionsFinancieresDO.setInterest(conditions.getInterest());
            conditionsFinancieresDO.setMensualite(conditions.getMensualite());
            conditionsFinancieresDO.setMontantDemande(conditions.getMontantDemande());
            conditionsFinancieresDO.setNombreAnnees(conditions.getNombreAnnees());
            conditionsFinancieresDO.setRevenuDemandeur(conditions.getRevenuDemandeur());

            demandePretDO.setConditionsFinancieresDO(conditionsFinancieresDO);

        }
        return demandePretDO;
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


    private DemandePret mapToEntity(DemandePretDTO demandePretDTO) {
        DemandePret demandePret = new DemandePret();
        demandePret.setStatus(demandePretDTO.getStatus());
        ConditionsFinancieres conditionsFinancieres = new ConditionsFinancieres();

        conditionsFinancieres.setInterest(demandePretDTO.getConditionsFinancieres().getInterest());
        conditionsFinancieres.setMensualite(demandePretDTO.getConditionsFinancieres().getMensualite());
        conditionsFinancieres.setMontantDemande(demandePretDTO.getConditionsFinancieres().getMontantDemande());
        conditionsFinancieres.setNombreAnnees(demandePretDTO.getConditionsFinancieres().getNombreAnnees());
        conditionsFinancieres.setRevenuDemandeur(demandePretDTO.getConditionsFinancieres().getRevenuDemandeur());
        demandePret.setConditionsFinancieres(conditionsFinancieres);


        return demandePret;
    }
}
