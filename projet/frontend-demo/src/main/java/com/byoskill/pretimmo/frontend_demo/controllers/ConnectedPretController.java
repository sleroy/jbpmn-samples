package com.byoskill.pretimmo.frontend_demo.controllers;

import com.byoskill.pretimmo.frontend_demo.model.DemandePret;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController("connected")
public class ConnectedPretController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectedPretController.class);


    private final RestTemplate restTemplate;

    public ConnectedPretController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("demandePret", new DemandePret()); // Empty object for the form

        List listPrets = getAllPrets();
        model.addAttribute("prets", listPrets); // Existing requests for the table
        return "index";
    }

    private List getAllPrets() {
        ResponseEntity<List> response = restTemplate.getForEntity("/all", List.class);
        List listPrets = response.getBody();
        return listPrets;
    }


    @PostMapping("/connected/submitPret")
    public String submitPret(@ModelAttribute DemandePret demandePret, Model model) {
        try {

            // 2. Make REST call to backend
            ResponseEntity<DemandePret> response = restTemplate.postForEntity(
                    "/submit",
                    demandePret,
                    DemandePret.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                // Success - update the model if needed
                demandePret.setPretId(response.getBody().getPretId());
                // You might also want to refetch the list of prêts from the backend here.

                return "redirect:/connected/"; // Redirect to GET mapping to refresh the page
            } else {
                // Handle error (e.g., display error message)
                model.addAttribute("errorMessage", "Error submitting loan request.");
                LOGGER.error("Failed to submit loan request. Status code: {}", response.getStatusCode());
            }
        } catch (Exception e) {
            // Handle exception (e.g., display error message, log the error)
            model.addAttribute("errorMessage", "An error occurred.");
            LOGGER.error("Exception during loan submission", e);
        }

        // Add attributes back to the model for re-rendering the form
        model.addAttribute("demandePret", demandePret);
        ResponseEntity<List> response = restTemplate.getForEntity("/all", List.class);
        model.addAttribute("prets", response.getBody());

        return "index";  // Re-render the form with error message or stay on same page.
    }


}