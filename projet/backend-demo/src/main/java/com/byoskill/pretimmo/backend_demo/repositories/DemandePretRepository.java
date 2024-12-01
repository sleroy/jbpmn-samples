package com.byoskill.pretimmo.backend_demo.repositories;

import com.byoskill.pretimmo.backend_demo.pret.entities.DemandePret;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DemandePretRepository extends JpaRepository<DemandePret, Long> {

}