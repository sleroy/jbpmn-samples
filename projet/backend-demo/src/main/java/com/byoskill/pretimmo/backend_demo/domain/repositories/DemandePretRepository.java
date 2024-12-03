package com.byoskill.pretimmo.backend_demo.domain.repositories;

import com.byoskill.pretimmo.backend_demo.domain.entities.DemandePret;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DemandePretRepository extends JpaRepository<DemandePret, Long> {

}