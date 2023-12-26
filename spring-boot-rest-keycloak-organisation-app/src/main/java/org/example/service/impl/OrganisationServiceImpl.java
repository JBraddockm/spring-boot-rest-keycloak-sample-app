package org.example.service.impl;

import org.example.model.Organisation;
import org.example.repository.OrganisationRepository;
import org.example.service.OrganisationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganisationServiceImpl implements OrganisationService {

  private final OrganisationRepository organisationRepository;

  public OrganisationServiceImpl(OrganisationRepository organisationRepository) {
    this.organisationRepository = organisationRepository;
  }

  @Override
  public Organisation create(Organisation organisation) {
    return organisationRepository.save(organisation);
  }

  public Optional<Organisation> findById(Long organisationId) throws Exception {
    return Optional.ofNullable(organisationRepository
            .findById(organisationId)
            .orElseThrow(() -> new Exception("No organisation found")));
  }

  public void delete(Long organisationId) {
    organisationRepository.deleteById(organisationId);
  }
}
