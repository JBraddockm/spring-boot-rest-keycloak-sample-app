package org.example.repository;

import org.example.model.License;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LicenseRepository extends CrudRepository<License, Long> {
    List<License> findByOrganisationId(Long organisationID);
}
