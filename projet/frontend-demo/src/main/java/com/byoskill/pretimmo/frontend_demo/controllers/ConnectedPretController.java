package com.byoskill.pretimmo.frontend_demo.controllers;

import com.byoskill.pretimmo.frontend_demo.model.DemandePret;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller("connected")
public class ConnectedPretController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectedPretController.class);
    public static final String TEMPLATE = "connected";

    private final RestTemplate restTemplate;


    public ConnectedPretController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        // Add request/response logging interceptor to RestTemplate
        ClientHttpRequestInterceptor loggingInterceptor = (request, body, execution) -> {
            LOGGER.info("Making request to: {} with body: {}", request.getURI(), new String(body));
            ClientHttpResponse response = execution.execute(request, body);
            LOGGER.info("Received response status: {} with body: {}", response.getStatusCode(), new String(response.getBody().readAllBytes()));
            return response;
        };


        //For Spring Boot 2.3 and later
        this.restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

        this.restTemplate.getInterceptors().add(loggingInterceptor);
    }

    @GetMapping("/connected")
    public String index(Model model) {
        LOGGER.info("Entering index method for connected prêts.");

        model.addAttribute("demandePret", new DemandePret());

        try {
            List listPrets = getAllPrets();
            model.addAttribute("prets", listPrets);
        } catch (Exception e) {
            LOGGER.error("Error retrieving prêts:", e); // Log the error
            model.addAttribute("errorMessage", "Error retrieving loan requests."); // Add error message to the model
        }

        return TEMPLATE;
    }

    private List getAllPrets() {
        ResponseEntity<List> response = restTemplate.getForEntity("/all", List.class);
        return response.getBody();
    }

    @PostMapping("/connected/submitPret")
    public String submitPret(@ModelAttribute DemandePret demandePret, Model model) {
        LOGGER.info("Submitting new prêt: {}", demandePret);

        try {

            // 2. Make REST call to backend
            ResponseEntity<DemandePret> response = restTemplate.postForEntity(
                    "/submit", demandePret, DemandePret.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                LOGGER.info("Successfully submitted prêt. Response: {}", response.getBody());
                return "redirect:/connected";
            } else {
                LOGGER.error("Failed to submit prêt. Status code: {}", response.getStatusCode());
                model.addAttribute("errorMessage", "Error submitting loan request.");
            }
        } catch (Exception e) {
            LOGGER.error("Exception during prêt submission:", e);
            model.addAttribute("errorMessage", "An error occurred.");
        }

        model.addAttribute("demandePret", demandePret);
        List listPrets = getAllPrets();
        model.addAttribute("prets", listPrets); // Existing requests for the table


        return "redirect:/connected";
    }

}