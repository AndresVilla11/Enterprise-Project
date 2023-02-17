package com.enterprise.joiner.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "joiner", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "identification_number"})})
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class JoinerEntity implements Serializable {
    private static final long serialVersionUID = -428136512535457427L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "identification_number")
    private Long identificationNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @NotBlank
    @Column(name = "stack")
    private String stack;
    @NotBlank
    @Column(name = "role")
    private String role;
    @NotBlank
    @Column(name = "english_level")
    private String englishLevel;
    @NotBlank
    @Column(name = "domain_experience")
    private String domainExperience;
}
