package org.example.service;

import org.example.model.Organisation;

import java.util.Optional;

public interface OrganisationService {
    Optional<Organisation> findById(Long organisationId) throws Exception;

    Organisation create(Organisation organisation);

    void delete(Long organisationId);
}
