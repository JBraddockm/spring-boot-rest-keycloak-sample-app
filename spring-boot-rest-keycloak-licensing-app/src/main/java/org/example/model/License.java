package org.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Licenses")
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class License {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "license_id", nullable = false)
  private Long licenseID;

  private String description;

  @Column(name = "organisation_id", nullable = false)
  private Long organisationId;

  @Column(name = "product_name", nullable = false)
  private String productName;

  @Column(name = "license_type", nullable = false)
  private String licenseType;

  @Transient private String organisationName;

  @Transient private String contactName;

  @Transient private String contactPhone;

  @Transient private String contactEmail;
}
