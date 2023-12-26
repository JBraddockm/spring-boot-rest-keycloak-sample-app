package org.example.controller;

import org.example.model.Organisation;
import org.example.service.OrganisationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organisation")
public class OrganisationController {
  private final OrganisationService organisationService;

  public OrganisationController(OrganisationService organisationService) {
    this.organisationService = organisationService;
  }

  @GetMapping("{organisationId}")
  public ResponseEntity<Organisation> getOrganisationById(@PathVariable("organisationId") Long id)
      throws Exception {
    return ResponseEntity.ok(
        organisationService
            .findById(id)
            .orElseThrow(() -> new Exception("Organisation not found")));
  }

  @PostMapping
  public ResponseEntity<Organisation> createOrganisation(@RequestBody Organisation organisation) {
    return ResponseEntity.status(HttpStatus.CREATED).body(organisationService.create(organisation));
  }

  @DeleteMapping("{organisationId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteOrganisation(@PathVariable("organisationId") Long id) {
    organisationService.delete(id);
  }
}
