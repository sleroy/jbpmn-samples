package com.byoskill.pretimmo.backend_demo.controllers;

import com.byoskill.pretimmo.backend_demo.dto.ConditionsFinancieresDTO;
import com.byoskill.pretimmo.backend_demo.dto.DemandePretDTO;
import com.byoskill.pretimmo.backend_demo.pret.entities.ConditionsFinancieres;
import com.byoskill.pretimmo.backend_demo.pret.entities.DemandePret;
import com.byoskill.pretimmo.backend_demo.repositories.DemandePretRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pret")
public class PretRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PretRestController.class); // Define the logger
    private DemandePretRepository demandePretRepository;

    public PretRestController(DemandePretRepository demandePretRepository) {
        this.demandePretRepository = demandePretRepository;
    }

    @PostMapping("/submit")
    public ResponseEntity<DemandePretDTO> submitPret(@RequestBody DemandePretDTO demandePretDTO) {
        try {
            LOGGER.info("Received loan request: {}", demandePretDTO); // Log the incoming request

            DemandePret demandePret = mapToEntity(demandePretDTO);
            demandePret = demandePretRepository.save(demandePret); // Save to database
            LOGGER.info("Saved loan request with ID: {}", demandePret.getId()); // Log the saved entity

            demandePretDTO.setPretId(demandePret.getId());
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
