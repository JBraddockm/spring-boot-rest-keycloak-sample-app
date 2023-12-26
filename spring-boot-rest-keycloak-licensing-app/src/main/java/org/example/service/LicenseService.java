package org.example.service;

import java.util.List;
import org.example.model.License;

public interface LicenseService {
  License getLicense(Long licenseId, Long organisationId) throws Exception;

  License createLicense(License license);

  License updateLicense(License license);

  String deleteLicense(Long licenseId) throws Exception;

  List<License> getLicensesByOrganisation(Long organisationId);
}
