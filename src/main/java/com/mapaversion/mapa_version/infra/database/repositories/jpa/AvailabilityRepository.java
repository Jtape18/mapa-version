package com.mapaversion.mapa_version.infra.database.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapaversion.mapa_version.domain.entities.AvailabilityEntity;

@Repository
public interface AvailabilityRepository extends JpaRepository<AvailabilityEntity, Long> {
}
