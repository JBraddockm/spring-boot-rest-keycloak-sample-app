package org.example.client;

import org.example.model.Organisation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8082/api/v1/organisation", name = "ORGANISATION-CLIENT")
public interface OrganisationFeignClient {
  @GetMapping("/{organisationId}")
  Organisation getOrganisation(@PathVariable("organisationId") Long organisationId);
}
