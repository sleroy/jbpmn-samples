package com.byoskill.pretimmo.frontend_demo.offline;

import com.byoskill.pretimmo.frontend_demo.model.DemandePret;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller("offline")
public class OfflinePretController {

    private List<DemandePret> prets = new ArrayList<>(); // Store submitted requests
    private AtomicLong nextPretId = new AtomicLong(1); // Generate unique IDs

    @GetMapping("/offline")
    public String index(Model model) {
        model.addAttribute("demandePret", new DemandePret()); // Empty object for the form
        model.addAttribute("prets", prets); // Existing requests for the table
        return "connected";
    }

    @PostMapping("/offline/submitPret")
    public String submitPret(@ModelAttribute DemandePret demandePret, Model model) {
        // Set a unique ID for the new request
        demandePret.setPretId(nextPretId.getAndIncrement());

        // Set initial status (you might update this later based on business logic)
        demandePret.setStatus("Soumis"); // Or any other initial status

        // Add the new request to the list
        prets.add(demandePret);

        // Add attributes back to the model for display
        model.addAttribute("demandePret", new DemandePret()); // Clear the form
        model.addAttribute("prets", prets);

        return "connected"; // Redirect back to the same page
    }
}