package org.example.controller;

import org.example.model.License;
import org.example.service.LicenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/{organisationId}/license")
public class LicenseController {
  private final LicenseService licenseService;

  public LicenseController(LicenseService licenseService) {
    this.licenseService = licenseService;
  }

  @GetMapping("{licenseId}")
  @PreAuthorize("hasAuthority('ADMIN')")
  public ResponseEntity<License> getLicense(
      @PathVariable("organisationId") Long organisationId,
      @PathVariable("licenseId") Long licenseId)
      throws Exception {
    return ResponseEntity.ok(licenseService.getLicense(licenseId, organisationId));
  }

  @PutMapping
  public ResponseEntity<License> updateLicense(@RequestBody License license) {
    return ResponseEntity.ok(licenseService.updateLicense(license));
  }

  @PostMapping
  public ResponseEntity<License> createLicense(@RequestBody License license) {
    return ResponseEntity.ok(licenseService.createLicense(license));
  }

  @DeleteMapping("{licenseId}")
  public ResponseEntity<String> deleteLicense(
      @PathVariable("licenseId") Long licenseId,
      @PathVariable("organisationId") Long organisationId)
      throws Exception {
    return ResponseEntity.ok(licenseService.deleteLicense(licenseId));
  }
}
