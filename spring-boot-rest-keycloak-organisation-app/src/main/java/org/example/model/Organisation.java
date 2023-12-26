package org.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Organisations")
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Organisation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "organisation_id", nullable = false)
  private Long organisationId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "contact_name", nullable = false)
  private String contactName;

  @Column(name = "contact_email", nullable = false)
  private String contactEmail;

  @Column(name = "contact_phone", nullable = false)
  private String contactPhone;
}
