package com.byoskill.pretimmo.backend_demo.pret.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.StringJoiner;

@Entity // Marks this class as a JPA entity
public class DemandePret implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate ID
    private Long id; // Use Long for database IDs


    @Override
    public String toString() {
        return new StringJoiner(", ", DemandePret.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("conditionsFinancieres=" + conditionsFinancieres)
                .add("status='" + status + "'")
                .toString();
    }

    @OneToOne(cascade = CascadeType.ALL) // Embed conditions, cascade operations
    @JoinColumn(name = "conditions_financieres_id") // Join column name
    private ConditionsFinancieres conditionsFinancieres;
    private String status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConditionsFinancieres getConditionsFinancieres() {
        return conditionsFinancieres;
    }

    public void setConditionsFinancieres(ConditionsFinancieres conditionsFinancieres) {
        this.conditionsFinancieres = conditionsFinancieres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}