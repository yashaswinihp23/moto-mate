package com.jsp.moto_mate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.moto_mate.entity.ServiceSelection;

@Repository
public interface ServiceSelectionRepository extends JpaRepository<ServiceSelection, Long> {
}
