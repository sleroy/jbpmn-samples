package com.byoskill.pretimmo.backend_demo.pret.repositories;

import com.byoskill.pretimmo.backend_demo.pret.entities.DemandePret;

import java.util.List;
import java.util.Optional;


public interface DemandePretService {
    List<DemandePret> findAll();

    <S extends DemandePret> S save(DemandePret entity);

    Optional<DemandePret> findById(Long id);

    boolean existsById(Long id);

    long count();

    void deleteById(Long id);

}