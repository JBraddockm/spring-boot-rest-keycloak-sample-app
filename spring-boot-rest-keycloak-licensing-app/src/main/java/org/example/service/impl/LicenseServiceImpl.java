package org.example.service.impl;

import java.util.List;
import org.example.client.OrganisationFeignClient;
import org.example.model.License;
import org.example.model.Organisation;
import org.example.repository.LicenseRepository;
import org.example.service.LicenseService;
import org.springframework.stereotype.Service;

@Service
public class LicenseServiceImpl implements LicenseService {

  private final LicenseRepository licenseRepository;
  private final OrganisationFeignClient feignClient;

  public LicenseServiceImpl(
      LicenseRepository licenseRepository, OrganisationFeignClient feignClient) {
    this.licenseRepository = licenseRepository;
    this.feignClient = feignClient;
  }

  public License getLicense(Long licenseId, Long organizationId) throws Exception {

    License license =
        licenseRepository.findById(licenseId).orElseThrow(() -> new Exception("License not found"));

    Organisation organisation = retrieveOrganisationInfo(organizationId);

    if (organisation != null) {

      license.setOrganisationName(organisation.getName());
      license.setContactName(organisation.getContactName());
      license.setContactEmail(organisation.getContactEmail());
      license.setContactPhone(organisation.getContactPhone());
    }

    return license;
  }

  private Organisation retrieveOrganisationInfo(Long organizationId) {
    return feignClient.getOrganisation(organizationId);
  }

  public License createLicense(License license) {
    licenseRepository.save(license);
    return license;
  }

  public License updateLicense(License license) {
    licenseRepository.save(license);
    return license;
  }

  public String deleteLicense(Long licenseId) throws Exception {
    License license =
        licenseRepository.findById(licenseId).orElseThrow(() -> new Exception("License not found"));
    licenseRepository.delete(license);
    return "License deleted";
  }

  public List<License> getLicensesByOrganisation(Long organisationId) {
    return licenseRepository.findByOrganisationId(organisationId);
  }
}
