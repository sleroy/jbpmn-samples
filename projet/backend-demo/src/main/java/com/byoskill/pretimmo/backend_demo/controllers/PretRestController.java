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

    private static final Logger LOGGER = LoggerFactory.getLogger(PretRestController.class);
    private DemandePretRepository demandePretRepository;

    public PretRestController(DemandePretRepository demandePretRepository) {
        this.demandePretRepository = demandePretRepository;
    }

    @PostMapping("/submit")
    public ResponseEntity<DemandePretDTO> submitPret(@RequestBody DemandePretDTO demandePretDTO) {
        try {
            // 1. Log the received request for debugging and auditing.
            LOGGER.info("Received loan request: {}", demandePretDTO);

            // 2. Map the DTO to the Entity
            DemandePret demandePret = mapToEntity(demandePretDTO);



            // 3. Perform business logic (persist to database)
            demandePretRepository.save(demandePret);

            demandePretDTO.setPretId(demandePret.getId());

            // 4. Return a success response (201 Created with the saved object, or 202 Accepted if asynchronous).
            return new ResponseEntity<>(demandePretDTO, HttpStatus.CREATED);

        } catch (Exception e) { // Handle exceptions gracefully
            LOGGER.error("Error processing loan request", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Or a more specific error response
        }
    }



    @GetMapping("/all") // New endpoint to get all loan requests
    public ResponseEntity<List<DemandePretDTO>> getAllPrets() {
        try {
            List<DemandePret> prets = demandePretRepository.findAll();
            // Convert to DTOs (good practice for API responses)
            final List<DemandePretDTO> demandePretDTOS = prets.stream().map(this::mapToDTO).collect(Collectors.toList());
            return new ResponseEntity<>(demandePretDTOS, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error retrieving loan requests", e);
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
