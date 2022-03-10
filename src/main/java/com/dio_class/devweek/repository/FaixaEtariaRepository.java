package com.dio_class.devweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio_class.devweek.entities.FaixaEtaria;

@Repository
public interface FaixaEtariaRepository extends JpaRepository<FaixaEtaria, Long> {

}
